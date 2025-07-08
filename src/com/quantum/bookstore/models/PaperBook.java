package com.quantum.bookstore.models;

/**
 * Represents a paper book with stock management
 */
public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, double price, int year, String author, int stock) {
        super(isbn, title, price, year, author);
        this.stock = stock;
    }

    @Override
    public boolean isForSale() {
        return stock > 0;
    }

    public int getStock() {
        return stock;
    }

    public void decreaseStock(int quantity) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Quantum book store: Not enough stock for " + title + " (ISBN: " + isbn + ")");
        }
        stock -= quantity;
    }

    public void increaseStock(int quantity) {
        stock += quantity;
    }
}