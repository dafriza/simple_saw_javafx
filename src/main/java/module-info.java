module com.bantukerjaanmu.projectkakfarhan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires json.simple;
    opens com.bantukerjaanmu.projectkakfarhan to javafx.fxml;
    exports com.bantukerjaanmu.projectkakfarhan;
    exports com.bantukerjaanmu.projectkakfarhan.models;
    exports com.bantukerjaanmu.projectkakfarhan.connection;
}
