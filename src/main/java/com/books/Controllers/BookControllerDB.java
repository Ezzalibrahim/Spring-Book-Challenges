package com.books.Controllers;

import com.books.DTOs.BookDto;
import com.books.DTOs.BookDtoRequest;
import com.books.Entities.Book;
import com.books.Exceptions.EntityNotFoundException;
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


    @PutMapping("{id}")
    public void update(
        @PathVariable int id,
        @RequestBody Book book
    ) throws EntityNotFoundException {
        bookService.update(id, book);
    }

    // get by id => return Book Dto
    // www.test.com/book/id
    @GetMapping("{id}")
    public BookDto getById(@PathVariable int id){
        return bookService.getDtoById(id);
    }

    @GetMapping("/dtos")
    public List<BookDto> getAllDtos(){
        return bookService.getAllDtos();
    }


    @PostMapping("/categories/{id}/books")
    public void createByCategory(
        @PathVariable("id") int id,
        @RequestBody Book book
    ) throws EntityNotFoundException {
        bookService.createByCategory(id , book);
    }





}
