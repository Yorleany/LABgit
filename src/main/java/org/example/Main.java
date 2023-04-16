package org.example;

import org.example.connection.DBConnector;
import org.example.connection.InitDT;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("Hello world!");


        var db = DBConnector.getConnection();

        var stm = db.createStatement();

        var result = stm.executeQuery("SELECT * FROM practicabg.cliente");

        InitDT.init();

    }
}