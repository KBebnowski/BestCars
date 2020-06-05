package com.example.springapp.services;

import com.example.springapp.domain.Category;
import com.example.springapp.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kamil on 05.06.2020.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getCategories() {

        Set<Category> categories = new HashSet<>();

        categoryRepository.findAll().iterator().forEachRemaining(categories::add);

        return categories;
    }
}
