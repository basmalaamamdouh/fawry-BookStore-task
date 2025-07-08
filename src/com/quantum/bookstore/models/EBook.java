package com.quantum.bookstore.models;

/**
 * Represents an electronic book with file type
 */
public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, double price, int year, String author, String fileType) {
        super(isbn, title, price, year, author);
        this.fileType = fileType;
    }

    @Override
    public boolean isForSale() {
        return true; // EBooks are always available
    }

    public String getFileType() {
        return fileType;
    }
}