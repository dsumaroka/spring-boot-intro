package springboot.web.example.repository;

import java.util.List;

import java.util.Optional;
import springboot.web.example.model.Book;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();

    Optional<Book> findById(Long id);
}
