package com.books.Controllers;


import com.books.Entities.Category;
import com.books.Exceptions.EntityNotFoundException;
import com.books.Services.CategoryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") int categoryId) throws EntityNotFoundException {
        return categoryService.getBooksByCategory(categoryId);
    }

}
