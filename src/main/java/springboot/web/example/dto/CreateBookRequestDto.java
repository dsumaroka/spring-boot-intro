package springboot.web.example.dto;

import java.math.BigDecimal;

public class CreateBookRequestDto {
    private String title;
    private String author;
    private String isbn;
    private BigDecimal price;
    private String description;
    private String coverImage;
}
