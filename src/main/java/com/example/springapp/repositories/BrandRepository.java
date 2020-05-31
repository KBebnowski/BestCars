package com.example.springapp.repositories;

import com.example.springapp.domain.Brand;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Kamil on 31.05.2020.
 */
public interface BrandRepository extends CrudRepository<Brand, Long> {
}
