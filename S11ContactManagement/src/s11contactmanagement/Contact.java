/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s11contactmanagement;

/**
 *
 * @author trong
 */
public class Contact {

    private int id;
    private String fullName;
    private String group;
    private String address;
    private String phone;
    private String lastName;
    private String firtName;

    /**
     *  Constructor for main driver.
     *  Constructor with parameter for get enter the value to attribute.
     * @param id parameter to catch value and add to attribute.
     * @param fullName parameter to catch value and add to attribute.
     * @param group parameter to catch value and add to attribute.
     * @param address parameter to catch value and add to attribute.
     * @param phone parameter to catch value and add to attribute.
     * @param lastName parameter to catch value and add to attribute.
     * @param firtName parameter to catch value and add to attribute.
     */
    public Contact(int id, String fullName, String group, String address, String phone, String lastName, String firtName) {
        this.id = id;
        this.fullName = fullName;
        this.group = group;
        this.address = address;
        this.phone = phone;
        this.lastName = lastName;
        this.firtName = firtName;
    }

    /**
     * Method getId().
     * This method to get value of attribute.
     * @return id attribute.
     */
    public int getId() {
        return id;
    }

    /**
     *  Method setId().
     *  This method allow to set value for attribute.
     * @param id to set value for id attribute.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *  Method getFullName().
     *  This method to get value of attribute.
     * @return fullName attribute.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Method setFullName().
     * This method allow to set value for attribute.
     * @param fullName to set value for fullName attribute.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Method getGroup().
     * This method to get value of attribute.
     * @return group attribute.
     */
    public String getGroup() {
        return group;
    }

    /**
     *  Method setGroup().
     *  This method allow to set value for attribute.
     * @param group to set value for group attribute.
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Method getAddress().
     * This method to get value of attribute.
     * @return address attribute.
     */
    public String getAddress() {
        return address;
    }

    /**
     *  Method setAddress().
     *  This method allow to set value of attribute.
     * @param address to set value for address attribute.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *  Method getPhone().
     * This method to get value of attribute.
     * @return phone attribute.
     */
    public String getPhone() {
        return phone;
    }

    /**
     *  Method setPhone().
     * This method allow to set value of attribute.
     * @param phone to set value for address attribute.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Method getLastName().
     * This method to get value of attribute.
     * @return lastName attribute.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method setLastName().
     * This method allow to set value for attribute.
     * @param lastName to set value for lastName attribute.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *  Method getFirstName().
     * This method to get value of attribute.
     * @return firstName attribute.
     */
    public String getFirtName() {
        return firtName;
    }

    /**
     * Method setFirstName().
     * This method allow to set value for attribute.
     * @param firtName to set value for firstName attribute.
     */
    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

}
