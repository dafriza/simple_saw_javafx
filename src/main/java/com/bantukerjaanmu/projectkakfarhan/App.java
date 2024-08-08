package com.bantukerjaanmu.projectkakfarhan;

//import com.bantukerjaanmu.projectkakfarhan.connection.MySQL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Dashboard"));
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        Stage stage = new Stage();
        stage.setTitle(fxml);
        scene.setRoot(loadFXML(fxml));
        scene.getWindow().sizeToScene();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
//        ListKriteriaController test = new ListKriteriaController();
//        test.getAllKriteria();
//        System.err.println("Works!");
        launch();
    }

}
