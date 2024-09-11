package mate.academy.springbootintro.service.impl;

import java.util.List;
import mate.academy.springbootintro.model.Book;
import mate.academy.springbootintro.repository.BookRepository;
import mate.academy.springbootintro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
