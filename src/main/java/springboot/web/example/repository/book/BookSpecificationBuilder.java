package springboot.web.example.repository.book;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import springboot.web.example.dto.SearchBookParamsDto;
import springboot.web.example.model.Book;
import springboot.web.example.repository.SpecificationBuilder;

@RequiredArgsConstructor
@Component
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private final SearchBookDtoParser parser;
    private final BookSpecificationProvider specProvider;

    @Override
    public Specification<Book> getSpecification(SearchBookParamsDto searchBookParamsDto) {
        Map<String, String[]> mapOfDtos = parser.parseSearchBookDto(searchBookParamsDto);
        Specification<Book> bookSpec = Specification.not(null);
        for (Map.Entry<String, String[]> book : mapOfDtos.entrySet()) {
            String fieldName = book.getKey();
            String[] bookValue = book.getValue();
            bookSpec.and((specProvider.getSpecification(fieldName, bookValue)));
        }
        return bookSpec;
    }
}
