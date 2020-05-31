package com.example.springapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kamil on 03.05.2020.
 */
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Country country;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
    private Set<Model> models = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "brand_category",
            joinColumns = @JoinColumn(name = "brand_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;


    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
