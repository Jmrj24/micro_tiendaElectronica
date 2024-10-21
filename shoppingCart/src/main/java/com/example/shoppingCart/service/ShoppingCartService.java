package com.example.shoppingCart.service;

import com.example.shoppingCart.dto.ProductDTO;
import com.example.shoppingCart.dto.ShoppingCartDTO;
import com.example.shoppingCart.model.ShoppingCart;
import com.example.shoppingCart.repository.IAPIProducts;
import com.example.shoppingCart.repository.IShoppingCartRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService implements IShoppingCartService {
    @Autowired
    private IShoppingCartRepository cartRepo;

    @Autowired
    private IAPIProducts apiProducts;

    // Metodo para crear carritos de compras
    @Override
    @CircuitBreaker(name = "products", fallbackMethod = "fallbackMethodSaveShoppingCart")
    @Retry(name = "products")
    public String saveShoppingCart(List<Long> listProducts) {
        List<ProductDTO> listProductsBD = apiProducts.getAllProducts();
        Double totalPrice = 0.0;

        for(Long code:listProducts) {
            for(ProductDTO productDTO:listProductsBD) {
                if(code==productDTO.getCode()) {
                    totalPrice += productDTO.getPrice();
                }
            }
        }
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setListProducts(listProducts);
        shoppingCart.setTotalPrice(totalPrice);

        cartRepo.save(shoppingCart);

        return "Carrito de compras creado exitosamente!";
    }

    // Metodo para listar todos los carritos de compras
    @Override
    public List<ShoppingCart> getAllShoppingCarts() {
        return cartRepo.findAll();
    }

    // Metodo para obtener un carritos de compras por su id
    @Override
    public ShoppingCart getShoppingCartById(Long id) {
        return cartRepo.findById(id).orElse(null);
    }

    // Metodo para eliminar un carritos de compras
    @Override
    public void deleteShoppingCart(Long id) {
        cartRepo.deleteById(id);
    }

    // Metodo para editar un carritos de compras
    @Override
    @CircuitBreaker(name = "products", fallbackMethod = "fallbackMethodEditShoppingCart")
    @Retry(name = "products")
    public String editShoppingCart(List<Long> listProducts, Long code) {
        List<ProductDTO> listProductsBD = apiProducts.getAllProducts();
        Double totalPrice = 0.0;

        for(Long codeList:listProducts) {
            for(ProductDTO productDTO:listProductsBD) {
                if(codeList==productDTO.getCode()) {
                    totalPrice += productDTO.getPrice();
                }
            }
        }
        ShoppingCart shoppingCart = new ShoppingCart(code, totalPrice, listProducts);
        cartRepo.save(shoppingCart);
        return "Su carrito fue modificado con exito!";
    }

    // Metodo para traer un carrito y sus productos
    @Override
    @CircuitBreaker(name = "products", fallbackMethod = "fallbackMethodGetProductCart")
    @Retry(name = "products")
    public ShoppingCartDTO getProductCart(Long idCart) {
        List<ProductDTO> listProducts = apiProducts.getAllProducts();
        ShoppingCart shoppingCart = this.getShoppingCartById(idCart);
        List<ProductDTO> productsCart = new ArrayList<>();

        for(Long code:shoppingCart.getListProducts()) {
            for(ProductDTO productDTO:listProducts) {
                if(code==productDTO.getCode()) {
                    productsCart.add(productDTO);
                }
            }
        }
        // Llamado de excepcion para probar el funcionamiento del patron de diseño Circuit Breaker
        //createException();
        return new ShoppingCartDTO(productsCart, shoppingCart.getTotalPrice());
    }

    public String fallbackMethodSaveShoppingCart(Throwable throwable) {
        return "Error, no se pudo crear tu carrito de compras";
    }

    public String fallbackMethodEditShoppingCart(Throwable throwable) {
        return "Error, no se pudo modificar tu carrito de compras";
    }

    public ShoppingCartDTO fallbackMethodGetProductCart(Throwable throwable) {
        return new ShoppingCartDTO(null, 00000.00);
    }

    public void createException() {
        throw new IllegalArgumentException();
    }
}