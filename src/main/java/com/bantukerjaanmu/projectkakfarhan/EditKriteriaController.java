package com.bantukerjaanmu.projectkakfarhan;

import com.bantukerjaanmu.projectkakfarhan.models.BarangModel;
import com.bantukerjaanmu.projectkakfarhan.models.KriteriaModel;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositoryBarang;
import com.bantukerjaanmu.projectkakfarhan.repository.RepositoryKriteria;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditKriteriaController implements Initializable {

    public KriteriaModel kriteria;
    public ListKriteriaController controller;
    public Stage stage;

    @FXML
    TextField kriteriaField;

    @FXML
    TextField keteranganField;

    @FXML
    TextField groupField;

    @FXML
    Button updateButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Platform.runLater(() -> {
            System.out.println("Works!");
//            System.out.println(this.kriteria);
            this.kriteriaField.setText(this.kriteria.getKriteria());
            this.keteranganField.setText(this.kriteria.getKeterangan());
            this.groupField.setText(this.kriteria.getGroup());
        });
    }

    public void initData(KriteriaModel kriteria, Stage stage, ListKriteriaController controller) {
        this.kriteria = kriteria;
        this.stage = stage;
        this.controller = controller;
    }

    public void update(ActionEvent event) {
        try {
            ZoneId z = ZoneId.of("Asia/Jakarta");
            LocalDate updated_at = LocalDate.now(z);
            KriteriaModel model = new KriteriaModel(this.kriteria.getId(), this.kriteriaField.getText(), this.keteranganField.getText(), this.groupField.getText(), String.valueOf(updated_at));
            RepositoryKriteria repo = new RepositoryKriteria();
            repo.update(model);
            controller.getAllKriteria();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
