package library.repository;

import library.model.RentBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentBookRepository extends CrudRepository<RentBook, Long> {
}
