# Quantum Bookstore System

---

```markdown
# Quantum Bookstore System

This is a comprehensive online bookstore management system implemented in Java, designed to handle various types of books including paper books, electronic books, and showcase books. The system supports inventory management, order processing, and automated fulfillment through shipping and email services.

## Features
- **Multi-Type Product Management**: Support for paper books (with stock), eBooks (with file types), and showcase books (display only).
- **Inventory Operations**: Add books to inventory, retrieve books by ISBN, and remove outdated books based on age.
- **Order Processing**: Handle book purchases with automatic stock management and order fulfillment.
- **Extensible Design**: Factory pattern and abstract handlers make it easy to add new product types without modifying existing code.
- **Service Integration**: Automated shipping for paper books and email delivery for eBooks.
- **Stock Management**: Real-time stock tracking with validation for paper books.
- **Error Handling**: Comprehensive error management for invalid orders, insufficient stock, and unsupported operations.

## Project Structure
The project follows a modular package structure with clear separation of concerns:
```

## Project Structure
```
quantum-bookstore/
├── src/
│   ├── com/
│   │   ├── quantum/
│   │   │   ├── bookstore/
│   │   │   │   ├── models/
│   │   │   │   │   ├── Product.java
│   │   │   │   │   ├── Book.java
│   │   │   │   │   ├── PaperBook.java
│   │   │   │   │   ├── EBook.java
│   │   │   │   │   └── ShowcaseBook.java
│   │   │   │   ├── services/
│   │   │   │   │   ├── ShippingService.java
│   │   │   │   │   └── MailService.java
│   │   │   │   ├── handlers/
│   │   │   │   │   ├── OrderHandlerFactory.java
│   │   │   │   │   ├── OrderHandler.java
│   │   │   │   │   ├── PaperBookOrderHandler.java
│   │   │   │   │   └── EBookOrderHandler.java
│   │   │   │   ├── data/
│   │   │   │   │   ├── CustomerAddress.java
│   │   │   │   │   └── CustomerEmail.java
│   │   │   │   ├── core/
│   │   │   │   │   └── QuantumBookstore.java
│   │   │   │   └── test/
│   │   │   │       └── QuantumBookstoreFullTest.java
└── README.md
```

### Package Descriptions
- **`com.quantum.bookstore.models`**: Contains product models and interfaces (Product, Book, PaperBook, EBook, ShowcaseBook).
- **`com.quantum.bookstore.services`**: Houses business services for shipping and email delivery.
- **`com.quantum.bookstore.handlers`**: Implements order processing logic using the Factory and Strategy patterns.
- **`com.quantum.bookstore.data`**: Data transfer objects for customer information.
- **`com.quantum.bookstore.core`**: Main bookstore management class.
- **`com.quantum.bookstore.test`**: Comprehensive test suite.

## Class and Method Explanations

### 1. `Product` (Interface)
- **Location**: `src/com/quantum/bookstore/models/Product.java`
- **Purpose**: Base interface defining common properties for all products.
- **Methods**:
  - `String getISBN()`: Returns the product's ISBN identifier.
  - `String getTitle()`: Returns the product title.
  - `double getPrice()`: Returns the product price.
  - `int getYear()`: Returns the publication year.
  - `String getAuthor()`: Returns the author name.
  - `boolean isForSale()`: Indicates if the product is available for purchase.

### 2. `Book` (Abstract Class)
- **Location**: `src/com/quantum/bookstore/models/Book.java`
- **Purpose**: Abstract base class implementing common book functionality.
- **Methods**:
  - `Book(String isbn, String title, double price, int year, String author)`: Constructor for book initialization.
  - Implements all `Product` interface methods except `isForSale()`.

### 3. `PaperBook` (Class)
- **Location**: `src/com/quantum/bookstore/models/PaperBook.java`
- **Purpose**: Represents physical books with stock management and shipping capability.
- **Methods**:
  - `PaperBook(String isbn, String title, double price, int year, String author, int stock)`: Constructor with stock initialization.
  - `boolean isForSale()`: Returns true if stock > 0.
  - `int getStock()`: Returns current stock level.
  - `void decreaseStock(int quantity)`: Reduces stock by specified amount.
  - `void increaseStock(int quantity)`: Increases stock by specified amount.

