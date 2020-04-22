package com.javainuse.model;

import java.util.ArrayList;
import org.drools.core.factmodel.traits.Traitable;


import com.javainuse.model.OrderedProduct;

@Traitable
public class Order {
    private ArrayList<OrderedProduct> items;
    private double discount; 
    public Order() {
        items = new ArrayList<>();
        discount = 1;
    }

    public Order(ArrayList<OrderedProduct> items) {
        this.items = items;
        this.discount = 1;
        for (OrderedProduct op : items) {
            op.setOrder(this);
        }
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public int getTotal() {
        int sum = 0;
        for (OrderedProduct item : this.items) {
            sum += item.getAmount() * item.getProduct().getPrice();
        }
        return sum;
    }

}