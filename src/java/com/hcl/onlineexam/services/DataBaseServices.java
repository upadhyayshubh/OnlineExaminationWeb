package com.hcl.onlineexam.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseServices implements MySqlDB {

    public static Connection getConnection() throws Exception {
        Class.forName(DRIVER_CLASS);

        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        return con;
    }

}
