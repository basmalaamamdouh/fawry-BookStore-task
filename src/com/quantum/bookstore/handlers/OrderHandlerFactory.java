package com.quantum.bookstore.handlers;

import com.quantum.bookstore.models.Product;
import com.quantum.bookstore.models.PaperBook;
import com.quantum.bookstore.models.EBook;
import com.quantum.bookstore.services.ShippingService;
import com.quantum.bookstore.services.MailService;

/**
 * Factory class for creating appropriate order handlers
 */
public class OrderHandlerFactory {
    public static OrderHandler createHandler(Product product) {
        if (product instanceof PaperBook) {
            return new PaperBookOrderHandler(new ShippingService());
        } else if (product instanceof EBook) {
            return new EBookOrderHandler(new MailService());
        } else {
            throw new IllegalArgumentException("Quantum book store: No order handler available for this product type");
        }
    }
}