package com.artursady.MyShop;

import com.artursady.MyShop.model.Item;
import com.artursady.MyShop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner {
    private final ItemRepository itemRepository;

    @Autowired
    public DbInit(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        itemRepository.saveAll(List.of(
               new Item("Ołówek", new BigDecimal("1.50"), "https://dlabiura24.pl/i/cms/000484.jpg"),
                new Item("Długopis", new BigDecimal("2.10"), "https://ebiurowe.net/environment/cache/images/900_900_productGfx_29494/8ec091acb44978de25d21ba751fda65e.jpg"),
                new Item("Pióro", new BigDecimal("9.50"), "https://www.luxuryproducts.pl/file/image/w800/h800/fit233568i0ad9c8dd139477229b600056c28249f47201526.jpg")));

    }
}
