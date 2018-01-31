package com.newton.bookstore.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Book")
@EntityListeners(AuditingEntityListener.class)
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookID;

    @NotBlank
    private String author;
    @NotBlank
    private String title;
    @NotBlank
    private String genre;
    @NotBlank
    private int publishedYear;
    @NotBlank
    private int rating;
    @NotBlank
    private double price;
    @NotBlank
    private int inventory;

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
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

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "BookID: " + bookID + ", Book title: " + title + ", author: " + author + ", genre: " + genre + ", published year: " + publishedYear + ", rating: " + rating + ", price: " + price + ", inventory: " + inventory;
    }
}
