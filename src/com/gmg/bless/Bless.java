package com.gmg.bless;

/**
 * Created by gmg on on 2018-01-17 11:45.
 */
public class Bless {
    private int count;
    private double amount;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Bless(int count, double amount) {
        this.count = count;
        this.amount = amount;
    }

    public Bless() {
    }
}
