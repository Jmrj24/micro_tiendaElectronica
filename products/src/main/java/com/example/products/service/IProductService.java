package com.example.products.service;

import com.example.products.model.Product;

import java.util.List;

public interface IProductService {
    // Metodo para crear productos
    public void saveProduct(Product product);

    // Metodo para listar todos los productos
    public List<Product> getAllProducts();

    // Metodo para obtener un producto por su codigo
    public Product getProductByCode(Long code);

    // Metodo para eliminar un producto
    public void deleteProduct(Long code);

    // Metodo para editar un producto
    public void editProduct(Product product);
}
