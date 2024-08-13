/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bantukerjaanmu.projectkakfarhan.repository;

import com.bantukerjaanmu.projectkakfarhan.connection.MySQL;
import com.bantukerjaanmu.projectkakfarhan.connection.queryExecuteUpdate;
import com.bantukerjaanmu.projectkakfarhan.models.KriteriaDetailModel;
import java.sql.Connection;
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
public class RepositoryKriteriaDetail {

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

    public void save(KriteriaDetailModel kriteria, Integer id) {
        try {
            connect.queryManualStatementEdit(conn, stmt, id, new queryExecuteUpdate() {
                @Override
                public Statement executeStatement(Connection conn, Statement stmt, Integer id) {
                    try {
//                        System.out.println("Id masuk = "+id);
                        JSONObject rawKriteria = kriteria.getRawKriteria();
                        ZoneId z = ZoneId.of("Asia/Jakarta");
                        LocalDate created_at = LocalDate.now(z);
                        LocalDate updated_at = LocalDate.now(z);
//                        Integer idTable = id;
                        Integer idTable = kriteria.getId();
//                        String sql = "insert into bobot_kriteria(data_bobot, kriteria_id, created_at, updated_at)values('%s','%s','%s','%s')";
                        for (Object objectKriteria : (JSONArray) rawKriteria.get("data")) {
                            JSONObject kriteria = (JSONObject) objectKriteria;
                            String sql = "insert into bobot_kriteria(`jenis_kriteria`, `kategori`, `nilai`, `kriteria_id`, `created_at`, `updated_at`)values('%s','%s','%s','%s','%s','%s')";
                            sql = String.format(sql, kriteria.get("jenis_kriteria"), kriteria.get("kategori"), kriteria.get("nilai"), idTable, created_at, updated_at);
                            stmt = conn.createStatement();
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
