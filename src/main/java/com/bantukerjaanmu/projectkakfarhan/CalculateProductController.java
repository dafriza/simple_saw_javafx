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
//        Arrays.sort(firstColumn);
//        Arrays.sort(secondColumn);
//        Arrays.sort(thirdColumn);
//        Arrays.sort(fourthColumn);
//        Arrays.sort(fifthColumn);
//        int dividerFirst = firstColumn[firstColumn.length - 1];
        int dividerFirst = maxValue(firstColumn);
//        int dividerSecond = secondColumn[0];
        int dividerSecond = minValue(secondColumn);
//        int dividerThird = thirdColumn[thirdColumn.length - 1];
        int dividerThird = maxValue(thirdColumn);
//        int dividerFourth = fourthColumn[fourthColumn.length - 1];
        int dividerFourth = maxValue(fourthColumn);
//        int dividerFifth = fifthColumn[0];
        int dividerFifth = minValue(fifthColumn);

        double firstCalculateC1 = (double) cbC1First.getValue() / (double) dividerFirst;
        double secondCalculateC1 = (double) cbC1Second.getValue() / (double) dividerFirst;
        double thirdCalculateC1 = (double) cbC1Third.getValue() / (double) dividerFirst;
        double fourthCalculateC1 = (double) cbC1Fourth.getValue() / (double) dividerFirst;
        double fifthCalculateC1 = (double) cbC1Fifth.getValue() / (double) dividerFirst;
//        double firstRow[] = {firstCalculateC1, firstCalculateC1, thirdCalculateC1, fourthCalculateC1, fifthCalculateC1};

        double firstCalculateC2 = (double) dividerSecond / (double) cbC2First.getValue();
        double secondCalculateC2 = (double) dividerSecond / (double) cbC2Second.getValue();
        double thirdCalculateC2 = (double) dividerSecond / (double) cbC2Third.getValue();
        double fourthCalculateC2 = (double) dividerSecond / (double) cbC2Fourth.getValue();
        double fifthCalculateC2 = (double) dividerSecond / (double) cbC2Fifth.getValue();
//        double secondRow[] = {firstCalculateC2, secondCalculateC2, thirdCalculateC2, fourthCalculateC2, fifthCalculateC2};

        double firstCalculateC3 = (double) cbC3First.getValue() / (double) dividerThird;
        double secondCalculateC3 = (double) cbC3Second.getValue() / (double) dividerThird;
        double thirdCalculateC3 = (double) cbC3Third.getValue() / (double) dividerThird;
        double fourthCalculateC3 = (double) cbC3Fourth.getValue() / (double) dividerThird;
        double fifthCalculateC3 = (double) cbC3Fifth.getValue() / (double) dividerThird;
//        double thirdRow[] = {firstCalculateC3, secondCalculateC3, thirdCalculateC3, fourthCalculateC3, fifthCalculateC3};

        double firstCalculateC4 = (double) cbC4First.getValue() / (double) dividerFourth;
        double secondCalculateC4 = (double) cbC4Second.getValue() / (double) dividerFourth;
        double thirdCalculateC4 = (double) cbC4Third.getValue() / (double) dividerFourth;
        double fourthCalculateC4 = (double) cbC4Fourth.getValue() / (double) dividerFourth;
        double fifthCalculateC4 = (double) cbC4Fifth.getValue() / (double) dividerFourth;
//        double fourthRow[] = {firstCalculateC4, secondCalculateC4, thirdCalculateC4, fourthCalculateC4, fifthCalculateC4};

        double firstCalculateC5 = (double) dividerFifth / (double) cbC5First.getValue();
        double secondCalculateC5 = (double) dividerFifth / (double) cbC5Second.getValue();
        double thirdCalculateC5 = (double) dividerFifth / (double) cbC5Third.getValue();
        double fourthCalculateC5 = (double) dividerFifth / (double) cbC5Fourth.getValue();
        double fifthCalculateC5 = (double) dividerFifth / (double) cbC5Fifth.getValue();
//        double fifthRow[] = {firstCalculateC5, secondCalculateC5, thirdCalculateC5, fourthCalculateC5, fifthCalculateC5};

        double firstRow[] = {firstCalculateC1, firstCalculateC2, firstCalculateC3, firstCalculateC4, firstCalculateC5};
        double secondRow[] = {secondCalculateC1, secondCalculateC2, secondCalculateC3, secondCalculateC4, secondCalculateC5};
        double thirdRow[] = {thirdCalculateC1, thirdCalculateC2, thirdCalculateC3, thirdCalculateC4, thirdCalculateC5};
        double fourthRow[] = {fourthCalculateC1, fourthCalculateC2, fourthCalculateC3, fourthCalculateC4, fourthCalculateC5};
        double fifthRow[] = {fifthCalculateC1, fifthCalculateC2, fifthCalculateC3, fifthCalculateC4, fifthCalculateC5};

//        for (double d : firstRow) {
//            System.out.println(d + " ");
//        }
//        for (Object object : bobotKriteria) {
//            System.out.println("bobot + " + object);
//        }
//        System.out.println("result first = "+ firstRow);
        double resultFirst = calculateBobot(firstRow);
//        System.out.println("result first = " + resultFirst);
        double resultSecond = calculateBobot(secondRow);
        double resultThird = calculateBobot(thirdRow);
        double resultFourth = calculateBobot(fourthRow);
        double resultFifth = calculateBobot(fifthRow);
        double resultArray[] = {resultFirst, resultSecond, resultThird, resultFourth, resultFifth};
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
            bobotKriteria.add(rs.getDouble("bobot"));
            titleFirst.setText(rs.getString("name"));
            rs.next();
            bobotKriteria.add(rs.getDouble("bobot"));
            titleSecond.setText(rs.getString("name"));
            rs.next();
            bobotKriteria.add(rs.getDouble("bobot"));
            titleThird.setText(rs.getString("name"));
            rs.next();
            bobotKriteria.add(rs.getDouble("bobot"));
            titleFourth.setText(rs.getString("name"));
            rs.next();
            bobotKriteria.add(rs.getDouble("bobot"));
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

    public double calculateBobot(double dataProduct[]) {
        double totalProduct = 0;
        for (int i = 0; i < dataProduct.length; i++) {
            totalProduct = ((double) dataProduct[i] * ((double) bobotKriteria.get(i))) + totalProduct;
//            System.out.println("data normalisasi = " + dataProduct[i]);
//            System.out.println("data kriteria bobot = " + bobotKriteria.get(i));
//            System.out.println("perkalian data = " + (double) dataProduct[i] * ((double) bobotKriteria.get(i)));
//            System.out.println("result " + i + ", hasil = " + totalProduct);
        }
        return totalProduct;
    }

    public void saveDataPenelitian(int[] idBarangList, double[] dataResult) {
        DataPenelitianModel model = new DataPenelitianModel(idBarangList, dataResult);
        RepositoryDataPenelitian repo = new RepositoryDataPenelitian();
        repo.save(model);
    }

    public int maxValue(int[] dataKriteria) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < dataKriteria.length; i++) {
            maxValue = Math.max(maxValue, dataKriteria[i]);
        }
        return maxValue;
    }

    public int minValue(int[] dataKriteria) {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < dataKriteria.length; i++) {
            minValue = Math.min(minValue, dataKriteria[i]);
        }
        return minValue;
    }
}
