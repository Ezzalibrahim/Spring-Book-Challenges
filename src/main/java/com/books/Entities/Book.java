package com.books.Entities;


import com.books.Enums.BookCategories;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private String image;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Category category;

    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties({"books"})
    private List<Author> authors;

    //private BookCategories category; // action & Action & ACtion

}
