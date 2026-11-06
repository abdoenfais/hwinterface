package com.payroll;

public interface Taxable {
    double TAX_RATE = 0.15; // معدل الضريبة الافتراضي 15%
    double calculateTax();
}