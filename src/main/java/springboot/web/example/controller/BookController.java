package springboot.web.example.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import springboot.web.example.dto.BookDto;
import springboot.web.example.dto.CreateBookRequestDto;
import springboot.web.example.dto.SearchBookParamsDto;
import springboot.web.example.service.BookService;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDto findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public BookDto save(@RequestBody CreateBookRequestDto createBookRequestDto) {
        return bookService.save(createBookRequestDto);
    }

    @PutMapping("/{id}")
    public BookDto updateBookBuId(@PathVariable Long id,
                                  @RequestBody CreateBookRequestDto createBookRequestDto) {
        return bookService.updateBookById(id, createBookRequestDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        bookService.deletedById(id);
    }

    @GetMapping("/search")
    List<BookDto> getAllByCriteria(@RequestBody SearchBookParamsDto searchBookParamsDto) {
        return bookService.findAllByCriteria(searchBookParamsDto);
    }
}
