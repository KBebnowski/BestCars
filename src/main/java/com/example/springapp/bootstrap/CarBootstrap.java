package com.example.springapp.bootstrap;

import com.example.springapp.domain.*;
import com.example.springapp.repositories.BrandRepository;
import com.example.springapp.repositories.CategoryRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Kamil on 03.05.2020.
 */
@Component
public class CarBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    public CarBootstrap(BrandRepository brandRepository, CategoryRepository categoryRepository) {
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        brandRepository.saveAll(getCars());
    }

    private List<Brand> getCars(){
        List<Brand> cars = new ArrayList<>();


        Optional<Category> suvCategoryOptional = categoryRepository.findBycarType("SUV");
        Optional<Category> sedanCategoryOptional = categoryRepository.findBycarType("Sedan");
        Optional<Category> coupeCategoryOptional = categoryRepository.findBycarType("Coupe");
        Optional<Category> hatchbackCategoryOptional = categoryRepository.findBycarType("Hatchback");

        if(!suvCategoryOptional.isPresent() || !sedanCategoryOptional.isPresent() || !coupeCategoryOptional.isPresent()
                || !hatchbackCategoryOptional.isPresent()){
                throw new RuntimeException("Expected Category Not Found");
            }

        Category suvCategory = suvCategoryOptional.get();
        Category sedanCategory = sedanCategoryOptional.get();
        Category coupeCategory = coupeCategoryOptional.get();
        Category hatchbackCategory = hatchbackCategoryOptional.get();

        categoryRepository.save(coupeCategory);
        categoryRepository.save(sedanCategory);
        categoryRepository.save(suvCategory);
        categoryRepository.save(hatchbackCategory);


        //tworzenie 1 marki aut coupe
        Brand mercedes = new Brand();
        mercedes.setName("Mercedes-Benz");
        mercedes.setCountry(Country.GERMANY);

        Notes notes = new Notes();
        notes.setAboutBrand("marka samochodów produkowanych przez koncern Daimler AG (uprzednio DaimlerChrysler AG, " +
                "obecnie właścicielem koncernu są w prawie 70% przedsiębiorstwa i inwestorzy poza RFN)[1], zaś " +
                "wcześniej" + " przez koncern Daimler-Benz, popularnie nazywana Mercedes. Pod marką tą produkowane są " +
                "samochody " + "osobowe," + " dostawcze, ciężarowe i autobusy. W kategorii samochodów osobowych, " +
                "Mercedes-Benz uważany jest za jedną" + " z najstarszych. - from Wikipedia");
        notes.setBrand(mercedes);
        mercedes.setNotes(notes);

        mercedes.getModels().add(new Model("C204", 2200, 170, mercedes));
        mercedes.getModels().add(new Model("C205", 1991, 211, mercedes));
        mercedes.getModels().add(new Model("C207", 2400, 250, mercedes));

        mercedes.getCategories().add(coupeCategory);

        cars.add(mercedes);

        return cars;
    }

}
