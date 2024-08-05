module com.bantukerjaanmu.projectkakfarhan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    opens com.bantukerjaanmu.projectkakfarhan to javafx.fxml;
    exports com.bantukerjaanmu.projectkakfarhan;
}
