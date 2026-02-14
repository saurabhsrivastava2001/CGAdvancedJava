package com.salary;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeSalaryCalculatorTest {

    // Positive Test Case 1: Valid salary calculation
    @Test
    void testValidSalaryCalculation() {
        EmployeeSalaryCalculator calculator =
                new EmployeeSalaryCalculator(20000, 5000, 10);

        calculator.validateSalary();
    }

    // Test HRA Calculation
    @Test
    void testCalculateHRA() {
        EmployeeSalaryCalculator calculator =
                new EmployeeSalaryCalculator(20000, 5000, 10);

        assertEquals(4000, calculator.calculateHRA());
    }

    // Test DA Calculation
    @Test
    void testCalculateDA() {
        EmployeeSalaryCalculator calculator =
                new EmployeeSalaryCalculator(20000, 5000, 10);

        assertEquals(2000, calculator.calculateDA());
    }

    // Test Gross Salary
    @Test
    void testCalculateGrossSalary() {
        EmployeeSalaryCalculator calculator =
                new EmployeeSalaryCalculator(20000, 5000, 10);

        assertEquals(31000, calculator.calculateGrossSalary());
    }

    // Test Net Salary
    @Test
    void testCalculateNetSalary() {
        EmployeeSalaryCalculator calculator =
                new EmployeeSalaryCalculator(20000, 5000, 10);

        assertEquals(27900, calculator.calculateNetSalary());
    }

    // Negative Test: Basic salary = 0
    @Test
    void testBasicSalaryZero() {
        EmployeeSalaryCalculator calculator =
                new EmployeeSalaryCalculator(0, 5000, 10);

        assertThrows(IllegalArgumentException.class,
                calculator::validateSalary);
    }

    // Negative Test: Negative salary
    @Test
    void testNegativeSalary() {
        EmployeeSalaryCalculator calculator =
                new EmployeeSalaryCalculator(-10000, 5000, 10);

        assertThrows(IllegalArgumentException.class,
                calculator::validateSalary);
    }

    // Negative Test: Tax > 100
    @Test
    void testInvalidTaxPercent() {
        EmployeeSalaryCalculator calculator =
                new EmployeeSalaryCalculator(20000, 5000, 120);

        assertThrows(IllegalArgumentException.class,
                calculator::validateSalary);
    }
}
