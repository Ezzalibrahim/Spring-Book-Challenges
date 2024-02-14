package com.books;

import com.books.Entities.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksApplication {


	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
		Book book = new Book("test" , 12);
		System.out.println(book.getTitle());
		System.out.println(book.getPrice());
		book.setPrice(53);
		book.setTitle("test 1");
		System.out.println(book);
	}


}
