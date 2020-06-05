package com.example.springapp.services;

import com.example.springapp.domain.Brand;
import com.example.springapp.repositories.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kamil on 05.06.2020.
 */
@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Set<Brand> getCars() {

        Set<Brand> brands = new HashSet<>();

        brandRepository.findAll().iterator().forEachRemaining(brands::add);

        return brands;
    }
}
