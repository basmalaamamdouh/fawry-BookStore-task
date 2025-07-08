package com.quantum.bookstore.models;

/**
 * Represents a showcase/demo book that is not for sale
 */
public class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title, double price, int year, String author) {
        super(isbn, title, price, year, author);
    }

    @Override
    public boolean isForSale() {
        return false; // Showcase books are never for sale
    }
}