/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bantukerjaanmu.projectkakfarhan.connection;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author mochammad.angkasa
 */
public interface queryExecuteUpdate {
    Statement executeStatement(Connection conn, Statement stmt, Integer id);
}
