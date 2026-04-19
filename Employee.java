package com.mycompany.fk;

public abstract class Employee {
    protected String id, fullName;
    protected double rate;

    public Employee(String id, String fullName, double rate) {
        this.id = id; this.fullName = fullName; this.rate = rate;
    }

    // 20-day standard formula from reference
    public double getHourlyRate() { return (rate / 20) / 8; }
    public double getMinuteRate() { return getHourlyRate() / 60.0; }

    public abstract double calculateBasePay(double totalWorkedHours);
    public abstract boolean hasLeaveBenefits();
    public String getId() { return id; }
    public String getFullName() { return fullName; }
}

class RegularEmployee extends Employee {
    public RegularEmployee(String id, String fn, double r) { super(id, fn, r); }
    @Override public double calculateBasePay(double hrs) { return rate / 2; }
    @Override public boolean hasLeaveBenefits() { return true; }
}

class ProbationaryEmployee extends Employee {
    public ProbationaryEmployee(String id, String fn, double r) { super(id, fn, r); }
    @Override public double calculateBasePay(double hrs) { return rate / 2; }
    @Override public boolean hasLeaveBenefits() { return true; }
}

class ContractualEmployee extends Employee {
    public ContractualEmployee(String id, String fn, double r) { super(id, fn, r); }
    @Override public double calculateBasePay(double hrs) { return rate / 2; }
    @Override public boolean hasLeaveBenefits() { return false; }
}

class PartTimer extends Employee {
    public PartTimer(String id, String fn, double r) { super(id, fn, r); }
    @Override public double getHourlyRate() { return rate; }
    @Override public double calculateBasePay(double hrs) { return rate * hrs; }
    @Override public boolean hasLeaveBenefits() { return false; }
}
