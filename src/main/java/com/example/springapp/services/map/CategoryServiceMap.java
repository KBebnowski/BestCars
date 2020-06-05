package com.example.springapp.services.map;

import com.example.springapp.domain.Category;
import com.example.springapp.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Kamil on 05.06.2020.
 */
@Service
public class CategoryServiceMap extends AbstractMapService<Category> implements CategoryService {


    @Override
    public Category save(Category object) {
        return super.save(object);
    }

    @Override
    public void delete(Category object) {
        super.delete(object);
    }

    @Override
    public Set<Category> findAll() {
        return super.findAll();
    }
}
