package tests;

import Junit5_Gradle_Extensions.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorParameterizedTests {

    private Calculator calculator = new Calculator();

    @ParameterizedTest(name  = "var a = {0}, var b  =  {1}, result =  {2}")
    @CsvSource({
            "1, 2, 3",
            "2, 3, 5",
            "3, 4, 7"
    })
    @DisplayName("Addition using @CsvSource")
    @Tags({
            @Tag("unit"),
            @Tag("parametrized")})
    void testAdditionCsvSource(int a, int b, int expectedResult) {
        assertEquals(expectedResult, calculator.addition(a, b));
    }

    @ParameterizedTest(name  = "var a = {0}, var b  =  {1}, result =  {2}")
    @CsvSource({
            "5, 3, 2",
            "2, 1, 1",
            "8, 5, 3"
    })
    @DisplayName("Subtract using @CsvSource")
    @Tags({
            @Tag("unit"),
            @Tag("parametrized")})
    void testSubtractCsvSource(int a, int b, int expectedResult) {
        assertEquals(expectedResult, calculator.subtract(a, b));
    }

    @ParameterizedTest(name  = "var a = {0}, var b  =  {1}, result =  {2}")
    @CsvFileSource(resources = "/addition.csv", numLinesToSkip = 1)
    @DisplayName("Addition using @CsvFileSource")
    @Tags({
            @Tag("unit"),
            @Tag("parametrized")})
    void testAdditionCsvFile(int a, int b, int result) {
        assertEquals(result, calculator.addition(a, b));
    }

    @ParameterizedTest(name  = "var a = {0}, var b  =  {1}, result =  {2}")
    @CsvFileSource(resources = "/subtraction.csv", numLinesToSkip = 1)
    @DisplayName("Subtract using @CsvFileSource")
    @Tags({
            @Tag("unit"),
            @Tag("parametrized")})
    void testSubtractCsvFile(int a, int b, int result) {
        assertEquals(result, calculator.subtract(a, b));
    }

    static Stream<Arguments> additionArguments() {
        return Stream.of(
                arguments(1, 1, 2),
                arguments(2, 3, 5),
                arguments(5, 5, 10),
                arguments(-1, 1, 0),
                arguments(10, -10, 0)
        );
    }

    @ParameterizedTest(name  = "var a = {0}, var b  =  {1}, result =  {2}")
    @MethodSource("additionArguments")
    @DisplayName("Subtract using @MethodSource")
    @Tags({
            @Tag("unit"),
            @Tag("parametrized")})
    void testAddition(int a, int b, int expectedResult) {
        assertEquals(expectedResult, calculator.addition(a, b));
    }
}
