package com.books.Entities;


import com.books.Enums.BookCategories;
import jakarta.persistence.*;
import lombok.*;

//@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_title" , length = 100 , unique = true )
    private String title;


    private double price;
    private BookCategories category; // action & Action & ACtion

}
