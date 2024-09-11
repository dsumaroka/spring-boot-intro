package mate.academy.springbootintro;

import java.math.BigDecimal;
import mate.academy.springbootintro.model.Book;
import mate.academy.springbootintro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootIntroApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntroApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Book book = new Book();
            book.setTitle("java");
            book.setAuthor("Gerbert Shildt");
            book.setIsbn("1234");
            book.setPrice(BigDecimal.valueOf(100));
            bookService.save(book);
            System.out.println(bookService.findAll());
        };
    }
}
