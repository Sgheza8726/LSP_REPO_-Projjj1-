package org.howard.edu.lsp.midterm.question2;

/**
 * This class is used to test the Book class.
 * It creates a few book objects and checks if they are equal.
 */
public class BookDriver {
    public static void main(String[] args) {
        // Creating book objects
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book3 = new Book("A Promised Land", "Barack Obama", "9780593239681", 2020);

        // Checking if two books are considered equal (based on ISBN and author)
        System.out.println(book1.equals(book2)); // true (same ISBN and author)
        System.out.println(book1.equals(book3)); // false (different book)

        // Printing book details using the toString() method
        System.out.println(book1); // Expected output: Title: The Great Gatsby, Author: F. Scott Fitzgerald, ISBN: 123456789, Year Published: 1925
    }
}
