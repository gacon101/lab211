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
public class StatusSalary extends Worker{
    
    private String status;
    private String date;

    /**
     * Constructor for class management using.
     * In this constructor have parameter.
     * Constructor have super constructor, because this class extends from class Worker(). 
     * @param Id This parameter using for super constructor.
     * @param name This parameter using for super constructor.
     * @param age This parameter using for super constructor.
     * @param salary This parameter using for super constructor.
     * @param status This parameter using for constructor.
     * @param date This parameter using for constructor.
     * @param workLocation  This parameter using for super constructor.
     */
    public StatusSalary(String Id, String name, int age, int salary, String status, String date, String workLocation) {
        super(Id, name, age, salary, workLocation);
        this.status = status;
        this.date = date;
    }

    /**
     * Method getStatus().
     * This method will be get value for attribute.
     * @return status value in attribute.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Method setStatus().
     * This method will be set value for attribute.
     * @param status this parameter will be set value for attribute.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Method getDate().
     * This method will be get value from attribute.
     * @return date value in attribute.
     */
    public String getDate() {
        return date;
    }

    /**
     * Method setDate().
     * This method will be set value for attribute.
     * @param date this parameter will be set value for attribute.
     */
    public void setDate(String date) {
        this.date = date;
    }
    
}
