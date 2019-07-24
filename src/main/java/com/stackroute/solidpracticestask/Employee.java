package com.stackroute.solidpracticestask;

/**
 * Base for all employees in the company. Consists of all the basic functions required
 * by all employees of the company.
 */
public class Employee {
    private int id;
    private String name;

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
}
