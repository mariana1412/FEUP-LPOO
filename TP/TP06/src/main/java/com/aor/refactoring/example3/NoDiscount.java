package com.aor.refactoring.example3;

public class NoDiscount extends Discount {
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
