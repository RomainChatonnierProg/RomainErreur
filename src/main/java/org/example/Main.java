package org.example;

import org.example.entities.Book;
import org.example.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    public BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var book = new Book();
        book.setId(1);
        book.setName("Test");
        bookService.addBook(book);
        var book2 = new Book();
        book2.setId(2);
        book2.setName("Test2");
        bookService.addBook(book2);

        var result = bookService.getByName("Test");

    }
}