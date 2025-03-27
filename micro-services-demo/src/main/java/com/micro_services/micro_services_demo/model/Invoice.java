package com.micro_services.micro_services_demo.model;

import java.util.List;

public class Invoice {
    private String invoiceNumber;
    private String customerName;
    private String date;
    private List<Product> products;

    public String getInvoiceNumber() { return invoiceNumber; }
    public String getCustomerName() { return customerName; }
    public String getDate() { return date; }
    public List<Product> getProducts() { return products; }
}
