package springboot.web.example.repository.book;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import springboot.web.example.dto.SearchBookParamsDto;

@Component
public class SearchBookDtoParser {
    public Map<String, String[]> parseSearchBookDto(SearchBookParamsDto searchBookParamsDto) {
        Map<String, String[]> mapOfDtos = new HashMap<>();
        if (searchBookParamsDto.author() != null && searchBookParamsDto.author().length > 0) {
            mapOfDtos.put("author", searchBookParamsDto.author());
        }
        if (searchBookParamsDto.title() != null && searchBookParamsDto.title().length > 0) {
            mapOfDtos.put("title", searchBookParamsDto.title());
        }
        if (searchBookParamsDto.isbn() != null && searchBookParamsDto.isbn().length > 0) {
            mapOfDtos.put("isbn", searchBookParamsDto.isbn());
        }
        return mapOfDtos;
    }
}
