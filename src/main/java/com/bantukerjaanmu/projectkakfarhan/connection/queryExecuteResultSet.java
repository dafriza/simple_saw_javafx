package com.bantukerjaanmu.projectkakfarhan.connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface queryExecuteResultSet {
    ResultSet executeResultSet(Connection conn, Statement stmt);
}
