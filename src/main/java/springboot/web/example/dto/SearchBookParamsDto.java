package springboot.web.example.dto;

public record SearchBookParamsDto(String[] title, String[] author, String[] isbn) {
}
