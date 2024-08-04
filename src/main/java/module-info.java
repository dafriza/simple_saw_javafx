module com.bantukerjaanmu.projectkakfarhan {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.bantukerjaanmu.projectkakfarhan to javafx.fxml;
    exports com.bantukerjaanmu.projectkakfarhan;
}
