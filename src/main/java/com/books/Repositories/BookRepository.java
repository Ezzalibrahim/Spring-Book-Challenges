package com.books.Repositories;

import com.books.Entities.Book;
import com.books.Enums.BookCategories;
import com.books.Exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.nio.file.FileSystemNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@Primary
public class BookRepository implements BookReposInterface {

    List<Book> allBooks = new ArrayList<>();

    @Override
    public void add(Book book) {
        allBooks.add(book);
    }

    @Override
    public void delete(int idToDelete) {
        // Book => id
        // index
        // delete

        // Methode 1
        for (int i = 0; i < allBooks.size(); i++) {
            if (allBooks.get(i).getId() == idToDelete) {
                allBooks.remove(i);
                break;
            }
        }
        // Methode 2
        allBooks.removeIf(book -> book.getId() == idToDelete);

    }

    @Override
    public void update(int idToUpdate, Book newBook) throws EntityNotFoundException {
        int index = getIndexById(idToUpdate);
        if (index != -1) {
            Book bookToUpdate = allBooks.get(index);

            if (newBook.getTitle() != null
                    //&& !newBook.getTitle().isEmpty() // "  " => true
                    && !newBook.getTitle().trim().isEmpty() // "  ".trim().
            ) {
                bookToUpdate.setTitle(newBook.getTitle().trim());
            }
            if (newBook.getPrice() > 0) {
                bookToUpdate.setPrice(newBook.getPrice());
            }

            if (newBook.getCategory() != null) {
                bookToUpdate.setCategory(newBook.getCategory());
            }

            // we don't need it
            // bookToUpdate.setId(idToUpdate);

            allBooks.set(index, bookToUpdate);
        } else {
            throw new EntityNotFoundException("Book not Found");
        }
    }

    @Override
    public List<Book> getAll() {
        return allBooks;
    }

    @Override
    public List<Book> search(String title) {
        Stream<Book> bookStream = allBooks.stream()
                .filter(
                        book -> book.getTitle().equals(title)
                );
        return bookStream.collect(Collectors.toList());
    }

    @Override
    public void displayAll() {
        //TODO: Methode 1 & Methode 2 are the same

        // Methode 1
        allBooks.forEach(book -> System.out.println(book));

        // Methode 2
        allBooks.forEach(System.out::println);

        // Methode 3
        System.out.println(allBooks);
    }

    @Override
    public List<Book> getByCategory(BookCategories category) {
        Stream<Book> bookStream = allBooks.stream()
                .filter(
                        book -> book.getCategory().equals(category)
                );
        return bookStream.collect(Collectors.toList());
    }

    @Override
    public List<Book> sortByPrice(boolean Des) {

        // Methode 1

        for (int i = 0; i < allBooks.size() - 1; i++) {
            for (int j = i + 1; j < allBooks.size(); j++) {
                if (Des) {
                    if (allBooks.get(i).getPrice() < allBooks.get(j).getPrice()) {
                        permitTowBooks(j, i);
                    }
                } else {
                    if (allBooks.get(i).getPrice() > allBooks.get(j).getPrice()) {
                        permitTowBooks(j, i);
                    }
                }

                // TODO: Methode 2

                // Des : True
                // price[i] = 2
                // price[j] = 1
//                boolean isDes = Des && allBooks.get(i).getPrice() < allBooks.get(j).getPrice();
//                boolean isNotDes = allBooks.get(i).getPrice() > allBooks.get(j).getPrice() && !Des;
//                if (isDes || isNotDes) {
//                    permitTowBooks(j, i);
//                }
            }


        }


        // 9909
        // 9999
//        allBooks.sort((book1, book2) -> (int) (book1.getPrice() * 100 - book2.getPrice() * 100));
//
//        // Sort with streams
//        // Methode 3
//        allBooks =  allBooks.stream().sorted((book1, book2) -> (int) (book1.getPrice() * 100 - book2.getPrice() * 100)).collect(Collectors.toList());
//
//
//        //Methode 4
//        Collections.sort(allBooks , (book1, book2) -> (int) (book1.getPrice() * 100 - book2.getPrice() * 100));

        return allBooks;
    }

    private void permitTowBooks(int j, int i) {
        Book bookTemp;
        bookTemp = allBooks.get(j);
        allBooks.set(j, allBooks.get(i));
        allBooks.set(i, bookTemp);
    }


    @Override
    public List<Book> filterByPrice(double min, double max) {
        return allBooks.stream()
                .filter(
                        book -> book.getPrice() >= min
                                && book.getPrice() <= max
                ).collect(Collectors.toList());
    }

    @Override
    public Book getById(int id) throws EntityNotFoundException {
        Stream<Book> bookStream = allBooks.stream().filter(book -> book.getId() == id);
        Optional<Book> findedBook = bookStream.findFirst();
        if (findedBook.isPresent()) {
            return findedBook.get();
        }

        throw new EntityNotFoundException("Book with id " + id + " not found");

    }

    int getIndexById(int id) {
        for (int i = 0; i < allBooks.size(); i++) {
            if (allBooks.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

}
