package org.howard.edu.lsp.midterm.question2;

/**
 * Represents a book in a library.
 * This class keeps track of essential book details like title, author, ISBN, and year published.
 */
public class Book {
    private String title;         // The title of the book
    private String author;        // The author of the book
    private String ISBN;          // A unique identifier for the book
    private int yearPublished;    // The year the book was published

    /**
     * Constructor to create a new book with all necessary details.
     * 
     * @param title The book's title
     * @param author The author's name
     * @param ISBN The book's unique identifier
     * @param yearPublished The year the book was published
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

    // Getters (since the variables are private, we need these methods to access them)
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getISBN() { return ISBN; }
    public int getYearPublished() { return yearPublished; }

    /**
     * Checks if two books are equal.
     * Two books are considered equal if they have the same ISBN and author.
     *
     * @param obj The object to compare with the current book
     * @return true if the books are the same, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        // Check if the object being compared is actually a Book
        if (obj instanceof Book) {
            Book other = (Book) obj; // Cast to Book type so we can access its attributes
            return this.ISBN.equals(other.ISBN) && this.author.equals(other.author);
        }
        return false; // If obj is not a Book, they're obviously not equal
    }

    /**
     * Returns a human-readable string representation of the book.
     * This helps when printing book details.
     *
     * @return A formatted string describing the book
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Year Published: " + yearPublished;
    }
}
