/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bantukerjaanmu.projectkakfarhan.repository;

import com.bantukerjaanmu.projectkakfarhan.connection.MySQL;
import com.bantukerjaanmu.projectkakfarhan.connection.queryExecuteStatement;
import com.bantukerjaanmu.projectkakfarhan.models.DataPenelitianModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 * @author mochammad.angkasa
 */
public class RepositoryDataPenelitian {

    // Menyiapkan parameter JDBC untuk koneksi ke database
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db_product";
    static final String USER = "root";
    static final String PASS = "";

    // Menyiapkan objek yang diperlukan untuk mengelola database
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    private MySQL connect = new MySQL();

    public Connection setConnect() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void save(DataPenelitianModel dataPenelitian) {
        try {
            connect.queryManualStatement(conn, stmt, new queryExecuteStatement() {
                @Override
                public Statement executeStatement(Connection conn, Statement stmt) {
                    try {
//                        JSONArray dataBarang = dataPenelitian.getDataBarang();
                        ZoneId z = ZoneId.of("Asia/Jakarta");
                        LocalDate created_at = LocalDate.now(z);
                        LocalDate updated_at = LocalDate.now(z);
                        for (int i = 0; i < dataPenelitian.getDataResultPenelitian().length; i++) {
                            String sql = "INSERT INTO data_penelitian (`barang_id`,`nilai`, `created_at`, `updated_at`) values (%d, %f, '%s', '%s')";
                            sql = String.format(sql, dataPenelitian.getIdDataBarang()[i], dataPenelitian.getDataResultPenelitian()[i], created_at, updated_at);
                            System.out.println("sql command = " + sql);
                            stmt.execute(sql);
                        }
                        return stmt;
                    } catch (SQLException e) {
//                    } catch (Exception e) {
                        e.printStackTrace();
//                        Logger.getLogger(RepositoryKriteria.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
