package com.books.Services;

import com.books.Entities.Book;
import com.books.Exceptions.EntityNotFoundException;
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
        try {
            return bookRepo.getById(id);
        }catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    public void update(int id, Book book) throws EntityNotFoundException {
        bookRepo.update(id , book);
    }

    public List<Book> sortByPrice(boolean des) {
        System.out.println("service " + des);
        return bookRepo.sortByPrice(des);
    }

    public List<Book> filterByPrice(int min, int max) {
        return bookRepo.filterByPrice(min,max);
    }
}
