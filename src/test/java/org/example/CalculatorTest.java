package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void add() {
        assertEquals(8, calculator.add(3, 5));
        assertNotEquals(8, calculator.add(3, 4));
    }

    @Test
    void subtract() {
        assertEquals(-8, calculator.subtract(10, 18));
        assertNotEquals(8, calculator.subtract(15, 5));
    }

    @Test
    void multiply() {
        assertEquals(27, calculator.multiply(3, 9));
        assertNotEquals(27, calculator.multiply(3, 8));
    }

    @Test
    void divide() throws DivideByZeroException {
        try {
            assertEquals(5, calculator.divide(20, 4));
        } catch (DivideByZeroException e) {
            throw new RuntimeException();
        }

        try {
            assertNotEquals(3, calculator.divide(4, 3));
        } catch (DivideByZeroException e) {
            throw new RuntimeException();
        }
        assertThrows(DivideByZeroException.class, () -> calculator.divide(12, 0));
    }

    @Test
    void wurzel() throws NegativeNumberException {
        // Test positive numbers
        assertEquals(3.0, calculator.wurzel(9.0), 0.0001);
        assertEquals(4.0, calculator.wurzel(16.0), 0.0001);
        assertNotEquals(5.0, calculator.wurzel(20.0), 0.0001);

        // Test zero
        assertEquals(0.0, calculator.wurzel(0.0), 0.0001);

        // Test negative numbers (expect exception)
        assertThrows(NegativeNumberException.class, () -> calculator.wurzel(-4.0));
    }
    @Test
    void powerOfTwo() {
        // Test positive numbers
        assertEquals(16.0, calculator.powerOfTwo(4.0), 0.0001);
        assertEquals(6.25, calculator.powerOfTwo(2.5), 0.0001);

        // Test zero
        assertEquals(0.0, calculator.powerOfTwo(0.0), 0.0001);

        // Test negative numbers
        assertEquals(9.0, calculator.powerOfTwo(-3.0), 0.0001);
        assertEquals(1.44, calculator.powerOfTwo(-1.2), 0.0001);
    }
    @Test
    void sinus() {
        // Test for sine of 0 radians
        assertEquals(0.0, calculator.sinus(0.0), 0.0001);

        // Test for sine of π/2 radians
        assertEquals(1.0, calculator.sinus(Math.PI / 2), 0.0001);

        // Test for sine of π radians
        assertEquals(0.0, calculator.sinus(Math.PI), 0.0001);

        // Test for sine of 3π/2 radians
        assertEquals(-1.0, calculator.sinus(3 * Math.PI / 2), 0.0001);
    }

    @Test
    void cosinus() {
        // Test for cosine of 0 radians
        assertEquals(1.0, calculator.cosinus(0.0), 0.0001);

        // Test for cosine of π/2 radians
        assertEquals(0.0, calculator.cosinus(Math.PI / 2), 0.0001);

        // Test for cosine of π radians
        assertEquals(-1.0, calculator.cosinus(Math.PI), 0.0001);

        // Test for cosine of 3π/2 radians
        assertEquals(0.0, calculator.cosinus(3 * Math.PI / 2), 0.0001);
    }

    @Test
    void toBinary() {
        // Test für positive Zahlen
        assertEquals("1010", calculator.toBinary(10));
        assertEquals("1111", calculator.toBinary(15));

        // Test für Null
        assertEquals("0", calculator.toBinary(0));

        // Test für Ausnahme bei negativen Zahlen
        assertThrows(IllegalArgumentException.class, () -> calculator.toBinary(-5));
    }

}
