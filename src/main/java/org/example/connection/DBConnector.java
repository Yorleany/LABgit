package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    static final String url = "jdbc:mysql://localhost:3306/practicabg?serverTimezone=UTC";
    static String usuario = "root";
    static String clave = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection(
                url, usuario, clave);
    }
}



