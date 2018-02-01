package com.newton.bookstore.controller;

import com.newton.bookstore.entity.Book;
import com.newton.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class BookController {


    @Autowired
    BookRepository bookRepository;

    // Get All Books
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // "Buying new book to the store"
    @PostMapping("/addBook")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Find book
    @GetMapping("/locateBookById{bookID}") // ***Refering to the bookId in Bookentity

    public ResponseEntity<Book> locateBookById(@PathVariable(value = "bookID") int bookID) {
        Book locateBook = bookRepository.findOne(bookID);
        if (locateBook == null) {

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(locateBook);
    }


    // update book
    @PutMapping("/updateBook/{bookID}")

    public ResponseEntity<Book> updateBook(@PathVariable(value = "bookID") int bookID,
                                           @Valid @RequestBody Book bookDetails) {
        Book book = bookRepository.findOne(bookID);
        if (book == null) {

            return ResponseEntity.notFound().build();
        }

        book.setTitle(bookDetails.getTitle());
        book.setPublishedYear(bookDetails.getPublishedYear());
        book.setInventory(bookDetails.getInventory());
        book.setGenre(bookDetails.getGenre());
        book.setPrice(bookDetails.getPrice());

        Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);

    }

    // delete book
    @DeleteMapping("/deleteBooks/{bookID}")

    public ResponseEntity<Book> deleteBook(@PathVariable(value = "bookID") int bookID) {
        Book deleteBook = bookRepository.findOne(bookID);
        if (deleteBook == null) {

            return ResponseEntity.notFound().build();
        } else {

            bookRepository.delete(deleteBook);
        }
        return ResponseEntity.ok().build();
    }
}
