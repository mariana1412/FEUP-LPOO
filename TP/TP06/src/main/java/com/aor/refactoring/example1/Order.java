package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> lines;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        lines.add(new OrderLine(product, quantity));
    }

    public double calculateTotal(){
        double total = 0;

        for (OrderLine line : lines)
            total += line.calculateTotal();

        return total;
    }

    public boolean isElegibleForFreeDelivery() {
        if (calculateTotal() > 100) return true;
        else return false;
    }

    public String printOrder() {
        StringBuffer printBuffer = new StringBuffer();

        for (OrderLine line : lines)
            printBuffer.append(line);

        double total = calculateTotal();

        printBuffer.append("Total: " + total);

        return printBuffer.toString();
    }
}