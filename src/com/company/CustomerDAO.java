package com.company;

import com.company.model.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public interface CustomerDAO {
    void openConnection();
    public void createTable();
    public void insertCustomer(Customer customer);
    public void deleteData(Customer customer);
    public List<Customer> readAllCustomers();
    void closeConnection(Connection connection);

}
