package com.quantum.bookstore.core;

import com.quantum.bookstore.models.Product;
import com.quantum.bookstore.handlers.OrderHandler;
import com.quantum.bookstore.handlers.OrderHandlerFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

/**
 * Main bookstore class managing inventory and orders
 */
public class QuantumBookstore {
    private Map<String, Product> inventory;

    public QuantumBookstore() {
        inventory = new HashMap<>();
    }

    public void addBook(Product book) {
        inventory.put(book.getISBN(), book);
        System.out.println("Quantum book store: Added book: " + book.getTitle() + " by " + book.getAuthor() + " (" + book.getISBN() + ")");
    }

    public Product getBook(String isbn) {
        return inventory.get(isbn);
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Product book = getBook(isbn);
        
        if (book == null) {
            throw new IllegalArgumentException("Quantum book store: Book with ISBN " + isbn + " not found in inventory");
        }

        if (!book.isForSale()) {
            throw new IllegalStateException("Quantum book store: Book " + book.getTitle() + " is not for sale");
        }

        OrderHandler handler = OrderHandlerFactory.createHandler(book);
        double totalPrice = handler.handleOrder(book, quantity, email, address);
        
        return totalPrice;
    }

    public List<Product> removeOutdatedBooks(int maxAgeInYears) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Product> outdatedBooks = new ArrayList<>();
        List<String> toRemove = new ArrayList<>();
        
        for (Map.Entry<String, Product> entry : inventory.entrySet()) {
            Product book = entry.getValue();
            if (currentYear - book.getYear() > maxAgeInYears) {
                outdatedBooks.add(book);
                toRemove.add(entry.getKey());
            }
        }
        
        for (String isbn : toRemove) {
            inventory.remove(isbn);
        }
        
        return outdatedBooks;
    }

    public int getInventoryCount() {
        return inventory.size();
    }
}