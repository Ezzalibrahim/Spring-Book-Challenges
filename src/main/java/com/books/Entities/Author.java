package com.books.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @Table
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
//    @JoinTable(
//        name = "authors_books",
//        joinColumns = @JoinColumn(name = "author_id"),
//        inverseJoinColumns = @JoinColumn(name = "book_id")
//    )
    private List<Book> books;
}
