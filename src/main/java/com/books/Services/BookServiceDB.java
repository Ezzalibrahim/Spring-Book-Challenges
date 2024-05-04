package com.books.Services;

import com.books.DTOs.BookDto;
import com.books.DTOs.BookDtoRequest;
import com.books.Entities.Book;
import com.books.Entities.Category;
import com.books.Exceptions.EntityNotFoundException;
import com.books.Mappers.BookMapper;
import com.books.Repositories.BookRepositoryDB;
import com.books.Repositories.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceDB {

    private final BookRepositoryDB bookRepository;
    private final CategoryRepository categoryRepository ;
    private final CloudinaryService cloudinaryService;
    public BookServiceDB(BookRepositoryDB bookRepository, CategoryRepository categoryRepository, CloudinaryService cloudinaryService) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.cloudinaryService = cloudinaryService;
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public void add(BookDtoRequest book) {

        String imageUrl = cloudinaryService.uploadFile(book.getImage(), "folder_1");
        ResponseEntity.ok().body(Map.of("url", imageUrl));

        Book book1 = BookMapper.toEntity(book);
        book1.setImage(imageUrl);
        bookRepository.save(book1);
    }

    public void update(int id, Book book) throws EntityNotFoundException {
        book.setId(id);
        //bookRepository.save(book);

        Optional<Book> book2 = bookRepository.findById(id);

        if(book2.isPresent()){
            Book book1 = book2.get();
            // check if the inputs are valid
            book1.setPrice(book.getPrice());
            book1.setTitle(book.getTitle());
            book1.setCategory(book.getCategory());
            bookRepository.save(book1);
        }else {
            throw new EntityNotFoundException("book not found");
        }



        // bookRepository.
    }

    public BookDto getDtoById(int id) {
        Book book = bookRepository.findById(id).get();

        return BookMapper.toDto(book);
    }

    public List<BookDto> getAllDtos() {
        List<Book> books =  bookRepository.findAll();
        //List<BookDto> booksDtos = new ArrayList<>();

        return books.stream()
                .map(BookMapper::toDto)
                .collect(Collectors.toList());

        //return booksDtos;
    }

    public void createByCategory(int idCategory, Book book) throws EntityNotFoundException {
        Optional<Category> optionalCategory = categoryRepository.findById(idCategory);
        if(optionalCategory.isPresent()){
            //Book book1 = BookMapper.toEntity(book);
            book.setCategory(optionalCategory.get());
            bookRepository.save(book);
        }else {
            throw new EntityNotFoundException("category with id " + idCategory + " Not Found");
        }
    }
}
