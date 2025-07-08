package com.quantum.bookstore.handlers;

import com.quantum.bookstore.models.Product;
import com.quantum.bookstore.models.PaperBook;
import com.quantum.bookstore.services.ShippingService;
import com.quantum.bookstore.data.CustomerAddress;

/**
 * Order handler for paper books
 */
public class PaperBookOrderHandler extends OrderHandler {
    private ShippingService shippingService;

    public PaperBookOrderHandler(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @Override
    public double handleOrder(Product product, int quantity, String email, String address) {
        if (!(product instanceof PaperBook)) {
            throw new IllegalArgumentException("Quantum book store: Expected PaperBook product");
        }
        
        PaperBook paperBook = (PaperBook) product;
        
        if (!paperBook.isForSale()) {
            throw new IllegalStateException("Quantum book store: Book is not for sale: " + paperBook.getTitle());
        }
        
        paperBook.decreaseStock(quantity);
        double totalPrice = paperBook.getPrice() * quantity;
        shippingService.ship(paperBook, quantity, new CustomerAddress(address));
        return totalPrice;
    }
}