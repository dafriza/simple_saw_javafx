package com.bantukerjaanmu.projectkakfarhan;

import java.io.IOException;
import javafx.fxml.FXML;

public class DashboardController {

    @FXML
    private void switchToListKritetia() throws IOException {
//        App.mainStage.setTitle("List Kriteria");
        App.setRoot("ListKriteria");
    }

    @FXML
    private void switchToDashboardBarang() throws IOException {
//        App.mainStage.setTitle("Dashboard Barang");
        App.setRoot("DashboardBarang");
    }
}
