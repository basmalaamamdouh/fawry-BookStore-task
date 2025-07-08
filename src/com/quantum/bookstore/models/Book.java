package com.quantum.bookstore.models;

public abstract class Book implements Product {
    protected String isbn;
    protected String title;
    protected double price;
    protected int year;
    protected String author;

    public Book(String isbn, String title, double price, int year, String author) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.year = year;
        this.author = author;
    }

    @Override
    public String getISBN() {
        return isbn;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public abstract boolean isForSale();
}