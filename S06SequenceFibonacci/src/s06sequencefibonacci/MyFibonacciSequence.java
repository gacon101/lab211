package s06sequencefibonacci;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author trong
 */
public class MyFibonacciSequence {

    private long n;

    /**
     * Constructor using in class Main.
     * Constructor with parameter long n
     *  this.n = n;
     * To set default before modify attribute.
     * @param n number of Fibonacci series.
     */
    public MyFibonacciSequence(long n) {
        this.n = n;
    }

    /**
     * Method getN for using value of attribute.
     *  This method will get value of attribute.
     * @return n to get number.
     */
    public long getN() {
        return n;
    }

    /**
     * Method setN for setting value of attribute.
     * Throw exception when wrong format setN().
     * @param n get number of Fibonacci.
     * @throws java.lang.Exception
     */
    public void setN(long n) throws Exception {
        if (n < 1) {
            throw new Exception("Fibonacci series must start from positive integer");
        }
        this.n = n;
    }

    /**
     * Method fibonacciRecursion to find Fibonacci number using Recursion algorithm.
     *  Since Fibonacci Number is the summation of the two previous numbers. We can use recursion as per the following condition:
     *    1.Get the number whose Fibonacci series needs to be calculated. 
     *    2.Recursively iterate from value N to 1: 
     *      +Base case: If the value called recursively is less than 1, the return 1 the function. 
     *      +Recursive call: If the base case is not met, then recursively call for previous two value as:
     *        #recursive_function(N – 1) + recursive_function(N – 2);
     *      +Return statement: At each recursive call(except the base case), return the recursive function for the previous two value as:
     *        #recursive_function(N – 1) + recursive_function(N – 2);
     * @param n number of Fibonacci series.
     * @return recursionFibonacci(n - 1) + recursionFibonacci(n - 2) to recursion Fibonacci series;
     */
    public long recursionFibonacci(int n) {
        if (n <= 1) {       // Base Case: If n smaller than 1 return n. Example n = 0 return 0 n = 1 return 1.
            return n;
        }
        return recursionFibonacci(n - 1) + recursionFibonacci(n - 2); // Recursive call to caculating Fibonacci series.
    }
}
