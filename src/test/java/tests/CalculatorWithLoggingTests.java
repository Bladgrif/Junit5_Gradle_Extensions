package tests;

import Junit5_Gradle_Extensions.Calculator;
import extension.LoggingExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LoggingExtension.class)
public class CalculatorWithLoggingTests {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Addition test")
    @Tag("unit")
    void testAdd() {
        assertEquals(5, calculator.addition(2, 3));
    }

    @Test
    @DisplayName("Subtraction test")
    @Tag("unit")
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
    }
}
