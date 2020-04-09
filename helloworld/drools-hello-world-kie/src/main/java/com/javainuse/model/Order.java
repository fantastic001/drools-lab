package com.javainuse.model;

import java.util.ArrayList;


public class Order {
    private ArrayList<OrderedProduct> items;
    public Order() {
        items = new ArrayList<>();
    }

    public Order(ArrayList<OrderedProduct> items) {
        this.items = items;
    }
}