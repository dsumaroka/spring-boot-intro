package springboot.web.example.service;

import java.util.List;
import springboot.web.example.dto.BookDto;
import springboot.web.example.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto createBookRequestDto);

    List<BookDto> findAll();

    BookDto findById(Long id);

    BookDto updateBookById(Long id, CreateBookRequestDto createBookRequestDto);

    void deletedById(Long id);
}
