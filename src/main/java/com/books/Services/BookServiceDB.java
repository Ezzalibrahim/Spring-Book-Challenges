package com.books.Services;

import com.books.Entities.Book;
import com.books.Repositories.BookRepositoryDB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceDB {

    private final BookRepositoryDB bookRepository;

    public BookServiceDB(BookRepositoryDB bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public void add(Book book) {
        bookRepository.save(book);
    }
}
