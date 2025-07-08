package com.quantum.bookstore.handlers;

import com.quantum.bookstore.models.Product;
import com.quantum.bookstore.models.EBook;
import com.quantum.bookstore.services.MailService;
import com.quantum.bookstore.data.CustomerEmail;

/**
 * Order handler for EBooks
 */
public class EBookOrderHandler extends OrderHandler {
    private MailService mailService;

    public EBookOrderHandler(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public double handleOrder(Product product, int quantity, String email, String address) {
        if (!(product instanceof EBook)) {
            throw new IllegalArgumentException("Quantum book store: Expected EBook product");
        }
        
        EBook eBook = (EBook) product;
        
        if (!eBook.isForSale()) {
            throw new IllegalStateException("Quantum book store: Book is not for sale: " + eBook.getTitle());
        }
        
        double totalPrice = eBook.getPrice() * quantity;
        mailService.sendEmail(eBook, quantity, new CustomerEmail(email));
        return totalPrice;
    }
}