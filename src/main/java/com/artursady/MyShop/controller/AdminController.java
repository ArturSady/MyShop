package com.artursady.MyShop.controller;

import com.artursady.MyShop.model.Item;
import com.artursady.MyShop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final ItemRepository itemRepository;
    @Autowired
    public AdminController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    @GetMapping

    public String adminPage(){
        return "adminview/addItem";

    }
    @PostMapping
    private String addItem(Item item){
            itemRepository.save(item);
            return "redirect:/";
    }

}
