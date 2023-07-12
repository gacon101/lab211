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
public class CustomerOrder extends Fruit{
    
    private double amount;

    /**
     * Super constructor for class ShopManagement() using.
     * In this constructor have parameter.
     * @param fruitID This parameter will get value from input and add to attribute.
     * @param fruitName This parameter will get value form input and add to attribute.
     * @param price This parameter will get value from input and add to attribute.
     * @param quantity  This parameter will get value from input and add to attribute.
     * @param origin This parameter will get value from input and add to attribute.
     * @param amount This parameter will get value from input and add to attribute.
     */
    public CustomerOrder(int fruitID, String fruitName, double price, int quantity, String origin, double  amount) {
        super(fruitID, fruitName, price, quantity, origin);
        this.amount = amount;
    }

    /**
     * Method getAmount().
     * This parameter will get value from attribute.
     * @return amount The value in attribute.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Method setAmount().
     * This method will set value from input into attribute.
     * @param amount This parameter will set value for attribute.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
}
