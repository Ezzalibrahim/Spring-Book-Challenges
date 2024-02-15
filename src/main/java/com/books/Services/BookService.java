package com.books.Services;

import com.books.Entities.Book;
import com.books.Repositories.BookReposInterface;
import com.books.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    // @Primary and @Qualifier("bookRepository")

    private BookReposInterface bookRepo;

    public BookService(BookReposInterface bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void delete(int idToDelete){
        bookRepo.delete(idToDelete);
    }

    public List<Book> getAll() {
        return bookRepo.getAll();
    }


    public void add(Book book){
        bookRepo.add(book);
    }

    public Book getById(int id){
        return bookRepo.getById(id);
    }


}
