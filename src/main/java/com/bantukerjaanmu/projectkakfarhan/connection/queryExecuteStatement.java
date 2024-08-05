package com.bantukerjaanmu.projectkakfarhan.connection;

import java.sql.Connection;
import java.sql.Statement;

@FunctionalInterface
public interface queryExecuteStatement {
    Statement executeStatement(Connection conn, Statement stmt);
}
