package mate.academy.springbootintro.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.springbootintro.model.Book;
import mate.academy.springbootintro.repository.BookRepository;
import mate.academy.springbootintro.service.BookService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
