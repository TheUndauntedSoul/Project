package com.mycompany.fk;

public class PayrollCalculator {

    // SSS 2025: 15% Total (10% ER, 5% EE) 
    // Min MSC: 5,000 | Max MSC: 35,000
    public static double getSSSEmployeeShare(double monthlySalary) {
        double msc = Math.max(5000, Math.min(monthlySalary, 35000));
        return (msc * 0.05) / 2; // 5% EE share, halved for bi-monthly
    }

    // PhilHealth 2025-2026: 5% Total (2.5% ER, 2.5% EE)
    public static double getPhilHealthShare(double monthlySalary) {
        return (monthlySalary * 0.025) / 2; // 2.5% EE share, halved for bi-monthly
    }

    // Pag-IBIG: Fixed 200 total (100 ER, 100 EE)
    public static double getPagIBIGShare() {
        return 200.00 / 2; // Halved for bi-monthly
    }

    // BIR Semi-Monthly Tax Table (2023 onwards)
    public static double calculateTax(double taxableIncome) {
        if (taxableIncome <= 10417) {
            return 0;
        } else if (taxableIncome <= 16666) {
            return (taxableIncome - 10417) * 0.15;
        } else if (taxableIncome <= 33332) {
            return 937.50 + ((taxableIncome - 16667) * 0.20);
        } else if (taxableIncome <= 83332) {
            return 4270.70 + ((taxableIncome - 33333) * 0.25);
        } else if (taxableIncome <= 333332) {
            return 16770.70 + ((taxableIncome - 83333) * 0.30);
        } else {
            return 91770.70 + ((taxableIncome - 333333) * 0.35);
        }
    }
}