package com.stackroute.solidpracticestask;

/**
 * Data entity class to store the details of customers.
 */
public class Customer {
    private int id;
    private String name;
    private Insurance insurance;

    Customer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

}
