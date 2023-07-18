package com.artursady.MyShop.repository;

import com.artursady.MyShop.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
