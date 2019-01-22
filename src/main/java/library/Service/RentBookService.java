package library.Service;

import library.model.Book;
import library.model.Customer;
import library.repository.BookRepository;
import library.repository.CustomerRepository;
import library.repository.RentBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentBookService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    RentBookRepository rentBookRepository;

    public Customer transferCustomer(long customerId){
        Customer customer = customerRepository.findById(customerId).get();
        System.out.println("customer id: " + customerId );
        return customer;
    }

    public Book transferBook(long bookId){
        System.out.println("book id: " + bookId);
        Book book = bookRepository.findById(bookId).get();
        book.setRented(true);
        return book;
    }

    public boolean checkBookAvailability(long bookId){
        Book book = bookRepository.findById(bookId).get();
        if(book.isRented() == true) {
            return false;
        } else {
            book.setRented(true);
            return true;
        }
    }

}
