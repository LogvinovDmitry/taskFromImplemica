package org.example;


import java.math.BigInteger;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {

        // Create a scanner to work with the client
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();

        // Check "N must be non-negative!"
        if (N < 0) {
            System.out.println("N must be non-negative!");
            return;
        }

        System.out.println("Number of correct bracket expressions: " + catalanFormula(N));
    }

    // Method for calculating the Catalan number
    private static BigInteger catalanFormula(int n) {
        // Formula: C(n) = (2n)! / ((n+1)! * n!)
        BigInteger numerator = factorial(2 * n); // (2n)!
        BigInteger denominator = factorial(n + 1).multiply(factorial(n)); // (n+1)! * n!
        // Here we divide the numerator by the denominator
        return numerator.divide(denominator);
    }

    // Method for calculating factorial with BigInteger
    private static BigInteger factorial(int n) {
        // Start with 1
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
