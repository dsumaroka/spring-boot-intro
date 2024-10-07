package springboot.web.example.repository.book;

import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import springboot.web.example.model.Book;

@Component
public class BookSpecificationProvider {
    Specification<Book> getSpecification(String fieldName, String[] params) {
        return (root, query, criteriaBuilder) -> root.get(fieldName).in((Arrays.stream(params).toArray()));
    }
}
