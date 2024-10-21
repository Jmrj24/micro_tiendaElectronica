package com.example.shoppingCart.service;

import com.example.shoppingCart.dto.ProductDTO;
import com.example.shoppingCart.dto.ShoppingCartDTO;
import com.example.shoppingCart.model.ShoppingCart;

import java.util.List;

public interface IShoppingCartService {
    // Metodo para crear carritos de compras
    public String saveShoppingCart(List<Long> listProducts);

    // Metodo para listar todos los carritos de compras
    public List<ShoppingCart> getAllShoppingCarts();

    // Metodo para obtener un carritos de compras por su id
    public ShoppingCart getShoppingCartById(Long id);

    // Metodo para eliminar un carritos de compras
    public void deleteShoppingCart(Long id);

    // Metodo para editar un carritos de compras
    public String editShoppingCart(List<Long> listProducts, Long code);

    // Metodo para traer un carrito y sus productos
    public ShoppingCartDTO getProductCart(Long idCart);
}
