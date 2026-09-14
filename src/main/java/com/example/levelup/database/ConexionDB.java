package com.example.levelup.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/levelup";
    private static final String USER = "root";

    public static Connection getConnection() throws SQLException {

        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream("config.properties")) {

            properties.load(input);
            String password = properties.getProperty("db.password");

            return DriverManager.getConnection(URL, USER, password);

        } catch (IOException e) {
            throw new SQLException("No se pudo cargar config.properties", e);
        }
    }
}