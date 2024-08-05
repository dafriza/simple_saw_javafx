package com.bantukerjaanmu.projectkakfarhan;

import java.io.IOException;
import javafx.fxml.FXML;
public class ListKriteriaController {

    @FXML
    private void switchToDashboard() throws IOException {
        App.setRoot("Dashboard");
    }
    
    @FXML
    private void switchToKriteriaDetail() throws IOException {
        App.setRoot("KriteriaDetail");
    }
}
