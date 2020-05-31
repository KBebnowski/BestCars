package com.example.springapp.repositories;

import com.example.springapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Kamil on 31.05.2020.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findBycarType(String carType);
}
