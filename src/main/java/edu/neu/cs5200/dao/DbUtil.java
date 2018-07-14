package edu.neu.cs5200.dao;

import java.sql.Date;

public class DbUtil {
    public static final String URL = "jdbc:mysql://localhost:3306/hw2_vora_harshit_summer_2018";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    public static Date getCurrentDate(){
        return new Date(new java.util.Date().getTime());
    }
}
