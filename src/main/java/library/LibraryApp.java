package library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import library.repository.CustomerRepository;

@SpringBootApplication
public class LibraryApp {

    private final CustomerRepository customerRepository;

    @Autowired
    public LibraryApp(CustomerRepository customerRepository) { this.customerRepository = customerRepository; }

    public static void main(String[] args) {
        SpringApplication.run(LibraryApp.class, args);
    }
}
