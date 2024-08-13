/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bantukerjaanmu.projectkakfarhan.repository;

import com.bantukerjaanmu.projectkakfarhan.connection.MySQL;
import com.bantukerjaanmu.projectkakfarhan.connection.queryExecuteStatement;
import com.bantukerjaanmu.projectkakfarhan.models.BarangModel;
import com.bantukerjaanmu.projectkakfarhan.models.SawBobotKriteriaModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author mochammad.angkasa
 */
public class RepositorySawBobot {

    // Menyiapkan parameter JDBC untuk koneksi ke database
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db_product";
    static final String USER = "root";
    static final String PASS = "";

    // Menyiapkan objek yang diperlukan untuk mengelola database
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    static ResultSet rsSecond;
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

    public void save(SawBobotKriteriaModel sawBobot) {
        try {
            connect.queryManualStatement(conn, stmt, new queryExecuteStatement() {
                @Override
                public Statement executeStatement(Connection conn, Statement stmt) {
                    try {
                        JSONArray rawData = sawBobot.getRawData();
                        ZoneId z = ZoneId.of("Asia/Jakarta");
                        LocalDate created_at = LocalDate.now(z);
                        LocalDate updated_at = LocalDate.now(z);
                        for (int i = 0; i < rawData.size(); i++) {
                            JSONObject bobotKriteriaRaw = (JSONObject) rawData.get(i);
                            String findKriteriaId = "Select * from kriteria where `name` = '%s'";
                            findKriteriaId = String.format(findKriteriaId, (String) bobotKriteriaRaw.get("kriteria"));
                            System.out.println("sql command = " + findKriteriaId);
                            rs = stmt.executeQuery(findKriteriaId);
                            rs.next();
                            Integer idKriteria = rs.getInt("id");

                            String findBobotKriteriaId = "Select * from bobot_kriteria where `kategori` = '%s' and nilai = %d and kriteria_id = %d";
                            findBobotKriteriaId = String.format(findBobotKriteriaId, (String) bobotKriteriaRaw.get("keterangan"), bobotKriteriaRaw.get("bobot"), idKriteria);
                            rsSecond = stmt.executeQuery(findBobotKriteriaId);
                            rsSecond.next();
                            Integer idBobotKriteria = rs.getInt("id");

                            String insertToTable = "insert into saw_bobot_kriteria(`kriteria_id`,`bobot_kriteria_id`,`created_at`,`updated_at`) values (%d, %d, '%s', '%s')";
                            insertToTable = String.format(insertToTable, idKriteria, idBobotKriteria, created_at, updated_at);
                            stmt.execute(insertToTable);
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

    public void update(BarangModel barang) {
        try {
            connect.queryManualStatement(conn, stmt, new queryExecuteStatement() {
                @Override
                public Statement executeStatement(Connection conn, Statement stmt) {
                    try {
                        ZoneId z = ZoneId.of("Asia/Jakarta");
                        LocalDate updated_at = LocalDate.now(z);
                        String sql = "UPDATE barang SET `name`='%s', `group`='%s', `updated_at`='%s' WHERE `id`=%d";
                        sql = String.format(sql, (String) barang.getName(), (String) barang.getGroup(), updated_at, barang.getId());
                        System.out.println("sql command = " + sql);
                        stmt.execute(sql);
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

    public void delete(BarangModel barang) {
        try {
            connect.queryManualStatement(conn, stmt, new queryExecuteStatement() {
                @Override
                public Statement executeStatement(Connection conn, Statement stmt) {
                    try {
                        ZoneId z = ZoneId.of("Asia/Jakarta");
                        LocalDate updated_at = LocalDate.now(z);
                        String sql = String.format("DELETE FROM barang WHERE id=%d", barang.getId());
                        System.out.println("sql command = " + sql);
                        stmt.execute(sql);
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

//    public void index() {
//        try {
//            Class.forName(JDBC_DRIVER);
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            stmt = conn.createStatement();
//            String sql = "select * from kriteria";
//            rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                int idBuku = rs.getInt("id");
//                System.out.println(idBuku);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
