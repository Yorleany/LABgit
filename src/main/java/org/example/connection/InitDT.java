package org.example.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDT {
    private InitDT() {
    }

    public static void  init() throws SQLException, ClassNotFoundException {

        //Habilitamos y creamos una conexion hacia la base de datos
        Connection connection = DBConnector.getConnection();

        try (Statement statement = connection.createStatement()) {
            statement.execute(getClienteTruncate());
            statement.execute(getCuentaTruncate());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Statement statement = connection.createStatement()) {
            statement.execute(getClienteCreateQuery());
            statement.execute(getCuentaCreateQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getClienteTruncate() {
        return "DROP TABLE IF EXISTS cliente;";
    }
    private static String getCuentaTruncate() {
        return "DROP TABLE IF EXISTS cuenta;";
    }

    private static String getClienteCreateQuery() {
        return "CREATE TABLE IF NOT EXISTS cliente (\n" +
                "\tid_cliente int NOT NULL PRIMARY KEY,\n" +
                "\tnombre varchar(32) NOT NULL,\n" +
                "\tapellido varchar(32) NOT NULL,\n" +
                "\tcedula varchar(16) NOT NULL,\n" +
                "\tf_nacimiento Date NOT NULL,\n" +
                "\tstatus_laboral bool NOT NULL,\n" +
                "\tnivel_riesgo varchar(6) NOT NULL\n" + ");";
    }
    private static String getCuentaCreateQuery() {
        return "CREATE TABLE IF NOT EXISTS cuenta (\n" +
                "\tid_cliente int NOT NULL,\n" +
                "\tid_cuenta varchar(64) NOT NULL PRIMARY KEY,\n" +
                "\ttipo_cuenta varchar(32) NOT NULL,\n" +
                "\tbalance float(10,2) NOT NULL\n" +");";
    }
}
