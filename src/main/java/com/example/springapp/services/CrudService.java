package com.example.springapp.services;

import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Kamil on 05.06.2020.
 */

public interface CrudService <T> {

    Set<T> findAll();

    T save(T object);

  void delete(T object);
}
