package com.bantukerjaanmu.projectkakfarhan;
import java.io.IOException;
import javafx.fxml.FXML;

public class DashboardController{
    @FXML
    private void switchToListKritetia() throws IOException {
        App.setRoot("ListKriteria");
    }
}
