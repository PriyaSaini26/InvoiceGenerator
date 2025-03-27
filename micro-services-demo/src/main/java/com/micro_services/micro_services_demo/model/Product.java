package com.micro_services.micro_services_demo.model;

public class Product {
    private String name;
    private int quantity;
    private double amount;
    private double taxPercentage;

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getAmount() { return amount; }
    public double getTaxPercentage() { return taxPercentage; }
}
