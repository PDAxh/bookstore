package com.newton.bookstore.service;

import com.newton.bookstore.entity.Author;
import com.newton.bookstore.entity.Book;
import com.newton.bookstore.repository.AuthorRepository;
import com.newton.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    // Save user to database
    public void saveBook(Book book){
        bookRepository.save(book);
    }

/*
    // Update a book on database
    public void updateBook(Book book){
        List<Book> books = new ArrayList<>();
        bookRepository.findOne(book.getId().getBook().forEach(book::add);
        books.setBook(books);

        bookRepository.save(book);
    }
*/

    // Get all users from database
    public List<Book> getAllUsers() {
        List<Book> books = bookRepository.findAll();

        return books;
    }

    // Get users by id from database
    public Book getAuthorById(Integer id) {
        Book book = bookRepository.findOne(id);

        return book;
    }


}
