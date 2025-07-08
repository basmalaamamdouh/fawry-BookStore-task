package com.quantum.bookstore.models;

public interface Product {
    String getISBN();
    String getTitle();
    double getPrice();
    int getYear();
    String getAuthor();
    boolean isForSale();
}