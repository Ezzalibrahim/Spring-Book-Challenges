package com.books.Repositories;

import com.books.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepositoryDB extends JpaRepository<Book , Integer> {

}
