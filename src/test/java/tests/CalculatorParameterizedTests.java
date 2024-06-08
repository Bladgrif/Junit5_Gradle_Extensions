package tests;

import Junit5_Gradle_Extensions.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorParameterizedTests {

    private Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "2, 3, 5",
            "3, 4, 7"
    })
    @DisplayName("Addition using @CsvSource")
    @Tags({@Tag("unitTest"), @Tag("parametrized")})
    void testAdditionCsvSource(int a, int b, int expectedResult) {
        assertEquals(expectedResult, calculator.addition(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 2",
            "2, 1, 1",
            "8, 5, 3"
    })
    @DisplayName("Subtract using @CsvSource")
    @Tags({@Tag("unitTest"), @Tag("parametrized")})
    void testSubtractCsvSource(int a, int b, int expectedResult) {
        assertEquals(expectedResult, calculator.subtract(a, b));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/addition.csv", numLinesToSkip = 1)
    @DisplayName("Addition using @CsvFileSource")
    @Tags({@Tag("unitTest"), @Tag("parametrized")})
    void testAdditionCsvFile(int a, int b, int result) {
        assertEquals(result, calculator.addition(a, b));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/subtraction.csv", numLinesToSkip = 1)
    @DisplayName("Subtract using @CsvFileSource")
    @Tags({@Tag("unitTest"), @Tag("parametrized")})
    void testSubtractCsvFile(int a, int b, int result) {
        assertEquals(result, calculator.subtract(a, b));
    }
}
