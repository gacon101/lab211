/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s17personmanagiment;

/**
 *
 * @author trong
 */
public class Person {
    private String name;
    private String address;
    private double salary;

    /**
     * Constructor for class PersonManagement using.
     * In this constructor have parameter:
     * @param name This parameter to set input value to attribute. 
     * @param address This parameter to set input value to attribute. 
     * @param salary This parameter to set input value to attribute. 
     */
    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    /**
     * Method getName().
     * This method will get value from attribute.
     * @return name The value in the attribute.
     */
    public String getName() {
        return name;
    }

    /**
     * Method setName().
     * This method will set input value into attribute.
     * @param name This parameter will get input value and set into the attribute.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method getAddress().
     * This method will get value from attribute.
     * @return address The value in the attribute.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method setAddress().
     * This method will set input value into attribute.
     * @param address This parameter will get input value and set into the attribute.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Method getSalary().
     * This method will get value from attribute.
     * @return salary The value in the attribute.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Method setAddress().
     * This method will set input value into attribute.
     * @param salary This parameter will get input value and set into the attribute.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
}
