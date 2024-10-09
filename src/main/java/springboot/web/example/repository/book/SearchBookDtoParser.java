package springboot.web.example.repository.book;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import springboot.web.example.dto.SearchBookParamsDto;

@Component
public class SearchBookDtoParser {
    public static final String AUTHOR = "author";
    public static final String TITLE = "title";
    public static final String ISBN = "isbn";

    public Map<String, String[]> parseSearchBookDto(SearchBookParamsDto searchBookParamsDto) {
        Map<String, String[]> searchDtoToMap = new HashMap<>();
        if (searchBookParamsDto.author() != null && searchBookParamsDto.author().length > 0) {
            searchDtoToMap.put(AUTHOR, searchBookParamsDto.author());
        }
        if (searchBookParamsDto.title() != null && searchBookParamsDto.title().length > 0) {
            searchDtoToMap.put(TITLE, searchBookParamsDto.title());
        }
        if (searchBookParamsDto.isbn() != null && searchBookParamsDto.isbn().length > 0) {
            searchDtoToMap.put(ISBN, searchBookParamsDto.isbn());
        }
        return searchDtoToMap;
    }
}
