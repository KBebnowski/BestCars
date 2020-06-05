package com.example.springapp.services.map;

import com.example.springapp.domain.Brand;
import com.example.springapp.services.BrandService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Kamil on 05.06.2020.
 */
@Service
public class BrandServiceMap extends AbstractMapService<Brand> implements BrandService {

    @Override
    public Brand save(Brand object) {
        return super.save(object);
    }

    @Override
    public void delete(Brand object) {
        super.delete(object);
    }

    @Override
    public Set<Brand> findAll() {
        return super.findAll();
    }
}
