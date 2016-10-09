package com.hcl.onlineexam.services;

public interface MySqlDB {

    final static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    final static String DATABASE = "onlineexamdb";
    final static String HOST = "localhost";
    final static String PORT = "3306";
    final static String URL="jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
    final static String USERNAME="root";
    final static String PASSWORD="vedisoft";

}
