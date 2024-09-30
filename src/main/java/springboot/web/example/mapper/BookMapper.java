package springboot.web.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import springboot.web.example.config.MapperConfig;
import springboot.web.example.dto.BookDto;
import springboot.web.example.dto.CreateBookRequestDto;
import springboot.web.example.model.Book;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    Book toBookEntity(CreateBookRequestDto createBookRequestDto);

    BookDto toBookDto(Book book);

    void updateBookFromDto(CreateBookRequestDto createBookRequestDto, @MappingTarget Book book);
}
