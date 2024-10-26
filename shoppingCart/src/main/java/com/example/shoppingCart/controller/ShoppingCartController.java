package com.example.shoppingCart.controller;

import com.example.shoppingCart.dto.ProductDTO;
import com.example.shoppingCart.dto.ShoppingCartDTO;
import com.example.shoppingCart.model.ShoppingCart;
import com.example.shoppingCart.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
    @Autowired
    private IShoppingCartService cartServ;

    // EndPoint para crear carritos de compras
    @PostMapping("/create")
    public String saveShoppingCart(@RequestBody List<Long> listProducts) {
        return cartServ.saveShoppingCart(listProducts);
    }

    // EndPoint para listar todos los carritos de compras
    @GetMapping("/get")
    public List<ShoppingCart> getAllShoppingCarts() {
        return cartServ.getAllShoppingCarts();
    }

    // EndPoint para eliminar un carrito de compras
    @DeleteMapping("/delete/{id}")
    public String deleteShoppingCart(@PathVariable Long id) {
        cartServ.deleteShoppingCart(id);
        return "Carrito de compras eliminado exitosamente!";
    }

    // EndPoint para editar un carrito de compras
    @PutMapping("/edit/{code}")
    public String editShoppingCart(@RequestBody List<Long> listProducts,
                                            @PathVariable Long code) {
        return cartServ.editShoppingCart(listProducts, code);
    }

    // EndPoint para traer un carrito y sus productos
    @GetMapping("/get/products/{idCart}")
    public ShoppingCartDTO getProductsCart(@PathVariable Long idCart) {
        return cartServ.getProductCart(idCart);
    }
}
