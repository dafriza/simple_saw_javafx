package com.bantukerjaanmu.projectkakfarhan;

import java.io.IOException;
import javafx.fxml.FXML;

public class KriteriaDetailController {
    @FXML
    private void switchToListKriteria() throws IOException {
        App.setRoot("ListKriteria");
    }
}
