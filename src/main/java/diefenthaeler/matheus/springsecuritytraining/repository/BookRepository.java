package diefenthaeler.matheus.springsecuritytraining.repository;

import diefenthaeler.matheus.springsecuritytraining.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
