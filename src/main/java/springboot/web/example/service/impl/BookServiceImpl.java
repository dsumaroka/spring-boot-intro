package springboot.web.example.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import springboot.web.example.dto.BookDto;
import springboot.web.example.dto.CreateBookRequestDto;
import springboot.web.example.dto.SearchBookParamsDto;
import springboot.web.example.exception.EntityNotFoundException;
import springboot.web.example.mapper.BookMapper;
import springboot.web.example.model.Book;
import springboot.web.example.repository.SpecificationBuilder;
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
                () -> new EntityNotFoundException("Can't find book with id: " + id));
        return bookMapper.toBookDto(book);
    }

    @Override
    public BookDto updateBookById(Long id, CreateBookRequestDto createBookRequestDto) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find book with id: " + id));
        bookMapper.updateBookFromDto(createBookRequestDto, book);
        bookRepository.save(book);
        return bookMapper.toBookDto(book);
    }

    @Override
    public void deletedById(Long id) {
        bookRepository.deleteById(id);
    }

     @Override
    public List<BookDto> findAllByCriteria(SearchBookParamsDto searchBookParamsDto) {
        Specification<Book> bookSpecification = specBuilder.getSpecification(searchBookParamsDto);
        return bookRepository.findAll(bookSpecification)
                .stream()
                .map(bookMapper::toBookDto)
                .toList();
    }
}