### 4. `EBook` (Class)
- **Location**: `src/com/quantum/bookstore/models/EBook.java`
- **Purpose**: Represents digital books with file type specification and email delivery.
- **Methods**:
  - `EBook(String isbn, String title, double price, int year, String author, String fileType)`: Constructor with file type.
  - `boolean isForSale()`: Always returns true (digital books are always available).
  - `String getFileType()`: Returns the file format (PDF, EPUB, etc.).

### 5. `ShowcaseBook` (Class)
- **Location**: `src/com/quantum/bookstore/models/ShowcaseBook.java`
- **Purpose**: Represents demo/showcase books that are not for sale.
- **Methods**:
  - `ShowcaseBook(String isbn, String title, double price, int year, String author)`: Constructor for showcase books.
  - `boolean isForSale()`: Always returns false (showcase books are never for sale).

### 6. `ShippingService` (Class)
- **Location**: `src/com/quantum/bookstore/services/ShippingService.java`
- **Purpose**: Handles physical book shipping operations.
- **Methods**:
  - `void ship(Product product, int quantity, CustomerAddress address)`: Processes shipping for paper books.

### 7. `MailService` (Class)
- **Location**: `src/com/quantum/bookstore/services/MailService.java`
- **Purpose**: Handles email delivery for eBooks.
- **Methods**:
  - `void sendEmail(Product product, int quantity, CustomerEmail email)`: Sends eBook to customer email.

### 8. `OrderHandlerFactory` (Class)
- **Location**: `src/com/quantum/bookstore/handlers/OrderHandlerFactory.java`
- **Purpose**: Factory for creating appropriate order handlers based on product type.
- **Methods**:
  - `static OrderHandler createHandler(Product product)`: Returns the appropriate handler for the product type.

### 9. `OrderHandler` (Abstract Class)
- **Location**: `src/com/quantum/bookstore/handlers/OrderHandler.java`
- **Purpose**: Abstract base class for order processing strategies.
- **Methods**:
  - `abstract double handleOrder(Product product, int quantity, String email, String address)`: Processes orders and returns total cost.

### 10. `PaperBookOrderHandler` (Class)
- **Location**: `src/com/quantum/bookstore/handlers/PaperBookOrderHandler.java`
- **Purpose**: Handles paper book orders with stock management and shipping.
- **Methods**:
  - `PaperBookOrderHandler(ShippingService shippingService)`: Constructor with dependency injection.
  - `double handleOrder(Product product, int quantity, String email, String address)`: Processes paper book orders.

### 11. `EBookOrderHandler` (Class)
- **Location**: `src/com/quantum/bookstore/handlers/EBookOrderHandler.java`
- **Purpose**: Handles eBook orders with email delivery.
- **Methods**:
  - `EBookOrderHandler(MailService mailService)`: Constructor with dependency injection.
  - `double handleOrder(Product product, int quantity, String email, String address)`: Processes eBook orders.

### 12. `QuantumBookstore` (Main Class)
- **Location**: `src/com/quantum/bookstore/core/QuantumBookstore.java`
- **Purpose**: Core bookstore management system.
- **Methods**:
  - `void addBook(Product book)`: Adds a book to the inventory.
  - `Product getBook(String isbn)`: Retrieves a book by ISBN.
  - `double buyBook(String isbn, int quantity, String email, String address)`: Processes book purchases.
  - `List<Product> removeOutdatedBooks(int maxAgeInYears)`: Removes and returns outdated books.
  - `int getInventoryCount()`: Returns current inventory size.

