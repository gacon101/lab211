/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l03productandshopping;

/**
 *
 * @author trong
 */
public class Fruit {
    
    private int fruitID;
    private String fruitName;
    private double price;
    private int quantity;
    private String origin;

    /**
     * Constructor for class ShopManagement() using.
     * In this constructor have parameter:
     * @param fruitID This parameter will get value from user input.
     * @param fruitName This parameter will get value from user input.
     * @param price This parameter will get value from user input.
     * @param quantity This parameter will get value from user input.
     * @param origin This parameter will get value from user input.
     */
    public Fruit(int fruitID, String fruitName, double price, int quantity, String origin) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    /**
     * Method getFruitID().
     * This method will get value of attribute.
     * @return fruidID The value in the attribute.
     */
    public int getFruitID() {
        return fruitID;
    }

    /**
     * Method setFruiID().
     * This method will set value for attribute.
     * @param fruitID This parameter will set value for attribute.
     */
    public void setFruitID(int fruitID) {
        this.fruitID = fruitID;
    }

    /**
     * Method getFruitName().
     * This method will get value of attribute.
     * @return fruitName The value in the attribute.
     */
    public String getFruitName() {
        return fruitName;
    }

    /**
     * Method setFruitName().
     * This method will set value for attribute.
     * @param fruitName This parameter will set value for attribute.
     */
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    /**
     * Method getPrice().
     * This method will get value of attribute.
     * @return price The value in the attribute.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Method setPrice().
     * This method will set value for attribute.
     * @param price This parameter will set value for attribute.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Method getQuantilty().
     * This method will get value of attribute.
     * @return quantity The value of attribute.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Method setQuantity().
     * This method will set value for attribute.
     * @param quantity This parameter will set value for attribute.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Method getOrigin().
     * This method will get value of attribute.
     * @return origin The value of attribute.
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Method setOrigin().
     * This method will set value for attribute.
     * @param origin This parameter will set value for attribute.
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    
}
