package com.example.springapp.controllers;

import com.example.springapp.services.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Kamil on 05.06.2020.
 */
@RequestMapping("/brands")
@Controller
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @RequestMapping({"","index","index.html"})
    public String getControllers(Model model){

        model.addAttribute("brands", brandService.getCars());

        return "brands/index";
    }
}
