package com.example.products.service;

import com.example.products.model.Product;
import com.example.products.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepo;

    // Metodo para crear productos
    @Override
    public void saveProduct(Product product) {
        productRepo.save(product);
    }

    // Metodo para listar todos los productos
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    // Metodo para obtener un producto por su codigo
    @Override
    public Product getProductByCode(Long code) {
        return productRepo.findById(code).orElse(null);
    }

    // Metodo para eliminar un producto
    @Override
    public void deleteProduct(Long code) {
        productRepo.deleteById(code);
    }

    // Metodo para editar un producto
    @Override
    public void editProduct(Product product) {
        this.saveProduct(product);
    }
}