### 13. `QuantumBookstoreFullTest` (Test Class)
- **Location**: `src/com/quantum/bookstore/test/QuantumBookstoreFullTest.java`
- **Purpose**: Comprehensive test suite demonstrating all system functionality.
- **Test Cases**:
  - Adding various book types to inventory
  - Paper book purchases with stock management
  - EBook purchases with email delivery
  - Showcase book purchase attempts (should fail)
  - Non-existent book purchase attempts
  - Excessive quantity purchase attempts
  - Outdated book removal
  - Post-removal purchase operations

## How to Run
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/basmalaamamdouh/quantum-bookstore.git
   cd quantum-bookstore
   ```

2. **Compile the Code**:
   ```bash
   javac -d . src/com/quantum/bookstore/models/*.java src/com/quantum/bookstore/services/*.java src/com/quantum/bookstore/handlers/*.java src/com/quantum/bookstore/data/*.java src/com/quantum/bookstore/core/*.java src/com/quantum/bookstore/test/*.java
   ```

3. **Run the Test Suite**:
   ```bash
   java com.quantum.bookstore.test.QuantumBookstoreFullTest
   ```

## Sample Output
Below is an example of the program's output for various test scenarios:
```
=== Test 1: Adding Books to Inventory ===
Quantum book store: Added book: Data Structures and Algorithms by Robert Sedgewick (111-2-333-44444-5)
Quantum book store: Added book: Introduction to Machine Learning by Andrew Ng (222-3-444-55555-6)
Quantum book store: Added book: System Design Interview by Alex Xu (333-4-555-66666-7)
Quantum book store: Added book: Deep Learning Fundamentals by Ian Goodfellow (444-5-666-77777-8)
Quantum book store: Added book: Web Development with React by Robin Wieruch (555-6-777-88888-9)
Quantum book store: Added book: Database Systems Concepts by Abraham Silberschatz (666-7-888-99999-0)
Quantum book store: Added book: Future of Artificial Intelligence by Dr. Jane Watson (777-8-999-00000-1)
Quantum book store: Current inventory count: 7

=== Test 2: Paper Book Purchases ===
Quantum book store: Shipping 5x "Data Structures and Algorithms" to 789 Maple Drive, Denver, CO 80202
Quantum book store: Purchase successful. Total paid: $278.75
Quantum book store: Shipping 3x "System Design Interview" to 456 Cedar Lane, Seattle, WA 98101
Quantum book store: Purchase successful. Total paid: $116.85

=== Test 3: EBook Purchases ===
Quantum book store: Sending "Introduction to Machine Learning" (PDF) to student@university.edu
Quantum book store: Purchase successful. Total paid: $85.0
Quantum book store: Sending "Deep Learning Fundamentals" (EPUB) to researcher@institute.org
Quantum book store: Purchase successful. Total paid: $65.0

=== Test 4: Showcase Book Purchase Attempt ===
Quantum book store: Expected error: Quantum book store: Book Future of Artificial Intelligence is not for sale

=== Test 5: Non-existent Book Purchase Attempt ===
Quantum book store: Expected error: Quantum book store: Book with ISBN 000-0-000-00000-0 not found in inventory

=== Test 6: Excessive Quantity Purchase Attempt ===
Quantum book store: Expected error: Quantum book store: Not enough stock for System Design Interview (ISBN: 333-4-555-66666-7)

=== Test 7: Removing Outdated Books ===
Quantum book store: Removed 1 outdated books
Quantum book store: - Removed: Database Systems Concepts by Abraham Silberschatz (2018)
Quantum book store: Updated inventory count: 6
```

## Extension Guidelines
The system is designed to be easily extensible. To add a new product type:

1. **Create a new product class** extending `Book` or implementing `Product`.
2. **Implement the required methods** including `isForSale()`.
3. **Create a new order handler** extending `OrderHandler`.
4. **Update the factory** to return the new handler for your product type.
5. **Add any new services** required for the product type.


## Error Handling
The system includes comprehensive error handling for:
- Invalid product types for specific operations
- Insufficient stock for paper books
- Attempts to purchase non-saleable items
- Non-existent products
- Invalid quantity requests

## License
This project is open-source and available under the MIT License.
