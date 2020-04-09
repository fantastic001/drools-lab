package com.javainuse.model;

import com.javainuse.model.Product;

public class OrderedProduct {
    private int amount; 
    private Product product;
    private Order order;

    public OrderedProduct(int amount, Product product) {
        this.amount = amount;
        this.product = product;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    public Order getOrder() {
        return this.order;
    }

    public int getAmount() 
    {
        return this.amount;
    }

    public Product getProduct() {
        return this.product;
    }


}