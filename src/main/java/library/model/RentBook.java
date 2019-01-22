package library.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rent_book")
public class RentBook {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "rent_date")
    private LocalDateTime rentDate;

    @Column(name = "expected_return_date")
    private LocalDateTime expectedReturnDate;

    @JoinColumn(name = "book_id")
    @OneToOne
    private Book book;

    @JoinColumn(name = "customer_id")
    @OneToOne
    private Customer customer;

    public RentBook() {
    }


    public RentBook(Book book, Customer customer) {
        this.rentDate = LocalDateTime.now();
        this.expectedReturnDate = LocalDateTime.now().plusDays(7);
        this.book = book;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getRentDate() {
        return rentDate;
    }

    public LocalDateTime getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setRentDate(LocalDateTime rentDate) {
        this.rentDate = rentDate;
    }

    public void setExpectedReturnDate(LocalDateTime expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @Override
    public String toString() {
        return "RentBook{" +
                "id=" + id +
                ", rentDate=" + rentDate +
                ", expectedReturnDate=" + expectedReturnDate +
                ", book=" + book +
                ", customer=" + customer +
                '}';
    }
}
