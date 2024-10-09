package springboot.web.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.web.example.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
}
