package com.books.Controllers;


import com.books.Entities.Book;
import com.books.Enums.BookCategories;
import com.books.Services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// / books
// routes to get the date from /books
@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("books")
    public List<Book> getAll(){
        return bookService.getAll();
    }
    //

    @PostMapping("books")
    public void add(@RequestBody Book book){
        bookService.add(book);
    }

    @DeleteMapping("books/{id}")
    public void delete(@PathVariable("id") int id){
        bookService.delete(id);
    }

    @GetMapping("books/{id}")
    public void getById(@PathVariable("id") int id){
        bookService.getAll();
    }

}
