package com.books.Repositories;

import com.books.Entities.Book;
import com.books.Enums.BookCategories;
import com.books.Exceptions.EntityNotFoundException;

import java.util.List;

public interface BookReposInterface {

    void add(Book book);
    void delete(int idToDelete);
    void update(int idToUpdate , Book newBook) throws EntityNotFoundException;
    List<Book> getAll();
    List<Book> search(String title);
    void displayAll();
    List<Book> getByCategory(BookCategories category);

    List<Book> sortByPrice(boolean Des);
    List<Book> filterByPrice(double min ,double max);

    Book getById(int id) throws EntityNotFoundException;
}
