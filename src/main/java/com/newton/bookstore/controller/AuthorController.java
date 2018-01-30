package com.newton.bookstore.controller;


import com.newton.bookstore.entity.Author;
import com.newton.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Scanner;

@RestController
@RequestMapping("/api")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    // Get All Notes

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser (@RequestParam String name) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Author author = new Author();
        author.setName(name);
        authorRepository.save(author);
        return "Saved";

    // Get a Single Note

    // Update a Note

    // Delete a Note

    }
}
