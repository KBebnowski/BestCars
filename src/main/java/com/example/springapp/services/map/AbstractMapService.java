package com.example.springapp.services.map;

import java.util.*;

/**
 * Created by Kamil on 05.06.2020.
 */
public abstract class AbstractMapService<T> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T save(T object) {

        return object;
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

}
