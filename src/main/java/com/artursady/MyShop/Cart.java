package com.artursady.MyShop;

import com.artursady.MyShop.model.Item;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
public class Cart {

    private List<CartItem> cartItems = new ArrayList<>();
    private int counter = 0;
    private BigDecimal sum = BigDecimal.ZERO;

    public void addItem(Item item){
        getCartByItem(item).ifPresentOrElse(
                CartItem::increaseCounter,
                () -> cartItems.add(new CartItem(item))
        );
        recalculatePriceAndCounter();

    }
    public void removeItem(Item item){
        Optional <CartItem> oCartItem = getCartByItem(item);
        if(oCartItem.isPresent()){
            CartItem cartItem = oCartItem.get();
            cartItem.decreaseCounter();
            if(cartItem.hasZeroItems()){
                cartItems.removeIf(i -> i.getItem().getId().equals(item.getId()));
            }
        }
        recalculatePriceAndCounter();
    }
    private void recalculatePriceAndCounter(){
        sum = cartItems.stream().map(CartItem :: getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal :: add);
        counter = cartItems.stream().mapToInt(CartItem :: getCounter)
                .reduce(0, Integer :: sum);

    }
    private Optional<CartItem> getCartByItem(Item item){
        return cartItems.stream()
                .filter(i -> i.getItem().getId().equals(item.getId()))
                .findFirst();
    }

}
