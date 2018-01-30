package com.newton.bookstore.controller;


import com.newton.bookstore.entity.Author;
import com.newton.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }


    @PostMapping("/addAuthor")
    public Author createAuthor(@Valid @RequestBody Author author) {
        return authorRepository.save(author);
    }

   @GetMapping("/notes/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable(value = "id") Long authorId) {
        Author author = authorRepository.findOne(String.valueOf(authorId));
        if(author == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(author);
    }

    // Update a Note

    // Delete a Note
    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable(value = "id") Long authorId) {
        Author author = authorRepository.findOne(String.valueOf(authorId));
        if(author == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            authorRepository.delete(author);
        }
        return ResponseEntity.ok().build();
    }

}
