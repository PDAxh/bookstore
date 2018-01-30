package com.newton.bookstore.controller;


import com.newton.bookstore.entity.Author;
import com.newton.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/api")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/authors")
    public List<Author> getAllNotes() {
        return authorRepository.findAll();
    }


    @PostMapping("/addAuthor")
    public Author createNote(@Valid @RequestBody Author author) {
        return authorRepository.save(author);
    }

    // Get a Single Note

    // Update a Note

    // Delete a Note

}
