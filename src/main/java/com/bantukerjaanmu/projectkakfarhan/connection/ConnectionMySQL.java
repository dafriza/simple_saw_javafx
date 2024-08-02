package com.bantukerjaanmu.projectkakfarhan.connection;
import java.sql.*;

public class ConnectionMySQL {
     // Menyiapkan parameter JDBC untuk koneksi ke database
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/db_product";
    static final String USER = "root";
    static final String PASS = "";

    // Menyiapkan objek yang diperlukan untuk mengelola database
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    public void     connectDb() {
        // Melakukan koneksi ke database
        // harus dibungkus dalam blok try/catch
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);
            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS); 
            System.out.println("Connection success");
            // buat objek statement
//            stmt = conn.createStatement();
//            // buat query ke database
//            String sql = "SELECT * FROM buku";
//            // eksekusi query dan simpan hasilnya di obj ResultSet
//            rs = stmt.executeQuery(sql);
//            // tampilkan hasil query
//            while(rs.next()){
//                System.out.println("ID Product: " + rs.getInt("id_buku"));
//                System.out.println("Judul: " + rs.getString("judul"));
//                System.out.println("Pengarang: " + rs.getString("pengarang"));
//            }
            
//            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}