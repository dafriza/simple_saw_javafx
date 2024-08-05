package com.bantukerjaanmu.projectkakfarhan.connection;
import java.sql.*;

public class MySQL {

    // Menyiapkan parameter JDBC untuk koneksi ke database
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db_product";
    static final String USER = "root";
    static final String PASS = "";

    // Menyiapkan objek yang diperlukan untuk mengelola database
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public void mySQLConnect() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM kriteria";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID Buku: " + rs.getInt("id"));
                System.out.println("Judul: " + rs.getObject("data_kriteria"));
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
