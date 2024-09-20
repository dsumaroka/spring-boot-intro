package springboot.web.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import springboot.web.model.Book;
import springboot.web.repository.BookRepository;
import springboot.web.service.BookService;
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
