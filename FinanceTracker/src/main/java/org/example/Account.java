package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class Account {
    private LocalDate date;
    private String description;
    private String vendor;
    private double amount;
    private LocalTime time;

    public Account(LocalDate date, String description, String vendor, double amount, LocalTime time) {
        this.date = date;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
        this.time = time;
    }
    public String toString(){
        return String.format("Date: %s, Description: %s, Vendor: %s, Amount: %.2f, Time: %s",
                date, description, vendor, amount, time);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

}

