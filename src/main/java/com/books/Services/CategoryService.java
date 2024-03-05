package com.books.Services;

import com.books.Entities.Category;
import com.books.Exceptions.EntityNotFoundException;
import com.books.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

   private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    // book by category
    public Category getBooksByCategory(int categoryId) throws EntityNotFoundException {
        return categoryRepository.findById(categoryId)
            .orElseThrow(
                () -> new EntityNotFoundException("Category with id "+categoryId+" Not Found")
            );
    }


}
