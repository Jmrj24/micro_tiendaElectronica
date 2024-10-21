package com.example.shoppingCart.repository;

import com.example.shoppingCart.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "products")
public interface IAPIProducts {
    @GetMapping("/products/get")
    public List<ProductDTO> getAllProducts();
}
