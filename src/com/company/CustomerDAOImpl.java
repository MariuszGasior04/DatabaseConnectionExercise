package com.company;

import com.company.model.Customer;
import com.company.model.Sex;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    private Connection connection = null;

    @Override
    public void openConnection() {
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:/home/student/database.sqlite");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void createTable() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE customers (" +
                    "id INTEGER PRIMARY KEY ," +
                    "name TEXT," +
                    "surname TEXT," +
                    "region TEXT," +
                    "age INTEGER," +
                    "sex TEXT," +
                    ")");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void insertCustomer(Customer customer) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(
                    String.format("INSERT INTO customers VALUES (%d,'%s','%s','%s',%d,'%s')",
                    customer.getId(),
                    customer.getName(),
                    customer.getSurname(),
                    customer.getRegion(),
                    customer.getAge(),
                    customer.getSex().toString()));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(statement!=null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Customer> readAllCustomers() {
        List<Customer> customersList = new ArrayList<>();
        Statement statement = null;
        ResultSet resultset = null;
        try {
             statement = connection.createStatement();
             resultset = statement.executeQuery("SELECT * FROM customers");
            while (resultset.next()){
                Customer customer = new Customer(
                        resultset.getInt("id"),
                        resultset.getString("name"),
                        resultset.getString("surname"),
                        resultset.getString("region"),
                        resultset.getInt("age"),
                        Sex.valueOf(resultset.getString("sex"))
                );
                customersList.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(resultset!=null) resultset.close();
                if(statement!=null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customersList;
    }
    @Override
    public void deleteData(Customer customer) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM customers");
            statement.executeUpdate("DROP TABLE customers");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(statement!=null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
