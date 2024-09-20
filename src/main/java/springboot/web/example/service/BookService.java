package springboot.web.example.service;

import java.util.List;
import springboot.web.example.model.Book;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
