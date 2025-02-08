package at.developer.springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "at.developer.springbootproject.entity")
public class QuizApp {
    public static void main(String[] args) {
        SpringApplication.run(QuizApp.class, args);
    }
}
