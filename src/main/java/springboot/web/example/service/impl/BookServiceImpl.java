package springboot.web.example.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.web.example.dto.BookDto;
import springboot.web.example.dto.CreateBookRequestDto;
import springboot.web.example.exception.EntityNotFoundException;
import springboot.web.example.mapper.BookMapper;
import springboot.web.example.model.Book;
import springboot.web.example.repository.BookRepository;
import springboot.web.example.service.BookService;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto createBookRequestDto) {
        Book book = bookMapper.toBookEntity(createBookRequestDto);
        bookRepository.save(book);
        return bookMapper.toBookDto(book);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toBookDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find in DB book with id: " + id));
        return bookMapper.toBookDto(book);
    }

    @Override
    public BookDto update(CreateBookRequestDto createBookRequestDto) {
        Book book = bookMapper.toBookEntity(createBookRequestDto);

        return null;
    }

    @Override
    public void deletedById(Long id) {
        bookRepository.deleteById(id);
    }
}
