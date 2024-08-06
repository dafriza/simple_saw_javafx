package com.bantukerjaanmu.projectkakfarhan.repository;

import com.bantukerjaanmu.projectkakfarhan.AddKriteriaController;
import com.bantukerjaanmu.projectkakfarhan.connection.MySQL;
import com.bantukerjaanmu.projectkakfarhan.connection.queryExecuteResultSet;
import com.bantukerjaanmu.projectkakfarhan.models.KriteriaModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.bantukerjaanmu.projectkakfarhan.connection.queryExecuteStatement;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.ZoneId;

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
                        Object dataKriteria = kriteria.getData_kriteria();
                        ZoneId z = ZoneId.of("Asia/Jakarta");
                        LocalDate created_at = LocalDate.now(z);
                        LocalDate updated_at = LocalDate.now(z);
                        String sql = "insert into kriteria(data_kriteria,created_at,updated_at)values('%s','%s','%s')";
                        sql = String.format(sql, dataKriteria, created_at, updated_at);
//                        stmt = conn.createStatement();
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
