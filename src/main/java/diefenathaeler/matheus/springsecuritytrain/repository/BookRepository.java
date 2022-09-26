package diefenathaeler.matheus.springsecuritytrain.repository;

import diefenathaeler.matheus.springsecuritytrain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
