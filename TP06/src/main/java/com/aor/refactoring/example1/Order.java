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

    public boolean isElegibleForFreeDelivery() {
        double total = 0;

        for (OrderLine line : lines)
            total += line.getTotal();


        return (total > 100);
    }

    public String printOrder() {
        StringBuffer printBuffer = new StringBuffer();
        double total = 0;


        for (OrderLine line : lines){
            printBuffer.append(line.printOrderLine());
            total += line.getTotal();
        }

        printBuffer.append("Total: " + total);

        return printBuffer.toString();
    }
}