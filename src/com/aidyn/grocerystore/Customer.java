package com.aidyn.grocerystore;

public class Customer {

    private int customerId;
    private String name;
    private String membershipLevel;
    private double totalPurchases;

    public Customer(int customerId, String name, String membershipLevel, double totalPurchases) {
        this.customerId = customerId;
        setName(name);
        setMembershipLevel(membershipLevel);
        setTotalPurchases(totalPurchases);
    }

    // Getters
    public int getCustomerId() {
        return customerId;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public double getTotalPurchases() {
        return totalPurchases;
    }

    // Setters with validation
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            this.name = "No name";
        }
    }

    public void setMembershipLevel(String membershipLevel) {
        if (membershipLevel != null && !membershipLevel.isEmpty()) {
            this.membershipLevel = membershipLevel;
        } else {
            this.membershipLevel = "Regular";
        }
    }

    public void setTotalPurchases(double totalPurchases) {
        if (totalPurchases >= 0) {
            this.totalPurchases = totalPurchases;
        } else {
            this.totalPurchases = 0;
        }
    }

    // Logic
    public void addPurchase(double amount) {
        if (amount > 0) {
            totalPurchases += amount;
        }
    }

    public boolean isVIP() {
        return totalPurchases > 100000;
    }

    @Override
    public String toString() {
        return customerId + " | " + name +
                " | level: " + membershipLevel +
                " | purchases: " + totalPurchases;
    }
}

