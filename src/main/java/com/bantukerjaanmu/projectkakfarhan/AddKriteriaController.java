package com.bantukerjaanmu.projectkakfarhan;

import com.bantukerjaanmu.projectkakfarhan.models.KriteriaModel;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositoryKriteria;
import org.json.simple.*;

public class AddKriteriaController {

    @FXML
    public TextField c1kriteria;

    @FXML
    public TextField c1kategori;

    @FXML
    public TextField c2kriteria;

    @FXML
    public TextField c2kategori;

    @FXML
    public TextField c3kriteria;

    @FXML
    public TextField c3kategori;

    @FXML
    public TextField c4kriteria;

    @FXML
    public TextField c4kategori;

    @FXML
    public TextField c5kriteria;

    @FXML
    public TextField c5kategori;

    @FXML
    public TextField groupField;

    @FXML
    public Button saveButton;

    @FXML
    public void switchToListKriteria() throws IOException {
        App.setRoot("ListKriteria");
    }

    public void save() {
        try {
            JSONObject mainObject = new JSONObject();
            JSONArray kriteriaArray = new JSONArray();
            JSONObject kriteria1 = new JSONObject();
            JSONObject kriteria2 = new JSONObject();
            JSONObject kriteria3 = new JSONObject();
            JSONObject kriteria4 = new JSONObject();
            JSONObject kriteria5 = new JSONObject();

            kriteria1.put("kriteria", c1kriteria.getText());
            kriteria1.put("kategori", c1kategori.getText());
            kriteria2.put("kriteria", c2kriteria.getText());
            kriteria2.put("kategori", c2kategori.getText());
            kriteria3.put("kriteria", c3kriteria.getText());
            kriteria3.put("kategori", c3kategori.getText());
            kriteria4.put("kriteria", c4kriteria.getText());
            kriteria4.put("kategori", c4kategori.getText());
            kriteria5.put("kriteria", c5kriteria.getText());
            kriteria5.put("kategori", c5kategori.getText());

            kriteriaArray.add(kriteria1);
            kriteriaArray.add(kriteria2);
            kriteriaArray.add(kriteria3);
            kriteriaArray.add(kriteria4);
            kriteriaArray.add(kriteria5);

            JSONArray realData = checkIfNull(kriteriaArray);
            mainObject.put("data", realData);
            mainObject.put("group", groupField.getText());
            KriteriaModel model = new KriteriaModel(mainObject);
            RepositoryKriteria repo = new RepositoryKriteria();
            repo.save(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JSONArray checkIfNull(JSONArray data) {
        int increment = 1;
        JSONArray realData = new JSONArray();
        for (Object object : data) {
            JSONObject item = (JSONObject) object;
            if (!item.get("kategori").toString().isEmpty()) {
                realData.add(object);
            }
        }
//        System.out.println(realData);
        return realData;
//        return null;
    }
}
