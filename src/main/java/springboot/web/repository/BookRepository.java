package springboot.web.repository;

import java.util.List;
import springboot.web.model.Book;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}
