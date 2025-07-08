package com.quantum.bookstore.services;

import com.quantum.bookstore.models.Product;
import com.quantum.bookstore.models.EBook;
import com.quantum.bookstore.data.CustomerEmail;

/**
 * Service for handling EBook email delivery
 */
public class MailService {
    public void sendEmail(Product product, int quantity, CustomerEmail email) {
        if (!(product instanceof EBook)) {
            throw new IllegalArgumentException("Quantum book store: Invalid product type for email delivery");
        }
        
        EBook eBook = (EBook) product;
        System.out.println("Quantum book store: Sending \"" + eBook.getTitle() + "\" (" + eBook.getFileType() + ") to " + email.getEmail());
    }
}