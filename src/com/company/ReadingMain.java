package com.company;

import java.sql.*;

public class ReadingMain {

    public static void main(String[] args) {

        try {
            //połączenie z baza danych                               jdbc:nazwaserwera:adres do bazy danych
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/home/student/database.sqlite");
            Statement statement = connection.createStatement();
            //Instrukcje do manipulacji baza danych
            ResultSet resultset = statement.executeQuery("SELECT * FROM Customer");

            while (resultset.next()){
                //odwołanie do kolumny przez numer
                System.out.println(resultset.getInt(1));
                //odwołanie do kolumny przez jej nazwe
                System.out.println(resultset.getInt("id"));

                //to samo tylko zwracamy wartosci String zamiast Int
                System.out.println(resultset.getString(2));
                System.out.println(resultset.getString("name"));
            }
            resultset.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
