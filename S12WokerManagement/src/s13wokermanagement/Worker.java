/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s13wokermanagement;

/**
 *
 * @author trong
 */
public class Worker {
    private String Id;
    private String name;
    private int age;
    private int salary;
    private String workLocation;

    /**
     * Constructor for other class using.
     * This constructor have parameter.
     * @param Id this parameter to set value for attribute.
     * @param name this parameter to set value for attribute.
     * @param age this parameter to set value for attribute.
     * @param salary this parameter to set value for attribute.
     * @param workLocation this parameter to set value for attribute.
     */
    public Worker(String Id, String name, int age, int salary, String workLocation) {
        this.Id = Id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    /**
     * Method getId().
     * This method will get value of attribute.
     * @return Id value in attribute.
     */
    public String getId() {
        return Id;
    }

    /**
     * Method setId().
     * This method will set value for attribute.
     * @param Id this parameter will set value for attribute.
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * Method getName().
     * This method will get value of attribute.
     * @return name value in attribute.
     */
    public String getName() {
        return name;
    }

    /**
     * Method setName().
     * This method will set value for attribute.
     * @param name this parameter will be set value for attribute.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method getAge().
     * This method will be get value from attribute.
     * @return age value in attribute.
     */
    public int getAge() {
        return age;
    }

    /**
     * Method setAge().
     * This method will be set value for attribute.
     * @param age this parameter will be set value for attribute.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Method getSalary().
     * This method will be get value from attribute.
     * @return salary value in attribute.
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Method setSalary().
     * This method will be set value for attribute.
     * @param salary this parameter will be set value for attribute.
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Method getWorkLocation().
     * This method will be get value from attribute.
     * @return workLocation value in attribute.
     */
    public String getWorkLocation() {
        return workLocation;
    }

    /**
     * Method setWorkLocation().
     * This method will be set value for attribute.
     * @param workLocation this parameter will be set value for attribute.
     */
    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }
    
    
}
