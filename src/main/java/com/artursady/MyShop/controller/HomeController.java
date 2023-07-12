package com.artursady.MyShop.controller;


import com.artursady.MyShop.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class HomeController {
    private List<Item> items = List.of(new Item("Ołówek", new BigDecimal("1.50"), "https://dlabiura24.pl/i/cms/000484.jpg"),
            new Item("Długopis", new BigDecimal("2.10"), "https://ebiurowe.net/environment/cache/images/900_900_productGfx_29494/8ec091acb44978de25d21ba751fda65e.jpg"),
            new Item("Pióro", new BigDecimal("9.50"), "https://www.luxuryproducts.pl/file/image/w800/h800/fit233568i0ad9c8dd139477229b600056c28249f47201526.jpg"));

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", items);
        return "home";

    }

}
