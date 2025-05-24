package com.library.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
    List<Book> books = bookRepository.findAll();
    System.out.println("Books from DB: " + books);  // <-- Debug print
    return books;
}


    // Update a book by id
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if(optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setCopiesInStock(updatedBook.getCopiesInStock());
            book.setCopiesLentOut(updatedBook.getCopiesLentOut());
            return bookRepository.save(book);
        } else {
            throw new RuntimeException("Book not found with id " + id);
        }
    }

    // Delete a book by id
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable String id) {
        if(bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return "Book deleted successfully.";
        } else {
            return "Book not found.";
        }
    }
}
