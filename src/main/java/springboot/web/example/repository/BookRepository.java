package springboot.web.example.repository;

import java.util.List;
import springboot.web.example.model.Book;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();

    Book findById(Long id);
}
