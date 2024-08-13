/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.bantukerjaanmu.projectkakfarhan;

import com.bantukerjaanmu.projectkakfarhan.models.BarangModel;
import com.bantukerjaanmu.projectkakfarhan.models.DataPenelitianModel;
import com.bantukerjaanmu.projectkakfarhan.models.KriteriaModel;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositoryBase;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositoryDataPenelitian;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositoryKriteria;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CalculateProductController implements Initializable {

    public String group;
    private BarangModel barang;
    ResultSet rs;
    Connection conn;
    Statement stmt;
    FXMLLoader loader;
    RepositoryBase repo;
    Stage stage;
    JSONArray bobotKriteria;
    int[] barangList;

    @FXML
    private Button backButton;

    @FXML
    private ChoiceBox<Integer> cbC1Fifth;

    @FXML
    private ChoiceBox<Integer> cbC1First;

    @FXML
    private ChoiceBox<Integer> cbC1Fourth;

    @FXML
    private ChoiceBox<Integer> cbC1Second;

    @FXML
    private ChoiceBox<Integer> cbC1Third;

    @FXML
    private ChoiceBox<Integer> cbC2Fifth;

    @FXML
    private ChoiceBox<Integer> cbC2First;

    @FXML
    private ChoiceBox<Integer> cbC2Fourth;

    @FXML
    private ChoiceBox<Integer> cbC2Second;

    @FXML
    private ChoiceBox<Integer> cbC2Third;

    @FXML
    private ChoiceBox<Integer> cbC3Fifth;

    @FXML
    private ChoiceBox<Integer> cbC3First;

    @FXML
    private ChoiceBox<Integer> cbC3Fourth;

    @FXML
    private ChoiceBox<Integer> cbC3Second;

    @FXML
    private ChoiceBox<Integer> cbC3Third;

    @FXML
    private ChoiceBox<Integer> cbC4Fifth;

    @FXML
    private ChoiceBox<Integer> cbC4First;

    @FXML
    private ChoiceBox<Integer> cbC4Fourth;

    @FXML
    private ChoiceBox<Integer> cbC4Second;

    @FXML
    private ChoiceBox<Integer> cbC4Third;

    @FXML
    private ChoiceBox<Integer> cbC5Fifth;

    @FXML
    private ChoiceBox<Integer> cbC5First;

    @FXML
    private ChoiceBox<Integer> cbC5Fourth;

    @FXML
    private ChoiceBox<Integer> cbC5Second;

    @FXML
    private ChoiceBox<Integer> cbC5Third;

    @FXML
    private Label titleFifth;

    @FXML
    private Label titleFirst;

    @FXML
    private Label titleFourth;

    @FXML
    private Label titleSecond;

    @FXML
    private Label titleThird;

    @FXML
    private TextField kriteriaFifthField;

    @FXML
    private TextField kriteriaFirstField;

    @FXML
    private TextField kriteriaFourthField;

    @FXML
    private TextField kriteriaSecondField;

    @FXML
    private TextField kriteriaThirdField;

    @FXML
    private Button calculateButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Platform.runLater(() -> {
            initializeProduct();
            initializeTitleKriteria();
            initializeChoiceBoxKriteria();
        });
    }

    public void initData(String group) {
        this.group = group;
    }

    @FXML
    void calculate(ActionEvent event) {
        int firstColumn[] = {
            cbC1First.getValue(),
            cbC1Second.getValue(),
            cbC1Third.getValue(),
            cbC1Fourth.getValue(),
            cbC1Fifth.getValue()
        };
        int secondColumn[] = {
            cbC2First.getValue(),
            cbC2Second.getValue(),
            cbC2Third.getValue(),
            cbC2Fourth.getValue(),
            cbC2Fifth.getValue()
        };
        int thirdColumn[] = {
            cbC3First.getValue(),
            cbC3Second.getValue(),
            cbC3Third.getValue(),
            cbC3Fourth.getValue(),
            cbC3Fifth.getValue()
        };
        int fourthColumn[] = {
            cbC4First.getValue(),
            cbC4Second.getValue(),
            cbC4Third.getValue(),
            cbC4Fourth.getValue(),
            cbC4Fifth.getValue()
        };
        int fifthColumn[] = {
            cbC5First.getValue(),
            cbC5Second.getValue(),
            cbC5Third.getValue(),
            cbC5Fourth.getValue(),
            cbC5Fifth.getValue()};

        Arrays.sort(firstColumn);
        Arrays.sort(secondColumn);
        Arrays.sort(thirdColumn);
        Arrays.sort(fourthColumn);
        Arrays.sort(fifthColumn);

        int dividerFirst = firstColumn[firstColumn.length - 1];
        int dividerSecond = secondColumn[0];
        int dividerThird = thirdColumn[thirdColumn.length - 1];
        int dividerFourth = fourthColumn[fourthColumn.length - 1];
        int dividerFifth = fifthColumn[0];

        float firstCalculateC1 = cbC1First.getValue() / dividerFirst;
        float secondCalculateC1 = cbC1Second.getValue() / dividerFirst;
        float thirdCalculateC1 = cbC1Third.getValue() / dividerFirst;
        float fourthCalculateC1 = cbC1Fourth.getValue() / dividerFirst;
        float fifthCalculateC1 = cbC1Fifth.getValue() / dividerFirst;
        float firstRow[] = {firstCalculateC1, secondCalculateC1, thirdCalculateC1, fourthCalculateC1, fifthCalculateC1};

        float firstCalculateC2 = cbC2First.getValue() / dividerSecond;
        float secondCalculateC2 = cbC2Second.getValue() / dividerSecond;
        float thirdCalculateC2 = cbC2Third.getValue() / dividerSecond;
        float fourthCalculateC2 = cbC2Fourth.getValue() / dividerSecond;
        float fifthCalculateC2 = cbC2Fifth.getValue() / dividerSecond;
        float secondRow[] = {firstCalculateC2, secondCalculateC2, thirdCalculateC2, fourthCalculateC2, fifthCalculateC2};

        float firstCalculateC3 = cbC3First.getValue() / dividerThird;
        float secondCalculateC3 = cbC3Second.getValue() / dividerThird;
        float thirdCalculateC3 = cbC3Third.getValue() / dividerThird;
        float fourthCalculateC3 = cbC3Fourth.getValue() / dividerThird;
        float fifthCalculateC3 = cbC3Fifth.getValue() / dividerThird;
        float thirdRow[] = {firstCalculateC3, secondCalculateC3, thirdCalculateC3, fourthCalculateC3, fifthCalculateC3};

        float firstCalculateC4 = cbC4First.getValue() / dividerFourth;
        float secondCalculateC4 = cbC4Second.getValue() / dividerFourth;
        float thirdCalculateC4 = cbC4Third.getValue() / dividerFourth;
        float fourthCalculateC4 = cbC4Fourth.getValue() / dividerFourth;
        float fifthCalculateC4 = cbC4Fifth.getValue() / dividerFourth;
        float fourthRow[] = {firstCalculateC4, secondCalculateC4, thirdCalculateC4, fourthCalculateC4, fifthCalculateC4};

        float firstCalculateC5 = cbC5First.getValue() / dividerFifth;
        float secondCalculateC5 = cbC5Second.getValue() / dividerFifth;
        float thirdCalculateC5 = cbC5Third.getValue() / dividerFifth;
        float fourthCalculateC5 = cbC5Fourth.getValue() / dividerFifth;
        float fifthCalculateC5 = cbC5Fifth.getValue() / dividerFifth;
        float fifthRow[] = {firstCalculateC5, secondCalculateC5, thirdCalculateC5, fourthCalculateC5, fifthCalculateC5};

        float resultFirst = calculateBobot(firstRow);
        float resultSecond = calculateBobot(secondRow);
        float resultThird = calculateBobot(thirdRow);
        float resultFourth = calculateBobot(fourthRow);
        float resultFifth = calculateBobot(fifthRow);
        float resultArray[] = {resultFirst, resultSecond, resultThird, resultFourth, resultFifth};
        saveDataPenelitian(barangList, resultArray);
    }

    @FXML
    void switchToListKriteria(ActionEvent event) throws IOException {
        App.setRoot("ListKriteria");
    }

    public void initializeProduct() {
        try {
            barangList = new int[5];
            repo = new RepositoryBase();
            conn = repo.setConnect();
            stmt = conn.createStatement();
            String sqlBarang = "select * from barang where `group` = '%s'";
            sqlBarang = String.format(sqlBarang, this.group);
            rs = stmt.executeQuery(sqlBarang);
//            System.out.println("sql result = " + rs);
//            objData = new JSONObject();
//            while (rs.next()) {
            rs.next();
            barangList[0] = rs.getInt("id");
            kriteriaFirstField.setText(rs.getString("name"));

            rs.next();
            barangList[1] = rs.getInt("id");
            kriteriaSecondField.setText(rs.getString("name"));

            rs.next();
            barangList[2] = rs.getInt("id");
            kriteriaThirdField.setText(rs.getString("name"));

            rs.next();
            barangList[3] = rs.getInt("id");
            kriteriaFourthField.setText(rs.getString("name"));

            rs.next();
            barangList[4] = rs.getInt("id");
            kriteriaFifthField.setText(rs.getString("name"));
//            }
//            System.out.println(objData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initializeTitleKriteria() {
        try {
            bobotKriteria = new JSONArray();
            repo = new RepositoryBase();
            conn = repo.setConnect();
            stmt = conn.createStatement();
            String sqlKriteria = "select * from kriteria where `group` = '%s'";
            sqlKriteria = String.format(sqlKriteria, this.group);
            rs = stmt.executeQuery(sqlKriteria);
//            System.out.println("sql result = " + rs);
//            objData = new JSONObject();
//            while (rs.next()) {
            rs.next();
            bobotKriteria.add(rs.getFloat("bobot"));
            titleFirst.setText(rs.getString("name"));
            rs.next();
            bobotKriteria.add(rs.getFloat("bobot"));
            titleSecond.setText(rs.getString("name"));
            rs.next();
            bobotKriteria.add(rs.getFloat("bobot"));
            titleThird.setText(rs.getString("name"));
            rs.next();
            bobotKriteria.add(rs.getFloat("bobot"));
            titleFourth.setText(rs.getString("name"));
            rs.next();
            bobotKriteria.add(rs.getFloat("bobot"));
            titleFifth.setText(rs.getString("name"));
//            }
//            System.out.println(objData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initializeChoiceBoxKriteria() {
        ResultSet kriteriaFirst;
        ResultSet kriteriaSecond;
        ResultSet kriteriaThird;
        ResultSet kriteriaFourth;
        ResultSet kriteriaFifth;
        try {
            repo = new RepositoryBase();
            conn = repo.setConnect();
            stmt = conn.createStatement();
            String sqlKriteria = "select * from kriteria where `group` = '%s'";
            sqlKriteria = String.format(sqlKriteria, this.group);
            rs = stmt.executeQuery(sqlKriteria);

            rs.next();
            System.out.println("rs pertama = " + rs.getInt("id"));
            kriteriaFirst = getKriteriaByKriteriaId(rs.getInt("id"));
            JSONArray cbFirst = new JSONArray();
            cbFirst.add(cbC1First);
            cbFirst.add(cbC1Second);
            cbFirst.add(cbC1Third);
            cbFirst.add(cbC1Fourth);
            cbFirst.add(cbC1Fifth);
            initializeChoiceBox(cbFirst, kriteriaFirst);

            System.out.println("rs Kedua = " + rs.getInt("id"));
            rs.next();
            kriteriaSecond = getKriteriaByKriteriaId(rs.getInt("id"));
            JSONArray cbSecond = new JSONArray();
            cbSecond.add(cbC2First);
            cbSecond.add(cbC2Second);
            cbSecond.add(cbC2Third);
            cbSecond.add(cbC2Fourth);
            cbSecond.add(cbC2Fifth);
            initializeChoiceBox(cbSecond, kriteriaSecond);

            rs.next();
            kriteriaThird = getKriteriaByKriteriaId(rs.getInt("id"));
            JSONArray cbThird = new JSONArray();
            cbThird.add(cbC3First);
            cbThird.add(cbC3Second);
            cbThird.add(cbC3Third);
            cbThird.add(cbC3Fourth);
            cbThird.add(cbC3Fifth);
            initializeChoiceBox(cbThird, kriteriaThird);

            rs.next();
            kriteriaFourth = getKriteriaByKriteriaId(rs.getInt("id"));
            JSONArray cbFourth = new JSONArray();
            cbFourth.add(cbC4First);
            cbFourth.add(cbC4Second);
            cbFourth.add(cbC4Third);
            cbFourth.add(cbC4Fourth);
            cbFourth.add(cbC4Fifth);
            initializeChoiceBox(cbFourth, kriteriaFourth);

            rs.next();
            kriteriaFifth = getKriteriaByKriteriaId(rs.getInt("id"));
            JSONArray cbFifth = new JSONArray();
            cbFifth.add(cbC5First);
            cbFifth.add(cbC5Second);
            cbFifth.add(cbC5Third);
            cbFifth.add(cbC5Fourth);
            cbFifth.add(cbC5Fifth);
            initializeChoiceBox(cbFifth, kriteriaFifth);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getKriteriaByKriteriaId(int kriteriaId) {
        ResultSet kriteriaRs = null;
        try {
            repo = new RepositoryBase();
            conn = repo.setConnect();
            stmt = conn.createStatement();
            String sqlBobotKriteria = "select * from bobot_kriteria where `kriteria_id` = %d";
            sqlBobotKriteria = String.format(sqlBobotKriteria, kriteriaId);
            kriteriaRs = stmt.executeQuery(sqlBobotKriteria);
            return kriteriaRs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kriteriaRs;
    }

    public void initializeChoiceBox(JSONArray choiceBox, ResultSet resultValue) throws SQLException {
        while (resultValue.next()) {
            for (int i = 0; i < choiceBox.size(); i++) {
//                System.out.println("choice box = "+choiceBox.get(i));
//                choiceBox.get(i).getItems().add(resultValue.getInt("nilai"));
                ChoiceBox<Integer> cb = (ChoiceBox<Integer>) choiceBox.get(i);
                cb.getItems().add(resultValue.getInt("nilai"));
            }
        }
    }

    public float calculateBobot(float dataProduct[]) {
        float totalProduct = 0;
        for (int i = 0; i < dataProduct.length; i++) {
            totalProduct += dataProduct[i] * ((Float) bobotKriteria.get(i));
        }
        return totalProduct;
    }

    public void saveDataPenelitian(int[] idBarangList, float[] dataResult) {
        DataPenelitianModel model = new DataPenelitianModel(idBarangList, dataResult);
        RepositoryDataPenelitian repo = new RepositoryDataPenelitian();
        repo.save(model);
    }
}
