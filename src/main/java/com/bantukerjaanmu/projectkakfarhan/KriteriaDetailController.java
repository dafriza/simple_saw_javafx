package com.bantukerjaanmu.projectkakfarhan;

import com.bantukerjaanmu.projectkakfarhan.models.KriteriaDetailModel;
import com.bantukerjaanmu.projectkakfarhan.models.KriteriaModel;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositoryKriteria;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositoryKriteriaDetail;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class KriteriaDetailController implements Initializable {

    private KriteriaModel kriteria;

    @FXML
    TextField groupField;

    @FXML
    TextField spekProduk;

    @FXML
    TextField spekProduk1;

    @FXML
    TextField kategori1;

    @FXML
    TextField nilai1;

    @FXML
    TextField spekProduk2;

    @FXML
    TextField kategori2;

    @FXML
    TextField nilai2;

    @FXML
    TextField spekProduk3;

    @FXML
    TextField kategori3;

    @FXML
    TextField nilai3;

    @FXML
    TextField spekProduk4;

    @FXML
    TextField kategori4;

    @FXML
    TextField nilai4;

    @FXML
    TextField spekProduk5;

    @FXML
    TextField kategori5;

    @FXML
    TextField nilai5;

    @FXML
    Button buttonSave;

    @FXML
    Button buttonBack;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        this.kriteria = kriteria;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Platform.runLater(() -> {
            System.out.println("Works!");
            System.out.println(this.kriteria);
            this.groupField.setText(this.kriteria.getGroup());
            this.spekProduk.setText(this.kriteria.getKeterangan());
        });
    }

    void initData(KriteriaModel kriteria) {
//    customerName.setText(customer.getName());
        this.kriteria = kriteria;
    }

    @FXML
    private void switchToListKriteria() throws IOException {
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

            kriteria1.put("skala_produk", spekProduk1.getText());
            kriteria1.put("kategori", kategori1.getText());
            kriteria1.put("nilai", nilai1.getText());

            kriteria2.put("skala_produk", spekProduk2.getText());
            kriteria2.put("kategori", kategori2.getText());
            kriteria2.put("nilai", nilai2.getText());

            kriteria3.put("skala_produk", spekProduk3.getText());
            kriteria3.put("kategori", kategori3.getText());
            kriteria3.put("nilai", nilai3.getText());

            kriteria4.put("skala_produk", spekProduk4.getText());
            kriteria4.put("kategori", kategori4.getText());
            kriteria4.put("nilai", nilai4.getText());

            kriteria5.put("skala_produk", spekProduk5.getText());
            kriteria5.put("kategori", kategori5.getText());
            kriteria5.put("nilai", nilai5.getText());

            kriteriaArray.add(kriteria1);
            kriteriaArray.add(kriteria2);
            kriteriaArray.add(kriteria3);
            kriteriaArray.add(kriteria4);
            kriteriaArray.add(kriteria5);

            JSONArray realData = checkIfNull(kriteriaArray);
            mainObject.put("data", realData);
            mainObject.put("group", groupField.getText());
            ZoneId timeZone = ZoneId.of("Asia/Jakarta");
            KriteriaDetailModel model = new KriteriaDetailModel(this.kriteria.getId(), mainObject, LocalDate.now(timeZone));
            RepositoryKriteriaDetail repo = new RepositoryKriteriaDetail();
            repo.save(model, this.kriteria.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JSONArray checkIfNull(JSONArray data) {
        int increment = 1;
        JSONArray realData = new JSONArray();
        for (Object object : data) {
            JSONObject item = (JSONObject) object;
//            System.out.println(item.get("nilai"));
            if (!item.get("nilai").toString().isEmpty()) {
                realData.add(object);
            }
        }
        System.out.println(realData);
        return realData;
//        return null;
    }
}
