/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.bantukerjaanmu.projectkakfarhan;

import com.bantukerjaanmu.projectkakfarhan.models.SawBobotKriteriaModel;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositoryBase;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositorySawBobot;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ChooseSawKriteriaController implements Initializable {

    public String group;
    ResultSet rs;
    Connection conn;
    Statement stmt;
    FXMLLoader loader;
    RepositoryBase repo;
    JSONObject objData;
    JSONObject objDataKeterangan;
    JSONObject objDataId;
    JSONObject objDataArray;

    @FXML
    private Button backButton;

    @FXML
    private ChoiceBox<Integer> bobotChoiceFifth;

    @FXML
    private ChoiceBox<Integer> bobotChoiceFirst;

    @FXML
    private ChoiceBox<Integer> bobotChoiceFourth;

    @FXML
    private ChoiceBox<Integer> bobotChoiceSecond;

    @FXML
    private ChoiceBox<Integer> bobotChoiceThird;

    @FXML
    private ChoiceBox<String> kriteriaChoiceFifth;

    @FXML
    private ChoiceBox<String> kriteriaChoiceFirst;

    @FXML
    private ChoiceBox<String> kriteriaChoiceFourth;

    @FXML
    private ChoiceBox<String> kriteriaChoiceSecond;

    @FXML
    private ChoiceBox<String> kriteriaChoiceThird;

    @FXML
    private TextField bobotFieldFifth;

    @FXML
    private TextField bobotFieldFirst;

    @FXML
    private TextField bobotFieldFourth;

    @FXML
    private TextField bobotFieldSecond;

    @FXML
    private TextField bobotFieldThird;

//    @FXML
//    private Button saveButton;
    
    @FXML
    private Button calculateButton;

    @FXML
    void switchToListKriteria() throws IOException {
        App.setRoot("ListKriteria");
    }
    
    @FXML
    void switchToProductType() throws IOException {
        App.setRoot("ProductType");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Platform.runLater(() -> {
            System.out.println("group = " + this.group);
            getKriteriaData();
        });
    }

    public void initData(String group) {
        this.group = group;
        kriteriaChoiceFirst.setOnAction(this::choiceKriteriaBobotFirst);
        kriteriaChoiceSecond.setOnAction(this::choiceKriteriaBobotSecond);
        kriteriaChoiceThird.setOnAction(this::choiceKriteriaBobotThird);
        kriteriaChoiceFourth.setOnAction(this::choiceKriteriaBobotFourth);
        kriteriaChoiceFifth.setOnAction(this::choiceKriteriaBobotFifth);

        bobotChoiceFirst.setOnAction(this::setTextFieldFirst);
        bobotChoiceSecond.setOnAction(this::setTextFieldSecond);
        bobotChoiceThird.setOnAction(this::setTextFieldThird);
        bobotChoiceFourth.setOnAction(this::setTextFieldFourth);
        bobotChoiceFifth.setOnAction(this::setTextFieldFifth);
    }

    public void getKriteriaData() {
        try {
            repo = new RepositoryBase();
            conn = repo.setConnect();
            stmt = conn.createStatement();
            String sql = "select * from kriteria where `group` = '%s'";
            sql = String.format(sql, this.group);
            rs = stmt.executeQuery(sql);
//            System.out.println("sql result = "+rs.next());
            objData = new JSONObject();
            while (rs.next()) {
                kriteriaChoiceFirst.getItems().add(rs.getString("name"));
                kriteriaChoiceSecond.getItems().add(rs.getString("name"));
                kriteriaChoiceThird.getItems().add(rs.getString("name"));
                kriteriaChoiceFourth.getItems().add(rs.getString("name"));
                kriteriaChoiceFifth.getItems().add(rs.getString("name"));
                objData.put(rs.getString("name"), rs.getInt("id"));
            }
            System.out.println(objData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void choiceKriteriaBobotFirst(ActionEvent event) {
        Integer kriteriaType = (Integer) objData.get((String) kriteriaChoiceFirst.getValue());
        queryBobotKriteria(kriteriaType, bobotChoiceFirst);
    }

    public void choiceKriteriaBobotSecond(ActionEvent event) {
        Integer kriteriaType = (Integer) objData.get((String) kriteriaChoiceSecond.getValue());
        queryBobotKriteria(kriteriaType, bobotChoiceSecond);
    }

    public void choiceKriteriaBobotThird(ActionEvent event) {
        Integer kriteriaType = (Integer) objData.get((String) kriteriaChoiceThird.getValue());
        queryBobotKriteria(kriteriaType, bobotChoiceThird);
    }

    public void choiceKriteriaBobotFourth(ActionEvent event) {
        Integer kriteriaType = (Integer) objData.get((String) kriteriaChoiceFourth.getValue());
        queryBobotKriteria(kriteriaType, bobotChoiceFourth);
    }

    public void choiceKriteriaBobotFifth(ActionEvent event) {
        Integer kriteriaType = (Integer) objData.get((String) kriteriaChoiceFifth.getValue());
        queryBobotKriteria(kriteriaType, bobotChoiceFifth);
    }

    public void setTextFieldFirst(ActionEvent event) {
//        System.out.println("test + "+objDataKeterangan);
        bobotFieldFirst.setText((String) objDataKeterangan.get(bobotChoiceFirst.getValue()));
//        bobotFieldFirst.setText("hehe");
    }

    public void setTextFieldSecond(ActionEvent event) {
        bobotFieldSecond.setText((String) objDataKeterangan.get(bobotChoiceSecond.getValue()));
    }

    public void setTextFieldThird(ActionEvent event) {
        bobotFieldThird.setText((String) objDataKeterangan.get(bobotChoiceThird.getValue()));
    }

    public void setTextFieldFourth(ActionEvent event) {
        bobotFieldFourth.setText((String) objDataKeterangan.get(bobotChoiceFourth.getValue()));
    }

    public void setTextFieldFifth(ActionEvent event) {
        bobotFieldFifth.setText((String) objDataKeterangan.get(bobotChoiceFifth.getValue()));
    }

    public void queryBobotKriteria(Integer id, ChoiceBox<Integer> choiceBox) {
        try {
            repo = new RepositoryBase();
            conn = repo.setConnect();
            stmt = conn.createStatement();
            String sql = "select * from bobot_kriteria where `kriteria_id` = '%d'";
            sql = String.format(sql, id);
            rs = stmt.executeQuery(sql);
//            System.out.println("sql result = "+rs.next());
            objDataKeterangan = new JSONObject();
            while (rs.next()) {
                choiceBox.getItems().add(rs.getInt("nilai"));
//                objDataKeterangan.put("id", id);
                objDataKeterangan.put(rs.getInt("nilai"), rs.getString("kategori"));
//                objDataKeterangan.put("keterangan", rs.getString("keterangan"));
//                objData.put(rs.getString("name"), rs.getInt("id"));
            }
//            System.out.println(objData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @FXML
//    void save(ActionEvent event) {
//        try {
//            JSONObject mainDataFirst = new JSONObject();
//            JSONObject mainDataSecond = new JSONObject();
//            JSONObject mainDataThird = new JSONObject();
//            JSONObject mainDataFourth = new JSONObject();
//            JSONObject mainDataFifth = new JSONObject();
//            JSONArray rawData = new JSONArray();
//            mainDataFirst.put("kriteria", (String) kriteriaChoiceFirst.getValue());
//            mainDataFirst.put("bobot", bobotChoiceFirst.getValue());
//            mainDataFirst.put("keterangan", (String) bobotFieldFirst.getText());
//
//            mainDataSecond.put("kriteria", (String) kriteriaChoiceSecond.getValue());
//            mainDataSecond.put("bobot", bobotChoiceSecond.getValue());
//            mainDataSecond.put("keterangan", (String) bobotFieldSecond.getText());
//
//            mainDataThird.put("kriteria", (String) kriteriaChoiceThird.getValue());
//            mainDataThird.put("bobot", bobotChoiceThird.getValue());
//            mainDataThird.put("keterangan", (String) bobotFieldThird.getText());
//
//            mainDataFourth.put("kriteria", (String) kriteriaChoiceFourth.getValue());
//            mainDataFourth.put("bobot", bobotChoiceFourth.getValue());
//            mainDataFourth.put("keterangan", (String) bobotFieldFourth.getText());
//
//            mainDataFifth.put("kriteria", (String) kriteriaChoiceFifth.getValue());
//            mainDataFifth.put("bobot", bobotChoiceFifth.getValue());
//            mainDataFifth.put("keterangan", (String) bobotFieldFifth.getText());
//
//            rawData.add(mainDataFirst);
//            rawData.add(mainDataSecond);
//            rawData.add(mainDataThird);
//            rawData.add(mainDataFourth);
//            rawData.add(mainDataFifth);
////            dataBarang.add(this.barang1.getText());
////            dataBarang.add(this.barang2.getText());
////            dataBarang.add(this.barang3.getText());
////            dataBarang.add(this.barang4.getText());
////            dataBarang.add(this.barang5.getText());
////            JSONArray realData = checkIfNull(dataBarang);
////            BarangModel model = new BarangModel(dataBarang, this.groupField.getText());
//            SawBobotKriteriaModel model = new SawBobotKriteriaModel(rawData);
//            RepositorySawBobot repo = new RepositorySawBobot();
//            repo.save(model);
//            switchToProductType();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
