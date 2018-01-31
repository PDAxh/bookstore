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

    //Hämtar lista på alla befintliga böcker
    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    // Lägger till bok i lager,
    @PostMapping("/addBook")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }
    // Välj enskild book via id( kan även ändras till titel om så behövs
    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBooksById(@PathVariable(value = "id") int bookId) {
        Book book = bookRepository.findOne(bookId);
        if(book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(book);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") int bookId,
                                               @Valid @RequestBody Book bookDetails) {
        Book book = bookRepository.findOne(bookId);
        if(book == null) {
            return ResponseEntity.notFound().build();
        }
        book.setTitle(bookDetails.getTitle());

        Book updatedAuthor = bookRepository.save(book);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable(value = "id") int bookId) {
        Book book = bookRepository.findOne(bookId);
        if(book == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            bookRepository.delete(book);
        }
        return ResponseEntity.ok().build();
    }


}

