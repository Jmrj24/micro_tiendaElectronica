package com.example.sales.repository;

import com.example.sales.dto.ShoppingCartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "shoppingCart")
public interface IAPIShoppingCart {
    @GetMapping("/shoppingcart/get/products/{idCart}")
    public ShoppingCartDTO getCart(@PathVariable Long idCart);
}
