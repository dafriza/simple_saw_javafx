/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.bantukerjaanmu.projectkakfarhan;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author mochammad.angkasa
 */
public class ChooseKriteriaValueController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Stage stage;
    @FXML
    private Button chooseButton;

    @FXML
    private TextField groupField;

    @FXML
    void chooseKriteria(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
//                        "ChooseSawKriteria.fxml"
                        "CalculateProduct.fxml"
                )
        );
        Parent anchorPane = loader.load();
//        Stage stage = new Stage(StageStyle.DECORATED);
//        stage.setScene(
//                new Scene(loader.load())
//        );
//        stage.getScene().setRoot(anchorPane);
//            Scene scene = new Scene((Parent) loader.load());
//            scene.setRoot(loader.load());
        CalculateProductController controller = loader.getController();
        controller.initData(this.groupField.getText());
        loader.setController(controller);
        App.scene.setRoot(anchorPane);
        App.scene.getWindow().sizeToScene();
        App.mainStage.setTitle("Calculate Product");
        this.stage.close();
//            stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initData(Stage stage) {
        this.stage = stage;
//        stage.close();
    }

}
