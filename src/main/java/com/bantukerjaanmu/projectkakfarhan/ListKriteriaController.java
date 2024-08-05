package com.bantukerjaanmu.projectkakfarhan;

import com.bantukerjaanmu.projectkakfarhan.models.KriteriaModel;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositoryKriteria;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class ListKriteriaController implements Initializable {

    ResultSet rs;
    Connection conn;
    Statement stmt;
    
    @FXML
    TableView kriteriaTable;

    @FXML
    TableColumn<KriteriaModel, Integer> colId;

    @FXML
    TableColumn<KriteriaModel, String> colKriteria;

    @FXML
    TableColumn<KriteriaModel, String> colKeterangan;

    @FXML
    TableColumn<KriteriaModel, String> colGrup;

    @FXML
    TableColumn<KriteriaModel, String> colTanggal;

    @FXML
    TableColumn colAction;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getAllKriteria();
    }

    @FXML
    private void switchToDashboard() throws IOException {
        App.setRoot("Dashboard");
    }

    @FXML
    private void switchToKriteriaDetail() throws IOException {
        App.setRoot("AddKriteria");
    }

    @FXML
    public void getAllKriteria() {
        ObservableList<KriteriaModel> listKriteria = dataKriteria();
        colId.setCellValueFactory(new PropertyValueFactory<KriteriaModel, Integer>("id"));
        colKriteria.setCellValueFactory(new PropertyValueFactory<KriteriaModel, String>("kriteria"));
        colKeterangan.setCellValueFactory(new PropertyValueFactory<KriteriaModel, String>("keterangan"));
        colGrup.setCellValueFactory(new PropertyValueFactory<KriteriaModel, String>("group"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<KriteriaModel, String>("created_at"));
        kriteriaTable.setItems(listKriteria);
    }

    public ObservableList<KriteriaModel> dataKriteria() {
        ObservableList<KriteriaModel> kriteriaData = FXCollections.observableArrayList();
        try {
            RepositoryKriteria repo = new RepositoryKriteria();
            KriteriaModel kriteria;
            conn = repo.setConnect();
            stmt = conn.createStatement();
            String sql = "select * from kriteria";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Object kriteriaParse = JSONValue.parse(rs.getString("data_kriteria"));
                JSONObject kriteriaMain = (JSONObject) kriteriaParse;
                JSONArray kriteriaList = (JSONArray) kriteriaMain.get("data");
                int increment = rs.getInt("id");
                for (Object kriteriaItems : kriteriaList) {
                    JSONObject item = (JSONObject) kriteriaItems;
//                    System.out.println((String)item.get("keterangan"));
                    kriteria = new KriteriaModel(increment, (String) item.get("kriteria"), (String) item.get("keterangan"), (String) kriteriaMain.get("group"), rs.getString("created_at")
                    );
                    kriteriaData.add(kriteria);
                    increment++;
                }
            }
//            System.out.println(kriteriaData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kriteriaData;
    }
}
