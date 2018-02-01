package com.newton.bookstore.service;


import com.newton.bookstore.entity.Author;
import com.newton.bookstore.repository.AuthorRepository;
import com.newton.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    // Save author to database
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    // Update author on database
    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    // Get all authors from database
    public List<Author> getAllAuthors() {
        List<Author> author = authorRepository.findAll();

        return author;
    }

    // Get author by id from database
    public Author getAuthorById(Integer id) {
        Author author = authorRepository.findOne(id);

        return author;
    }
}