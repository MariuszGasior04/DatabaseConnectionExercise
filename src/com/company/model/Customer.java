package com.company.model;

public class Customer {
    private int id;
    private String name;
    private String surname;
    private String region;
    private int age;
    private Sex sex;

    public Customer() {
    }

    public Customer(int id, String name, String surname, String region, int age, Sex sex) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.region = region;
        this.age = age;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", region='" + region + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
