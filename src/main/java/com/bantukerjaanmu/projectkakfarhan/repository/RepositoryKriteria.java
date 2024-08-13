package com.bantukerjaanmu.projectkakfarhan.repository;

import com.bantukerjaanmu.projectkakfarhan.connection.MySQL;
import com.bantukerjaanmu.projectkakfarhan.models.KriteriaModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.bantukerjaanmu.projectkakfarhan.connection.queryExecuteStatement;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.ZoneId;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RepositoryKriteria {

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

    public void save(KriteriaModel kriteria) {
        try {
            connect.queryManualStatement(conn, stmt, new queryExecuteStatement() {
                @Override
                public Statement executeStatement(Connection conn, Statement stmt) {
                    try {
                        Object kriteriaRaw = kriteria.getData_kriteria();
                        JSONObject kriteriaObject = (JSONObject) kriteriaRaw;
//                        System.out.println("JSONObject = " + kriteriaObject.get("data"));
                        ZoneId z = ZoneId.of("Asia/Jakarta");
                        LocalDate created_at = LocalDate.now(z);
                        LocalDate updated_at = LocalDate.now(z);
                        JSONArray kriteriaData = (JSONArray) kriteriaObject.get("data");
                        for (Object kriteriaRawObject : kriteriaData) {
                            JSONObject kriteria = (JSONObject) kriteriaRawObject;
                            String sql = "insert into kriteria(`name`,`keterangan`,`type`,`bobot`,`group`,`created_at`,`updated_at`)values('%s','%s','%s',%f,'%s','%s','%s')";
                            sql = String.format(sql, kriteria.get("kriteria"), kriteria.get("keterangan"), kriteria.get("type"), Float.valueOf((String) kriteria.get("bobot")), (String) kriteriaObject.get("group"), created_at, updated_at);
                            System.out.println("SQL = " + sql);
                            stmt = conn.createStatement();
                            stmt.execute(sql);
                        }
                        return stmt;
//                        return null;
//                    } catch (SQLException e) {
                    } catch (Exception e) {
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

    public void update(KriteriaModel kriteria) {
        try {
            connect.queryManualStatement(conn, stmt, new queryExecuteStatement() {
                @Override
                public Statement executeStatement(Connection conn, Statement stmt) {
                    try {
                        ZoneId z = ZoneId.of("Asia/Jakarta");
                        LocalDate updated_at = LocalDate.now(z);
                        String sql = "UPDATE kriteria SET `name`='%s',`keterangan`='%s', `type`='%s', `bobot`='%f', `group`='%s', `updated_at`='%s' WHERE `id`=%d";
                        sql = String.format(sql, (String) kriteria.getKriteria(), (String) kriteria.getKeterangan(), kriteria.getType(), kriteria.getBobot(), kriteria.getGroup(), updated_at, kriteria.getId());
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
        //    }
    }

    public void delete(KriteriaModel kriteria) {
        try {
            connect.queryManualStatement(conn, stmt, new queryExecuteStatement() {
                @Override
                public Statement executeStatement(Connection conn, Statement stmt) {
                    try {
                        ZoneId z = ZoneId.of("Asia/Jakarta");
                        LocalDate updated_at = LocalDate.now(z);
                        String sql = String.format("DELETE FROM kriteria WHERE id=%d", kriteria.getId());
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
}
