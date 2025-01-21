# Calculator Project Documentation

## Overview
This project provides a simple `Calculator` class in Java that supports basic arithmetic operations: addition, subtraction, multiplication, and division. It also includes a custom exception to handle division by zero and corresponding unit tests.

## Project Structure

```
CalculatorProject/
|-- src/
|   |-- org/example/
|       |-- Calculator.java
|       |-- CalculatorTest.java
|       |-- DivideByZeroException.java
```

## Code Explanation

### 1. `Calculator.java`
This class provides four basic arithmetic operations:

```java
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
}
```

#### Methods:
- **`add(int a, int b)`**: Returns the sum of two integers.
- **`subtract(int a, int b)`**: Returns the difference between two integers.
- **`multiply(int a, int b)`**: Returns the product of two integers.
- **`divide(int a, int b)`**: Returns the quotient of two integers and throws a custom exception if the divisor is zero.

---

### 2. `DivideByZeroException.java`
A custom exception class to handle division by zero.

```java
package org.example;

public class DivideByZeroException extends Exception {
}
```

---

### 3. `CalculatorTest.java`
Unit tests for the `Calculator` class using JUnit 5 framework.

```java
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
        assertEquals(5, calculator.divide(20, 4));
        assertNotEquals(3, calculator.divide(4, 3));
        assertThrows(DivideByZeroException.class, () -> calculator.divide(12, 0));
    }
}
```

#### Explanation:
- **`@BeforeEach`**: Initializes the `Calculator` object before each test.
- **`add()`**: Tests the `add` method with valid and invalid cases.
- **`subtract()`**: Tests the `subtract` method.
- **`multiply()`**: Tests the `multiply` method.
- **`divide()`**: Tests the `divide` method, including handling of the `DivideByZeroException`.

## Running the Tests

To run the tests, use the following command in the project root:

```sh
mvn test
```

Make sure you have JUnit 5 dependencies added to your `pom.xml` if using Maven:

```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.9.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Conclusion
This project demonstrates a simple calculator implementation with basic arithmetic operations and unit tests to ensure correctness.
