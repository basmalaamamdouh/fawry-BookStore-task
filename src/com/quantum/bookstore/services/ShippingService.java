package com.quantum.bookstore.services;

import com.quantum.bookstore.models.Product;
import com.quantum.bookstore.models.PaperBook;
import com.quantum.bookstore.data.CustomerAddress;

/**
 * Service for handling paper book shipping
 */
public class ShippingService {
    public void ship(Product product, int quantity, CustomerAddress address) {
        if (!(product instanceof PaperBook)) {
            throw new IllegalArgumentException("Quantum book store: Invalid product type for shipping");
        }
        
        System.out.println("Quantum book store: Shipping " + quantity + "x \"" + product.getTitle() + "\" to " + address.getAddress());
    }
}