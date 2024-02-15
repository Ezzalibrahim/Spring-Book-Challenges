package com.books.Repositories;

import com.books.Entities.Book;
import com.books.Enums.BookCategories;
import com.books.Exceptions.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepoForTest implements BookReposInterface{
    @Override
    public void add(Book book) {

    }

    @Override
    public void delete(int idToDelete) {

    }

    @Override
    public void update(int idToUpdate, Book newBook) throws EntityNotFoundException {

    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public List<Book> search(String title) {
        return null;
    }

    @Override
    public void displayAll() {

    }

    @Override
    public List<Book> getByCategory(BookCategories category) {
        return null;
    }

    @Override
    public List<Book> sortByPrice(boolean Des) {
        return null;
    }

    @Override
    public List<Book> filterByPrice(double min, double max) {
        return null;
    }

    @Override
    public Book getById(int id) {
        return null;
    }
}
