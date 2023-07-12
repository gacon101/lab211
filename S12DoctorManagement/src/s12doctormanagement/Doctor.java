/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s12doctormanagement;

/**
 *
 * @author trong
 */
public class Doctor {

    private String code;
    private String name;
    private String specialization;
    private int availability;

    /**
     * Constructor for class management using.
     * This constructor have parameter to get value for attribute.
     * @param code this parameter to get value.
     * @param name this parameter to get value.
     * @param specialization this parameter to get value.
     * @param availability this parameter to get value.
     */
    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    /**
     * Method getCode().
     * This method to get value in attribute.
     * @return code value in this attribute will be get.
     */
    public String getCode() {
        return code;
    }

    /**
     * Method setCode().
     * This method to set value for attribute.
     * In this method have parameter.
     * @param code this parameter to get value and set value for attribute.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Method getName().
     * This method to get value in attribute.
     * @return name value in this attribute will be get.
     */
    public String getName() {
        return name;
    }

    /**
     * Method setName().
     * This method to set value for attribute.
     * In this method have parameter.
     * @param name this parameter to get value and set value for attribute.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method getSpecialization().
     * This method to get value in attribute.
     * @return specialization value in this attribute will be get.
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Method setSpecializtion().
     * This method to set value for attribute.
     * In this method have parameter.
     * @param specialization this parameter to get value and set value for attribute.
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Method getAvailability().
     * This method to get value of attribute.
     * @return availability value in this attribute will be get.
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * Method setAvailability().
     * This method to set value for attribute.
     * In this method have parameter.
     * @param availability this parameter to get value and set value for attribute.
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }

}
