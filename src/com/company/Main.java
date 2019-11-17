package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        try {
            //połączenie z baza danych                               jdbc:nazwaserwera:adres do bazy danych
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/home/student/database.sqlite");
            Statement statement = connection.createStatement();
            //Instrukcje do manipulacji baza danych
            statement.executeUpdate("CREATE TABLE Customer ("+
                    "id INTEGER PRIMARY KEY ,"+
                    "name TEXT)");
            statement.executeUpdate("INSERT INTO Customer VALUES (1, 'Paweł')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
