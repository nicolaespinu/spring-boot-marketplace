package com.spinic.market.controller;

import com.spinic.market.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ProductRepository productRepository;

    @GetMapping("/market/main")
    public String listAllProductsFromDB(Authentication a, Model model) {
        String name = a == null ? "My friend" : a.getName();
        model.addAttribute("username", name);
        model.addAttribute("products", productRepository.findAll());
        return "main.html";
    }

}
