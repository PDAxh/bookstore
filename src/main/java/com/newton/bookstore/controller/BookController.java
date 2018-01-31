package com.newton.bookstore.controller;



public class BookController {
}
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

    private String locateBook;

    @Autowired
    BookRepository bookRepository;

    // Get All Books

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // "Buying new book to the store"

    @PostMapping("/books")
    public Book buyBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Find book

    @GetMapping("/books/{bookID}") // ***Refering to the bookId in Bookentity

    public ResponseEntity<Book> locateBook(@PathVariable(value = "bookID") int bookID) {
        Book locateBook = bookRepository.findOne(bookID);
        if (locateBook == null) {

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(locateBook);
    }


    // update book

    /* BYT UT bookDetails till rätt metod!

    @GetMapping("/books/{bookID}")

    public ResponseEntity<Book> updateBook(@PathVariable(value = "bookID") int bookID) {
        Book book = bookRepository.findOne(bookID);
        if (locateBook == null) {

            return ResponseEntity.notFound().build();
        }

        book.setTitle(bookDetails.getTitle());
        book.setPublishedYear(bookDetails.getPublishedYear());
        book.setInventory(bookDetails.getInventory());
        book.setGenre(bookDetails.getGenre());
        book.setPrice(bookDetails.setPrice());

        Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);

        */

    // delete book

    @DeleteMapping("/books/{bookID}")

    public ResponseEntity<Book> deleteBook(@PathVariable(value = "bookID") int bookID) {
        Book deleteBook = bookRepository.findOne(bookID);
        if (deleteBook == null) {

            return ResponseEntity.notFound().build();
        }

        bookRepository.delete(deleteBook);

        return ResponseEntity.ok().build();
    }
}