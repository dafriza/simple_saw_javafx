/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bantukerjaanmu.projectkakfarhan.repository;

import com.bantukerjaanmu.projectkakfarhan.connection.MySQL;
import com.bantukerjaanmu.projectkakfarhan.connection.queryExecuteStatement;
import com.bantukerjaanmu.projectkakfarhan.models.BarangModel;
import com.bantukerjaanmu.projectkakfarhan.models.ProductTypeModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import org.json.simple.JSONArray;

/**
 *
 * @author mochammad.angkasa
 */
public class RepositoryProductType {

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

//    public void save(BarangModel barang) {
//        try {
//            connect.queryManualStatement(conn, stmt, new queryExecuteStatement() {
//                @Override
//                public Statement executeStatement(Connection conn, Statement stmt) {
//                    try {
//                        JSONArray dataBarang = barang.getDataBarang();
//                        ZoneId z = ZoneId.of("Asia/Jakarta");
//                        LocalDate created_at = LocalDate.now(z);
//                        LocalDate updated_at = LocalDate.now(z);
//                        for (int i = 0; i < dataBarang.size(); i++) {
//                            String sql = "INSERT INTO barang (name, `group`, created_at, updated_at) values ('%s', '%s', '%s', '%s')";
//                            sql = String.format(sql, (String) dataBarang.get(i), (String) barang.getGroup(), created_at, updated_at);
//                            System.out.println("sql command = " + sql);
//                            stmt.executeUpdate(sql);
//                        }
//                        return stmt;
//                    } catch (SQLException e) {
////                    } catch (Exception e) {
//                        e.printStackTrace();
////                        Logger.getLogger(RepositoryKriteria.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    return null;
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public void update(ProductTypeModel productType) {
        try {
            connect.queryManualStatement(conn, stmt, new queryExecuteStatement() {
                @Override
                public Statement executeStatement(Connection conn, Statement stmt) {
                    try {
                        ZoneId z = ZoneId.of("Asia/Jakarta");
                        LocalDate updatedAt = LocalDate.now(z);
                        String sql = "UPDATE bobot_kriteria SET `jenis_kriteria`='%s', `kategori`='%s', `nilai`='%d', `updated_at`='%s' WHERE `id`=%d";
                        sql = String.format(sql, (String) productType.getJenisKriteria(), (String) productType.getKategori(), productType.getNilai(), updatedAt, productType.getId());
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

    public void delete(ProductTypeModel productType) {
        try {
            connect.queryManualStatement(conn, stmt, new queryExecuteStatement() {
                @Override
                public Statement executeStatement(Connection conn, Statement stmt) {
                    try {
                        String sql = String.format("DELETE FROM bobot_kriteria WHERE id=%d", productType.getId());
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

    public void index() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "select * from kriteria";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idBuku = rs.getInt("id");
                System.out.println(idBuku);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
