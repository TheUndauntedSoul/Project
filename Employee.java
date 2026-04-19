package com.mycompany.fk;

abstract class Employee {
    protected String id, name;
    protected double rate;

    public Employee(String id, String name, double rate) {
        this.id = id;
        this.name = name;
        this.rate = rate;
    }

    public abstract double calculateBasePay(double hrs);
    public abstract boolean hasLeaveBenefits();
}

class RegularEmployee extends Employee {
    public RegularEmployee(String id, String fn, double r) { super(id, fn, r); }
    // Regulars get half of their monthly salary as base pay for the cutoff
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
    // Part-timers are paid exactly by the hours they worked
    @Override public double calculateBasePay(double hrs) { return rate * hrs; }
    @Override public boolean hasLeaveBenefits() { return false; }
}