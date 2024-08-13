package com.bantukerjaanmu.projectkakfarhan;

import com.bantukerjaanmu.projectkakfarhan.models.BarangModel;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositoryBarang;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AddProductController implements Initializable {

    private BarangModel barang;
    private DashboardBarangController controller;

    @FXML
    TextField barang1;

    @FXML
    TextField barang2;

    @FXML
    TextField barang3;

    @FXML
    TextField barang4;

    @FXML
    TextField barang5;

    @FXML
    TextField groupField;

    @FXML
    Button saveButton;

    @FXML
    Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void switchToDashboardProduct() throws IOException {
        App.setRoot("DashboardBarang");
    }
//    public void initData(BarangModel barang, DashboardBarangController controller){
//        this.barang = barang;
//        this.controller = controller;
//    }

    public void save() {
        try {
            JSONArray dataBarang = new JSONArray();
            dataBarang.add(this.barang1.getText());
            dataBarang.add(this.barang2.getText());
            dataBarang.add(this.barang3.getText());
            dataBarang.add(this.barang4.getText());
            dataBarang.add(this.barang5.getText());
            JSONArray realData = checkIfNull(dataBarang);
//            BarangModel model = new BarangModel(dataBarang, this.groupField.getText());
            BarangModel model = new BarangModel(realData, this.groupField.getText());
            RepositoryBarang repo = new RepositoryBarang();
            repo.save(model);
            switchToDashboardProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JSONArray checkIfNull(JSONArray rawData) {
        JSONArray realData = new JSONArray();
        for (int i = 0; i < rawData.size(); i++) {
            if (!rawData.get(i).toString().isEmpty()) {
                realData.add(rawData.get(i));
            }
        }
        System.out.println(realData);
        return realData;
//        return null;
    }
}
