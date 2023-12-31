package com.artursady.MyShop.controller;


import com.artursady.MyShop.Cart;
import com.artursady.MyShop.model.Item;
import com.artursady.MyShop.repository.ItemRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    private final ItemRepository itemRepository;
    private final Cart cart;

    @Autowired
    public HomeController(ItemRepository itemRepository, Cart cart) {
        this.itemRepository = itemRepository;
        this.cart = cart;
    }

    @GetMapping("/")
    public String home(Model model, HttpSession httpSession) {

        model.addAttribute("items", itemRepository.findAll());
        return "home";

    }

    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable("itemId") Long itemId, Model model) {

        Optional<Item> oItem = itemRepository.findById(itemId);
        if (oItem.isPresent()) {
            Item item = oItem.get();
            cart.addItem(item);
        }

        model.addAttribute("items", itemRepository.findAll());
        return "home";
    }

}
