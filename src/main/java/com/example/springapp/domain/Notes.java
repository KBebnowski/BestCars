package com.example.springapp.domain;

import javax.persistence.*;

/**
 * Created by Kamil on 03.05.2020.
 */
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String aboutBrand;

    @OneToOne
    private Brand brand;

    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAboutBrand() {
        return aboutBrand;
    }

    public void setAboutBrand(String aboutBrand) {
        this.aboutBrand = aboutBrand;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
