package com.newton.bookstore.repository;

import java.util.List;

import com.newton.bookstore.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    // List<Author> findByLastName(String lastName);
}