package com.books.Repositories;

import com.books.Entities.Book;
import com.books.Enums.BookCategories;
import com.books.Exceptions.EntityNotFoundException;

import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookRepository implements BookReposInterface{

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
        for(int i=0 ;i< allBooks.size();i++){
            if (allBooks.get(i).getId()== idToDelete){
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
        if (index != -1){
            Book bookToUpdate = allBooks.get(index);
            bookToUpdate.setTitle(newBook.getTitle());
            bookToUpdate.setPrice(newBook.getPrice());
            bookToUpdate.setCategory(newBook.getCategory());

            // we don't need it
            bookToUpdate.setId(idToUpdate);

            allBooks.set(index , bookToUpdate);
        }else{
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

        for (int i = 0; i < allBooks.size(); i++) {
            for(int j=i+1;j<allBooks.size()-1;j++){
            if (Des) {
                if(allBooks.get(i).getPrice()<allBooks.get(j).getPrice()){
                    permitTowBooks(j, i);
                }
            }
            else{
                if(allBooks.get(i).getPrice()>allBooks.get(j).getPrice()){
                    permitTowBooks(j, i);
                }
                }

                // TODO: Methode 2

                // Des : True
                // price[i] = 2
                // price[j] = 1
                boolean isDes = Des && allBooks.get(i).getPrice() < allBooks.get(j).getPrice();
                boolean isNotDes = allBooks.get(i).getPrice() > allBooks.get(j).getPrice() && !Des;
                if (isDes || isNotDes) {
                    permitTowBooks(j, i);
                }
            }


        }



        // 9909
        // 9999
        allBooks.sort((book1, book2) -> (int) (book1.getPrice() * 100 - book2.getPrice() * 100));

        // Sort with streams
        // Methode 3
        allBooks =  allBooks.stream().sorted((book1, book2) -> (int) (book1.getPrice() * 100 - book2.getPrice() * 100)).collect(Collectors.toList());


        //Methode 4
        Collections.sort(allBooks , (book1, book2) -> (int) (book1.getPrice() * 100 - book2.getPrice() * 100));

        return allBooks;
    }

    private void permitTowBooks(int j, int i) {
        Book bookTemp;
        bookTemp = allBooks.get(j);
        allBooks.set(j, allBooks.get(i));
        allBooks.set(i, bookTemp);
    }



    @Override
    public List<Book> filterByPrice(double max , double min ) {
        return allBooks.stream()
            .filter(
                book -> book.getPrice() >= min
                        && book.getPrice() <= max
            ).collect(Collectors.toList());
    }

    int getIndexById(int id){
        for(int i=0 ;i< allBooks.size();i++){
            if (allBooks.get(i).getId()== id){
                return i;
            }
        }
        return -1;
    }

}
