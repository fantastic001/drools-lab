package com.javainuse.model;

import com.javainuse.model.Product;

public class OrderedProduct {
    private int amount; 
    private Product product;

    public OrderedProduct(int amount, Product product) {
        this.amount = amount;
        this.product = product;
    }


}