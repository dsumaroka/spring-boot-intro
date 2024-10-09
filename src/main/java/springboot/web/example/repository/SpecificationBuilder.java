package springboot.web.example.repository;

import org.springframework.data.jpa.domain.Specification;
import springboot.web.example.dto.SearchBookParamsDto;

public interface SpecificationBuilder<T> {
    Specification<T> getSpecification(SearchBookParamsDto searchBookParamsDto);
}
