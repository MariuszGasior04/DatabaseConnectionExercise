package com.company;

import com.company.model.Customer;
import com.company.model.Sex;

import java.util.List;

public class JdbcTest {
    public static void main(String[] args) {
        CustomerDAOImpl dao = new CustomerDAOImpl();
        Customer customer1 = new Customer( 1,"Adam","Nowak","podkarpackie",20, Sex.MALE);
        Customer customer2 = new Customer( 2,"Olga","Tokarczuk","małopolskie",25, Sex.FEMALE);
        Customer customer3 = new Customer( 3,"Agata","Kowalska","opolskie",30, Sex.FEMALE);
        Customer customer4 = new Customer( 4,"Jan","Bęc","mazowieckie",18, Sex.MALE);
        Customer customer5 = new Customer( 5,"Mariusz","Tuktuk","śląskie",27, Sex.MALE);

        dao.openConnection();
        dao.createTable();
        dao.insertCustomer(customer1);
        dao.insertCustomer(customer2);
        dao.insertCustomer(customer3);
        dao.insertCustomer(customer4);
        dao.insertCustomer(customer5);


    }
}
