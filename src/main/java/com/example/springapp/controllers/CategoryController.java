package com.example.springapp.controllers;

import com.example.springapp.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Kamil on 05.06.2020.
 */
@RequestMapping("/categories")
@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping({"","/index","/index.html"})
    public String getCategories(Model model){

        model.addAttribute("categories", categoryService.getCategories());

        return "categories/index";
    }


}
