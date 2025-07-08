package com.quantum.bookstore.handlers;

import com.quantum.bookstore.models.Product;

/**
 * Abstract base class for order handling
 */
public abstract class OrderHandler {
    public abstract double handleOrder(Product product, int quantity, String email, String address);
}