package org.example;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) throws DivideByZeroException {
        if (b == 0) {
            throw new DivideByZeroException();
        }
        return a / b;
    }

    public double wurzel(double a) throws NegativeNumberException {
        if (a < 0) {
            throw new NegativeNumberException();
        }
        return Math.sqrt(a);
    }

    public double powerOfTwo(double a) {
        return Math.pow(a, 2);
    }

    public double sinus(double radians) {
        return Math.sin(radians);
    }

    public double cosinus(double radians) {
        return Math.cos(radians);
    }
    public String toBinary(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Nur natürliche Zahlen erlaubt.");
        }
        return Integer.toBinaryString(number);
    }
}
