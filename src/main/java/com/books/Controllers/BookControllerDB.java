package com.books.Controllers;

import com.books.Entities.Book;
import com.books.Services.BookServiceDB;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookControllerDB {

    private final BookServiceDB bookService;

    public BookControllerDB(BookServiceDB bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAll(){
        return bookService.getAll();
    }

    @PostMapping()
    public void add(@RequestBody Book book){
        bookService.add(book);
    }


}
