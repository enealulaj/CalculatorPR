package org.example;

public class NegativeNumberException extends Exception {
  public NegativeNumberException() {
    super("Cannot calculate the square root of a negative number.");
  }
}
