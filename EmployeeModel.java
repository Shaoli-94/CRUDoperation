/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author XYZ
 */
public class EmployeeModel {

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }
    private String id;
    private String name;
    private int salary;

    public EmployeeModel(String id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
}
