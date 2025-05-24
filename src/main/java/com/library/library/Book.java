package com.library.library;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {
    
    @Id
    private String id;
    private String title;
    private String author;

    // New fields
    private int copiesInStock;
    private int copiesLentOut;

    // Constructors, getters and setters

    public Book() {}

    public Book(String title, String author, int copiesInStock, int copiesLentOut) {
        this.title = title;
        this.author = author;
        this.copiesInStock = copiesInStock;
        this.copiesLentOut = copiesLentOut;
    }

    // Getters and setters for all fields including new ones

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCopiesInStock() {
        return copiesInStock;
    }

    public void setCopiesInStock(int copiesInStock) {
        this.copiesInStock = copiesInStock;
    }

    public int getCopiesLentOut() {
        return copiesLentOut;
    }

    public void setCopiesLentOut(int copiesLentOut) {
        this.copiesLentOut = copiesLentOut;
    }
}
