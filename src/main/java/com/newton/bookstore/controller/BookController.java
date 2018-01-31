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
    @GetMapping("/books")
    public List<Book> getAllAuthors() {
        return bookRepository.findAll();
    }
    // Lägger till bok i lager,
    @PostMapping("/addBook")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }
    // Välj enskild book via id( kan även ändras till titel om så behövs
    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getAuthorById(@PathVariable(value = "id") int bookId) {
        Book book = bookRepository.findOne(bookId);
        if(book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(book);
    }

    @PutMapping("/updateAuthor/{id}")
    public ResponseEntity<Book> updateAuthor(@PathVariable(value = "id") int authorId,
                                               @Valid @RequestBody Book bookDetails) {
        Book book = bookRepository.findOne(authorId);
        if(book == null) {
            return ResponseEntity.notFound().build();
        }
        book.setTitle(bookDetails.getTitle());

        Book updatedAuthor = bookRepository.save(book);
        return ResponseEntity.ok(updatedAuthor);
    }


}

