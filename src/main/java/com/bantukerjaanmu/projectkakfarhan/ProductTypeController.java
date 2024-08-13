/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.bantukerjaanmu.projectkakfarhan;

import com.bantukerjaanmu.projectkakfarhan.models.BobotKriteriaModel;
import com.bantukerjaanmu.projectkakfarhan.models.ProductTypeModel;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositoryProductType;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author mochammad.angkasa
 */
public class ProductTypeController implements Initializable {

    private ProductTypeModel productType;
    private BobotKriteriaModel bobotKriteria;
    ResultSet rs;
    Connection conn;
    Statement stmt;
    FXMLLoader loader;
    RepositoryProductType repo;

    @FXML
    private TableColumn<ProductTypeModel, String> colGroup;

    @FXML
    private TableColumn<ProductTypeModel, Integer> colId;

    @FXML
    private TableColumn<ProductTypeModel, String> colJenisKriteria;

    @FXML
    private TableColumn<ProductTypeModel, String> colKategori;

    @FXML
    private TableColumn<ProductTypeModel, Integer> colNilai;

    @FXML
    private TableColumn<ProductTypeModel, String> colKriteria;

    @FXML
    private TableColumn<ProductTypeModel, String> colTanggal;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private Button listKriteriaButton;

    @FXML
    private Button editBobotButton;

    @FXML
    private TableView<ProductTypeModel> productTypeTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        getAllProductType();
    }

    @FXML
    void switchToListKriteria(ActionEvent event) throws IOException {
        App.setRoot("ListKriteria");
    }

    @FXML
    private void switchToEditTypeProduct() throws IOException {
        try {
            loader = new FXMLLoader(
                    getClass().getResource(
                            "EditProductType.fxml"
                    )
            );
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(
                    new Scene(loader.load())
            );
            EditProductTypeController controller = loader.getController();
            controller.initData(this.productType, stage, this);
            loader.setController(controller);
            stage.show();
//        return stage;
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

    @FXML
    private void switchToChooseKriteriaValue() throws IOException {
        try {
            loader = new FXMLLoader(
                    getClass().getResource(
                            "ChooseKriteriaValue.fxml"
                    )
            );
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(
                    new Scene(loader.load())
            );
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
    void switchToEditBobot(ActionEvent event) throws IOException {
//        App.setRoot("ListKriteria");
    }

    @FXML
    void switchToSAWAlgorithmButton(ActionEvent event) throws IOException {
//        App.setRoot("ListKriteria");
    }

    @FXML
    public void getAllProductType() {
        ObservableList<ProductTypeModel> listProductType = dataProductType();
        colId.setCellValueFactory(new PropertyValueFactory<ProductTypeModel, Integer>("id"));
        colJenisKriteria.setCellValueFactory(new PropertyValueFactory<ProductTypeModel, String>("jenisKriteria"));
        colKategori.setCellValueFactory(new PropertyValueFactory<ProductTypeModel, String>("kategori"));
        colNilai.setCellValueFactory(new PropertyValueFactory<ProductTypeModel, Integer>("nilai"));
        colGroup.setCellValueFactory(new PropertyValueFactory<ProductTypeModel, String>("group"));
        colKriteria.setCellValueFactory(new PropertyValueFactory<ProductTypeModel, String>("kriteria"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<ProductTypeModel, String>("updatedAt"));
        productTypeTable.setItems(listProductType);
    }

    public ObservableList<ProductTypeModel> dataProductType() {
        ObservableList<ProductTypeModel> productTypeData = FXCollections.observableArrayList();
        try {
            repo = new RepositoryProductType();
            conn = repo.setConnect();
            stmt = conn.createStatement();
//            String sql = "select * from bobot_kriteria";
            String sql = "SELECT bobot_kriteria.id,jenis_kriteria,kategori,nilai,kriteria.group, kriteria.name, bobot_kriteria.updated_at FROM `bobot_kriteria`\n"
                    + "join kriteria on  \n"
                    + "bobot_kriteria.kriteria_id = kriteria.id;";
            rs = stmt.executeQuery(sql);
//            System.out.println("sql result = "+rs.next());
            while (rs.next()) {
//                System.out.println("date = "+rs.getString("created_at") );
                productType = new ProductTypeModel(rs.getInt("id"),
                        rs.getString("jenis_kriteria"),
                        rs.getString("kategori"),
                        rs.getInt("nilai"),
                        rs.getString("group"),
                        rs.getString("name"),
                        rs.getString("updated_at"));
                productTypeData.add(productType);
            }
//            System.out.println(kriteriaData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productTypeData;
    }

    @FXML
    void clickRow(MouseEvent event) {
        productType = productTypeTable.getSelectionModel().getSelectedItem();
//        productType = new BarangModel(barang.getId(), barang.getName(), barang.getGroup(), barang.getCreatedAt());
//        this.productType = productType;
    }

    @FXML
    void delete(ActionEvent event) {
        productType = productTypeTable.getSelectionModel().getSelectedItem();
        productType = new ProductTypeModel(productType.getId());
        repo = new RepositoryProductType();
        repo.delete(productType);
        this.getAllProductType();
    }

}
