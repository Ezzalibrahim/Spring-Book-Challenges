package com.books.Entities;


import com.books.Enums.BookCategories;
import lombok.*;

//@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Data


public class Book {


    private int id;
    private String title;
    private double price;
    private BookCategories category; // action & Action & ACtion


}
