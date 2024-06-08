package tests;

import Junit5_Gradle_Extensions.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {

    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    @Tag("unitTest")
    void testAdd() {
        assertEquals(5, calculator.addition(2, 3));
    }

    @Test
    @Tag("unitTest")
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
    }
}
