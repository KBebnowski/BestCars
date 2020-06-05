package com.example.springapp.services;

import com.example.springapp.domain.Category;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Kamil on 05.06.2020.
 */

public interface CategoryService{

    Set<Category> getCategories();
}
