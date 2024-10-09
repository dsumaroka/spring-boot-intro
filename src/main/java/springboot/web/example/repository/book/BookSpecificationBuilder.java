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
        Map<String, String[]> searchDtoToMap = parser.parseSearchBookDto(searchBookParamsDto);
        Specification<Book> bookSpec = null;
        for (Map.Entry<String, String[]> book : searchDtoToMap.entrySet()) {
            String fieldName = book.getKey();
            String[] bookValue = book.getValue();
            Specification<Book> subBookSpec = (specProvider.getSpecification(fieldName, bookValue));
            bookSpec = bookSpec == null ? subBookSpec : bookSpec.and(subBookSpec);
        }
        return bookSpec;
    }
}
