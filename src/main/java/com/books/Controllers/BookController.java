package com.books.Controllers;


import com.books.Entities.Book;
import com.books.Enums.BookCategories;
import com.books.Exceptions.EntityNotFoundException;
import com.books.Services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

// / books
// routes to get the date from /books
@RestController
@RequestMapping("books")
public class BookController {


    // RequestBody => send json from the front
    // Path variable => send the param from the url
    // Request param => for sorting or filtering, for example

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping()
    public List<Book> getAll(){
        return bookService.getAll();
    }
    //

    @PostMapping()
    public void add(@RequestBody Book book){
        bookService.add(book);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id){
        bookService.delete(id);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable("id") int id){
        return bookService.getById(id);
    }

    @PutMapping("{id}")
    public void update(
        @PathVariable("id") int id,
        @RequestBody Book book
    ) throws EntityNotFoundException {
        bookService.update(id , book);
    }


    // sorted books by price*
    @GetMapping("sort")
    public List<Book> getSortedByPrice(
        @RequestParam(value = "sort" , defaultValue = "false" ) String desc
    ){
        System.out.println(desc);
        System.out.println(Boolean.getBoolean(desc));
        return bookService.sortByPrice(desc.equals("true"));
    }

    @GetMapping("filter")
    public List<Book> getFilteredByPrice(
        @RequestParam(value = "min" ) int min,
        @RequestParam(value = "max" ) int max
    ){
        return  bookService.filterByPrice(min , max);
    }


}
