package com.books.Mappers;

import com.books.DTOs.BookDto;
import com.books.DTOs.BookDtoRequest;
import com.books.Entities.Book;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;

public class BookMapper {

    public static BookDto toDto(Book book){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(book , BookDto.class);
    }

    public static Book toEntity(BookDtoRequest bookDto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(bookDto, Book.class);
    }





}
