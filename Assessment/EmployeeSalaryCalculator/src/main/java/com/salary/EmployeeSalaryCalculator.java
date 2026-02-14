package com.salary;

public class EmployeeSalaryCalculator {

    private double basicSalary;
    private double bonus;
    private double taxPercent;

    // Constructor
    public EmployeeSalaryCalculator(double basicSalary, double bonus, double taxPercent) {
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.taxPercent = taxPercent;
    }

    // Validation Method
    public void validateSalary() {
        if (basicSalary <= 0) {
            throw new IllegalArgumentException("Basic salary must be greater than 0");
        }

        if (taxPercent < 0 || taxPercent > 100) {
            throw new IllegalArgumentException("Tax percent must be between 0 and 100");
        }
    }

    // HRA = 20% of basic
    public double calculateHRA() {
        return basicSalary * 0.20;
    }

    // DA = 10% of basic
    public double calculateDA() {
        return basicSalary * 0.10;
    }

    // Gross Salary
    public double calculateGrossSalary() {
        return basicSalary + calculateHRA() + calculateDA() + bonus;
    }

    // Net Salary
    public double calculateNetSalary() {
        double gross = calculateGrossSalary();
        double taxDeduction = gross * (taxPercent / 100);
        return gross - taxDeduction;
    }
}
