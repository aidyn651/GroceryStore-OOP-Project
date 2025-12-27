package com.aidyn.grocerystore;
public class Sale {

    private int saleId;
    private String customerName;
    private double totalAmount;
    private String date;

    public Sale(int saleId, String customerName, double totalAmount, String date) {
        this.saleId = saleId;
        setCustomerName(customerName);
        setTotalAmount(totalAmount);
        setDate(date);
    }

    public int getSaleId() {
        return saleId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // Setters with validation
    public void setCustomerName(String customerName) {
        if (customerName != null && !customerName.isEmpty()) {
            this.customerName = customerName;
        } else {
            this.customerName = "Unknown";
        }
    }

    public void setTotalAmount(double totalAmount) {
        if (totalAmount >= 0) {
            this.totalAmount = totalAmount;
        } else {
            this.totalAmount = 0;
        }
    }

    public void setDate(String date) {
        if (date != null && !date.isEmpty()) {
            this.date = date;
        } else {
            this.date = "N/A";
        }
    }

    // Logic
    public void addItem(double price) {
        if (price > 0) {
            totalAmount += price;
        }
    }

    @Override
    public String toString() {
        return saleId + " | " + customerName +
                " | total: " + totalAmount +
                " | date: " + date;
    }
}
