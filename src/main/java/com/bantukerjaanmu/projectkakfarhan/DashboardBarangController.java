/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.bantukerjaanmu.projectkakfarhan;

import com.bantukerjaanmu.projectkakfarhan.models.BarangModel;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositoryBarang;
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

public class DashboardBarangController implements Initializable {

    private BarangModel barang;
    ResultSet rs;
    Connection conn;
    Statement stmt;
    FXMLLoader loader;
    RepositoryBarang repo;

    @FXML
    TableColumn<BarangModel, Integer> colId;

    @FXML
    TableColumn<BarangModel, String> colBarang;

    @FXML
    TableColumn<BarangModel, String> colGroup;

    @FXML
    TableColumn<BarangModel, String> colTanggal;

    @FXML
    TableView<BarangModel> barangTable;

    @FXML
    Button editButton;

    @FXML
    Button deleteButton;

    @FXML
    Button backButton;

    @FXML
    Button newProductButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        getAllBarang();
        editButton.setDisable(false);
        deleteButton.setDisable(false);
    }

    public void switchToDashboard() throws IOException {
        App.setRoot("Dashboard");
    }

    public void switchToAddProduct() throws IOException {
        App.setRoot("AddProduct");
    }

    @FXML
    private void switchToEditProduct() throws IOException {
        try {
            loader = new FXMLLoader(
                    getClass().getResource(
                            "EditProduct.fxml"
                    )
            );
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(
                    new Scene(loader.load())
            );
            EditProductController controller = loader.getController();
            controller.initData(this.barang, stage, this);
            loader.setController(controller);
            stage.show();
//        return stage;
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

    @FXML
    public void getAllBarang() {
        ObservableList<BarangModel> listBarang = dataBarang();
        colId.setCellValueFactory(new PropertyValueFactory<BarangModel, Integer>("id"));
        colBarang.setCellValueFactory(new PropertyValueFactory<BarangModel, String>("name"));
        colGroup.setCellValueFactory(new PropertyValueFactory<BarangModel, String>("group"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<BarangModel, String>("createdAt"));
        barangTable.setItems(listBarang);
    }

    public ObservableList<BarangModel> dataBarang() {
        ObservableList<BarangModel> barangData = FXCollections.observableArrayList();
        try {
            repo = new RepositoryBarang();
            conn = repo.setConnect();
            stmt = conn.createStatement();
            String sql = "select * from barang";
            rs = stmt.executeQuery(sql);
//            System.out.println("sql result = "+rs.next());
            while (rs.next()) {
//                System.out.println("date = "+rs.getString("created_at") );
                barang = new BarangModel(rs.getInt("id"), rs.getString("name"), rs.getString("group"), rs.getString("created_at"));
                barangData.add(barang);
            }
//            System.out.println(kriteriaData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return barangData;
    }

    @FXML
    public void clickRow() {
        BarangModel barang = barangTable.getSelectionModel().getSelectedItem();
        barang = new BarangModel(barang.getId(), barang.getName(), barang.getGroup(), barang.getCreatedAt());
        this.barang = barang;
    }

    public void delete(ActionEvent event) {
        barang = barangTable.getSelectionModel().getSelectedItem();
        barang = new BarangModel(barang.getId(), barang.getName(), barang.getGroup(), barang.getCreatedAt());
        repo = new RepositoryBarang();
        repo.delete(barang);
        this.getAllBarang();
    }
}
