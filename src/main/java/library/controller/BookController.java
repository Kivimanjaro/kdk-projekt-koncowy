package library.controller;

import library.model.Book;
import library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        System.out.println("Getting all books...");
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @GetMapping(value = "books/title/{title}")
    public List<Book> findByTitle(@PathVariable String title) {
        System.out.println("getting book with title: " + title);

        List<Book> books = bookRepository.findByTitle(title);
        return books;

    }

    @PostMapping("/books/create")
    public Book postBook(@RequestBody Book book){

        Book _book = bookRepository.save(new Book(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher()));
        return book;
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") long id) {
        System.out.println("Delete Book with ID = " + id + "...");

        bookRepository.deleteById(id);

        return new ResponseEntity<>("Book has been deleted!", HttpStatus.OK);
    }
}
