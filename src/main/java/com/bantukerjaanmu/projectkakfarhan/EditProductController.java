/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.bantukerjaanmu.projectkakfarhan;

import com.bantukerjaanmu.projectkakfarhan.models.BarangModel;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositoryBarang;
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
 * FXML Controller class
 *
 * @author mochammad.angkasa
 */
public class EditProductController implements Initializable {

    public BarangModel barang;
    public DashboardBarangController controller;
    public Stage stage;

    @FXML
    TextField nameField;

    @FXML
    TextField groupField;

    @FXML
    Button updateButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Platform.runLater(() -> {
            System.out.println("Works!");
//            System.out.println(this.kriteria);
            this.nameField.setText(this.barang.getName());
            this.groupField.setText(this.barang.getGroup());
        });
    }
    
    public void initData(BarangModel barang, Stage stage, DashboardBarangController controller){
        this.barang = barang;
        this.stage = stage;
        this.controller = controller;
    }

    public void update(ActionEvent event) {
        try {
            BarangModel model = new BarangModel(this.barang.getId(), this.nameField.getText(), this.groupField.getText());
            RepositoryBarang repo = new RepositoryBarang();
            repo.update(model);
            controller.getAllBarang();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
