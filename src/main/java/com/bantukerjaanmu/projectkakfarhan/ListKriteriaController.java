package com.bantukerjaanmu.projectkakfarhan;

import com.bantukerjaanmu.projectkakfarhan.models.KriteriaModel;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositoryKriteria;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ListKriteriaController implements Initializable {

    private KriteriaModel kriteria;
    ResultSet rs;
    Connection conn;
    Statement stmt;
    RepositoryKriteria repo;

    @FXML
    TableView<KriteriaModel> kriteriaTable;

    @FXML
    TableColumn<KriteriaModel, Integer> colId;

    @FXML
    TableColumn<KriteriaModel, String> colKriteria;

    @FXML
    TableColumn<KriteriaModel, String> colKeterangan;

    @FXML
    TableColumn<KriteriaModel, Float> colBobot;

    @FXML
    TableColumn<KriteriaModel, String> colGroup;

    @FXML
    TableColumn<KriteriaModel, String> colType;

    @FXML
    TableColumn<KriteriaModel, String> colTanggal;

    @FXML
    Button editButton;

    @FXML
    Button productTypeButton;

    @FXML
    Button deleteButton;

    @FXML
    Button addValueButton;

    @FXML
    Button calculateButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getAllKriteria();
        addValueButton.setDisable(true);
        editButton.setDisable(true);
        deleteButton.setDisable(true);
    }

    @FXML
    private void switchToDashboard() throws IOException {
        App.setRoot("Dashboard");
    }

    @FXML
    private void switchToAddKriteria() throws IOException {
        App.setRoot("AddKriteria");
    }

    @FXML
    private void switchToProductType() throws IOException {
        App.setRoot("ProductType");
    }

    @FXML
    private void switchToKriteriaDetail() throws IOException {
//        KriteriaDetailController detail = new KriteriaDetailController(clickRow());
//        clickRow();
//        App.setRoot("KriteriaDetail");
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "KriteriaDetail.fxml"
                    )
            );
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(
                    new Scene(loader.load())
            );
            stage.setTitle("Kriteria Detail");
            KriteriaDetailController controller = loader.getController();
            controller.initData(this.kriteria, stage, this);
            loader.setController(controller);
            stage.show();
//        return stage;
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

    @FXML
    private void switchToEditKriteria() throws IOException {
//        KriteriaDetailController detail = new KriteriaDetailController(clickRow());
//        clickRow();
//        App.setRoot("KriteriaDetail");
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "EditKriteria.fxml"
                    )
            );
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(
                    new Scene(loader.load())
            );
            stage.setTitle("Edit Kriteria");
            EditKriteriaController controller = loader.getController();
            controller.initData(this.kriteria, stage, this);
            loader.setController(controller);
            stage.show();
//        return stage;
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

    @FXML
    private void switchToCalculate(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "ChooseKriteriaValue.fxml"
                    )
            );
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(
                    new Scene(loader.load())
            );
            stage.setTitle("Choose Kriteria Value");
            ChooseKriteriaValueController controller = loader.getController();
            controller.initData(stage);
            loader.setController(controller);
            stage.show();
//        return stage;
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

    @FXML
    public void getAllKriteria() {
        ObservableList<KriteriaModel> listKriteria = dataKriteria();
        colId.setCellValueFactory(new PropertyValueFactory<KriteriaModel, Integer>("id"));
        colKriteria.setCellValueFactory(new PropertyValueFactory<KriteriaModel, String>("kriteria"));
        colKeterangan.setCellValueFactory(new PropertyValueFactory<KriteriaModel, String>("keterangan"));
        colBobot.setCellValueFactory(new PropertyValueFactory<KriteriaModel, Float>("bobot"));
        colGroup.setCellValueFactory(new PropertyValueFactory<KriteriaModel, String>("group"));
        colType.setCellValueFactory(new PropertyValueFactory<KriteriaModel, String>("type"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<KriteriaModel, String>("created_at"));
        kriteriaTable.setItems(listKriteria);
    }

    public ObservableList<KriteriaModel> dataKriteria() {
        ObservableList<KriteriaModel> kriteriaData = FXCollections.observableArrayList();
        try {
            RepositoryKriteria repo = new RepositoryKriteria();
            KriteriaModel kriteria;
            conn = repo.setConnect();
            stmt = conn.createStatement();
            String sql = "select * from kriteria";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                kriteria = new KriteriaModel(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("keterangan"),
                        rs.getFloat("bobot"),
                        rs.getString("group"),
                        rs.getString("type"),
                        rs.getString("updated_at")
                );
                kriteriaData.add(kriteria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kriteriaData;
    }

    @FXML
    public void clickRow() {
        KriteriaModel kriteria = kriteriaTable.getSelectionModel().getSelectedItem();
        kriteria = new KriteriaModel(kriteria.getId(), kriteria.getKriteria(), kriteria.getKeterangan(), kriteria.getBobot(), kriteria.getGroup(), kriteria.getType(), kriteria.getCreated_at());
        this.kriteria = kriteria;
        addValueButton.setDisable(false);
        editButton.setDisable(false);
        deleteButton.setDisable(false);
//        System.out.println(kriteria.getKriteria());
    }

    public void calculate(ActionEvent event) {

    }

    public void delete(ActionEvent event) {
        kriteria = kriteriaTable.getSelectionModel().getSelectedItem();
        kriteria = new KriteriaModel(kriteria.getId(), kriteria.getKriteria(), kriteria.getKeterangan(), kriteria.getBobot(), kriteria.getGroup(), kriteria.getType(), kriteria.getCreated_at());
        repo = new RepositoryKriteria();
        repo.delete(kriteria);
        this.getAllKriteria();
    }
}
