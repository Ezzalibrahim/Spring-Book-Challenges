package com.books;

import com.books.Entities.Book;
import com.books.Enums.BookCategories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksApplication {


	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
//		Book book = new Book(12 , "test" ,  12 ,BookCategories.Action);
//		System.out.println(book.getTitle());
//		System.out.println(book.getPrice());
//		book.setPrice(53);
//		book.setTitle("test 1");
//		System.out.println(book);

		// DTO
		// create DB in mysql
		// relations between tables
		// oneToMany => A oneToMany B =>
		// ManyToMany
		// DAO
		// exception handling
		// Jpa repo & CRUD repo
		// based paging & sorting in jpa
		//
	}


}
