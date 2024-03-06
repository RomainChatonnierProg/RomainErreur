package org.example.services;

import org.example.entities.Book;
import org.example.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book b){
        bookRepository.addBook(b);
    }

    public List<Book> getByName(String name){
        return bookRepository.getByName(name);
    }

}
