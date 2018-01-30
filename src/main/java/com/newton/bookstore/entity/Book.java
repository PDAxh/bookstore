package com.newton.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int bookID;
    private String author;
    private String title;
    private String genre;
    private int publishedYear;
    private int rating;
    private double price;
    private int inventory;

    public Book(String author, String title, String genre, int publishedYear, int rating, double price, int inventory) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publishedYear = publishedYear;
        this.rating = rating;
        this.price = price;
        this.inventory = inventory;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "BookID: " + bookID + ", Book title: " + title + ", author: " + author + ", genre: " + genre + ", published year: " + publishedYear + ", rating: " + rating + ", price: " + price + ", inventory: " + inventory;
    }
}
