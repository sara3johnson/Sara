package org.example;

import java.util.Date;



public class Transactions {
    private Date date;
    private String description;
    private String vendor;
    private double amount;

    public Transactions(Date date, String description, String vendor, double amount) {
        this.date = date;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
