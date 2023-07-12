/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s14usermanagement;

/**
 *
 * @author trong
 */
public class User {
    private int ID;
    private String userName;
    private String password;

    /**
     * Constructor for management class using.
     * @param ID
     * @param userName This parameter will get value and set for attribute.
     * @param password This parameter will get value and set for attribute.
     */
    public User(int ID, String userName, String password) {
        this.ID = ID;
        this.userName = userName;
        this.password = password;
    }
    
    /**
     * Method getID().
     * This method will get value of attribute.
     * @return ID value in attribute.
     */
    public int getID() {
        return ID;
    }

    /**
     * Method setID().
     * This method will set value for attribute.
     * In this method have parameter.
     * @param ID This parameter will set value for attribute.
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Method getUserName().
     * This method will get value of attribute.
     * @return userName value in attribute.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Method setUserName().
     * This method will set value for attribute.
     * In this method have parameter.
     * @param userName This parameter will set value for attribute.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Method getPassword().
     * This method will get value of attribute.
     * @return password value in attribute.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method setPassword().
     * This method will set value for attribute.
     * In this method have parameter.
     * @param password This parameter will set value for attribute.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
