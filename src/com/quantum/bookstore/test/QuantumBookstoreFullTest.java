package com.quantum.bookstore.test;

import com.quantum.bookstore.core.QuantumBookstore;
import com.quantum.bookstore.models.*;
import java.util.List;

/**
 * Comprehensive test class for the Quantum Bookstore system
 */
public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        QuantumBookstore store = new QuantumBookstore();
        
        // Test 1: Adding various types of books to inventory
        System.out.println("=== Test 1: Adding Books to Inventory ===");
        store.addBook(new PaperBook("111-2-333-44444-5", "Data Structures and Algorithms", 55.75, 2021, "roaa", 25));
        store.addBook(new EBook("222-3-444-55555-6", "Introduction to Machine Learning", 42.50, 2020, "tito", "PDF"));
        store.addBook(new PaperBook("333-4-555-66666-7", "System Design Interview", 38.95, 2019, "bosy", 18));
        store.addBook(new EBook("444-5-666-77777-8", "Deep Learning Fundamentals", 65.00, 2022, "grapes", "EPUB"));
        store.addBook(new PaperBook("555-6-777-88888-9", "Web Development with React", 47.25, 2023, "3noub", 30));
        store.addBook(new EBook("666-7-888-99999-0", "Database Systems Concepts", 52.80, 2018, "bontos", "PDF"));
        store.addBook(new ShowcaseBook("777-8-999-00000-1", "Future of Artificial Intelligence", 0, 2025, "mazen"));
        
        System.out.println("Quantum book store: Current inventory count: " + store.getInventoryCount());
        
        // Test 2: Purchasing paper books
        System.out.println("\n=== Test 2: Paper Book Purchases ===");
        try {
            double cost1 = store.buyBook("111-2-333-44444-5", 5, "customer1@dgfdf.com", "sanfa");
            System.out.println("Quantum book store: Purchase successful. Total paid: $" + cost1);
        } catch (Exception e) {
            System.err.println("Quantum book store: Purchase failed: " + e.getMessage());
        }
        
        try {
            double cost2 = store.buyBook("333-4-555-66666-7", 3, "customer1@dgfdf.com", "qalyub");
            System.out.println("Quantum book store: Purchase successful. Total paid: $" + cost2);
        } catch (Exception e) {
            System.err.println("Quantum book store: Purchase failed: " + e.getMessage());
        }
        
        // Test 3: Purchasing EBooks
        System.out.println("\n=== Test 3: EBook Purchases ===");
        try {
            double cost3 = store.buyBook("222-3-444-55555-6", 2, "customer1@dgfdf.com", "ali mar3y");
            System.out.println("Quantum book store: Purchase successful. Total paid: $" + cost3);
        } catch (Exception e) {
            System.err.println("Quantum book store: Purchase failed: " + e.getMessage());
        }
        
        try {
            double cost4 = store.buyBook("444-5-666-77777-8", 1, "customer1@dgfdf.com", "qalyub tany");
            System.out.println("Quantum book store: Purchase successful. Total paid: $" + cost4);
        } catch (Exception e) {
            System.err.println("Quantum book store: Purchase failed: " + e.getMessage());
        }
        
        // Test 4: Attempting to purchase showcase book (should fail)
        System.out.println("\n=== Test 4: Showcase Book Purchase Attempt ===");
        try {
            store.buyBook("777-8-999-00000-1", 1, "customer1@dgfdf.com", "october");
        } catch (Exception e) {
            System.err.println("Quantum book store: Expected error: " + e.getMessage());
        }
        
        // Test 5: Attempting to purchase non-existent book
        System.out.println("\n=== Test 5: Non-existent Book Purchase Attempt ===");
        try {
            store.buyBook("000-0-000-00000-0", 1, "customer1@dgfdf.com", "fawry");
        } catch (Exception e) {
            System.err.println("Quantum book store: Expected error: " + e.getMessage());
        }
        
        // Test 6: Attempting to purchase more than available stock
        System.out.println("\n=== Test 6: Excessive Quantity Purchase Attempt ===");
        try {
            store.buyBook("333-4-555-66666-7", 50, "customer1@dgfdf.com", "sanfa2");
        } catch (Exception e) {
            System.err.println("Quantum book store: Expected error: " + e.getMessage());
        }
        
        // Test 7: Removing outdated books
        System.out.println("\n=== Test 7: Removing Outdated Books ===");
        List<Product> outdatedBooks = store.removeOutdatedBooks(12);
        System.out.println("Quantum book store: Removed " + outdatedBooks.size() + " outdated books");
        for (Product book : outdatedBooks) {
            System.out.println("Quantum book store: - Removed: " + book.getTitle() + " by " + book.getAuthor() + " (" + book.getYear() + ")");
        }
        System.out.println("Quantum book store: Updated inventory count: " + store.getInventoryCount());
        
        // Test 8: Additional purchases after removal
        System.out.println("\n=== Test 8: Post-Removal Purchases ===");
        try {
            double cost5 = store.buyBook("555-6-777-88888-9", 4, "customer1@dgfdf.com", "lmao");
            System.out.println("Quantum book store: Purchase successful. Total paid: $" + cost5);
        } catch (Exception e) {
            System.err.println("Quantum book store: Purchase failed: " + e.getMessage());
        }
        
        // Test 9: Multiple EBook purchases
        System.out.println("\n=== Test 9: Multiple EBook Purchases ===");
        try {
            double cost6 = store.buyBook("666-7-888-99999-0", 3, "customer1@dgfdf.com", "lol");
            System.out.println("Quantum book store: Purchase successful. Total paid: $" + cost6);
        } catch (Exception e) {
            System.err.println("Quantum book store: Purchase failed: " + e.getMessage());
        }
        
        System.out.println("\n=== Testing Complete ===");
        System.out.println("Quantum book store: Final inventory count: " + store.getInventoryCount());
    }
}