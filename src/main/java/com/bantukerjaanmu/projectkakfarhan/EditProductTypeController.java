/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bantukerjaanmu.projectkakfarhan;

import com.bantukerjaanmu.projectkakfarhan.models.BarangModel;
import com.bantukerjaanmu.projectkakfarhan.models.ProductTypeModel;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositoryBarang;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositoryProductType;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author mochammad.angkasa
 */
public class EditProductTypeController implements Initializable {

    public ProductTypeModel productType;
    public ProductTypeController controller;
    public Stage stage;

    @FXML
    private TextField groupField;

    @FXML
    private TextField jenisKriteriaField;

    @FXML
    private TextField kategoriField;

    @FXML
    private TextField nilaiField;

    @FXML
    private Button updateButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Platform.runLater(() -> {
            System.out.println("Works!");
//            System.out.println(this.kriteria);
            this.groupField.setText(this.productType.getGroup());
        });
    }

    public void initData(ProductTypeModel productType, Stage stage, ProductTypeController controller) {
        this.productType = productType;
        this.stage = stage;
        this.controller = controller;
    }

    public void update(ActionEvent event) {
        try {
            ProductTypeModel model = new ProductTypeModel(
                    this.productType.getId(),
                    this.jenisKriteriaField.getText(),
                    this.kategoriField.getText(),
                    Integer.valueOf(this.nilaiField.getText())
            );
            RepositoryProductType repo = new RepositoryProductType();
            repo.update(model);
            controller.getAllProductType();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
