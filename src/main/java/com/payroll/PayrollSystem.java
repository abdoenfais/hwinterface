package com.payroll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PayrollSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        employees.add(new FullTimeEmployee("E101", "أحمد محمد", 4500.0, LocalDate.of(2021, 3, 15), 800.0));
        employees.add(new ContractorEmployee("C201", "خالد علي", LocalDate.of(2023, 6, 10), 25, 180));
        employees.add(new FullTimeEmployee("E102", "سارة خالد", 6000.0, LocalDate.of(2019, 11, 1), 1200.0));
        employees.add(new ContractorEmployee("C202", "محمود حسن", LocalDate.of(2022, 1, 20), 30, 160));

        System.out.println("=== 1. قائمة الموظفين قبل الفرز ===");
        for (Employee e : employees) {
            System.out.println(e);
        }

        // الفرز باستخدام Comparable (تنازلياً حسب صافي الراتب)
        Collections.sort(employees);
        System.out.println("\n=== 2. القائمة بعد الفرز التنازلي حسب صافي الراتب (Comparable) ===");
        for (Employee e : employees) {
            System.out.println(e);
        }

        // الفرز باستخدام Comparator حسب تاريخ الانضمام (الأقدمية)
        employees.sort(Comparator.comparing(Employee::getJoinDate));
        System.out.println("\n=== 3. القائمة بعد الفرز حسب الأقدمية (Comparator) ===");
        for (Employee e : employees) {
            System.out.println(String.format("ID: %s | Name: %s | Join Date: %s", e.getId(), e.getName(), e.getJoinDate()));
        }

        // حساب إجمالي الضرائب والمكافآت (Polymorphism)
        double totalTax = 0;
        double totalBonus = 0;
        double defaultScore = 4.3;

        for (Employee e : employees) {
            totalTax += e.calculateTax();
            totalBonus += e.calculateBonus(defaultScore);
        }

        System.out.println("\n=== 4. التقرير المالي الإجمالي ===");
        System.out.printf("إجمالي الضرائب: %.2f\n", totalTax);
        System.out.printf("إجمالي المكافآت: %.2f\n", totalBonus);
    }
}