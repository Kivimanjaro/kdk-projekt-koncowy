package library.controller;

import library.DTO.RentBookDTO;
import library.Service.RentBookService;
import library.model.Book;
import library.model.Customer;
import library.model.RentBook;
import library.repository.RentBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class RentBookController {

    @Autowired
    RentBookService rentBookService;

    @Autowired
    RentBookRepository rentBookRepository;

    @GetMapping("/rentedBooks")
    public List<RentBook> getAllBooks() {
        System.out.println("Getting all rented books...");
        List<RentBook> rentedBooks = new ArrayList<>();
        rentBookRepository.findAll().forEach(rentedBooks::add);
        return rentedBooks;
    }

    @GetMapping(value = "rentedBooks/id/{id}")
    public List<RentBook> findByTitle(@PathVariable Long id) {
        System.out.println("getting rented book with id: " + id);
        List<RentBook> rentedBooks = new ArrayList<RentBook>();
        rentedBooks.add(rentBookRepository.findById(id).get());
        return rentedBooks;

    }

    @PostMapping("/rentedBooks/rent")
    public RentBookDTO rentedBook(@RequestBody RentBookDTO rentBookDTO){
        System.out.println("Request to rent a book...");
        Book book = rentBookService.transferBook(rentBookDTO.getMyBookId());
        Customer customer = rentBookService.transferCustomer(rentBookDTO.getMyCustomerId());
        boolean bookIsAvailable = rentBookService.checkBookAvailability(rentBookDTO.getMyBookId());
        if(bookIsAvailable == true){
            System.out.println();
            RentBook _rentedBook = rentBookRepository.save(new RentBook(book, customer));
            System.out.println("Book rented successfuly");
            return rentBookDTO;
        }
        else {
            System.out.println("Book is not available! ");
            return rentBookDTO;
        }

    }
}
