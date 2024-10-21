package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productServ;

    // Variable tomada para probar el correcto funcionamiento del patron de diseño Load Balancing
    @Value("${server.port}")
    private int serverPort;

    // EndPoint para crear productos
    @PostMapping("/create")
    public String saveProduct(@RequestBody Product product) {
        productServ.saveProduct(product);
        return "Producto creado exitosamente!";
    }

    // EndPoint para listar todos los productos
    @GetMapping("/get")
    public List<Product> getAllProducts() {
        System.out.println("----------------------------------");
        System.out.println("Desde: " + serverPort);
        return productServ.getAllProducts();
    }

    // EndPoint para eliminar productos por su codigo
    @DeleteMapping("/delete/{code}")
    public String deleteProduct(@PathVariable Long code) {
        productServ.deleteProduct(code);
        return "Producto eliminado exitosamente!";
    }

    // EndPoint para editar productos
    @PutMapping("/edit")
    public Product editProduct(@RequestBody Product product) {
        productServ.editProduct(product);
        return productServ.getProductByCode(product.getCode());
    }
}
