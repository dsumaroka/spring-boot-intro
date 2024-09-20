package springboot.web.service;

import java.util.List;
import springboot.web.model.Book;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
