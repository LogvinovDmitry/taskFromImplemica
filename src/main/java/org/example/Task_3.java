package org.example;

import java.math.BigInteger;

public class Task_3 {
    public static void main(String[] args) {
        // Calculate the factorial of 100
        BigInteger factorial = factorial(100);

        // Convert factorial to string
        String factorialStr = factorial.toString();

        // We calculate the sum of the digits
        int sum = 0;
        for (char digit : factorialStr.toCharArray()) {
            // We convert the symbol into a number and add it to the sum
            sum += Character.getNumericValue(digit);
        }

        System.out.println("The sum of the digits of the number 100! = " + sum);
    }

    // Method to calculate factorial using BigInteger
    private static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
