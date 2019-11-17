package com.company;

import com.company.model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> readAllCustomers();

    void addCustomer(Customer customer);
}
