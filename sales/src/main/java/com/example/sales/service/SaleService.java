package com.example.sales.service;

import com.example.sales.dto.SaleDTO;
import com.example.sales.dto.ShoppingCartDTO;
import com.example.sales.model.Sale;
import com.example.sales.repository.IAPIShoppingCart;
import com.example.sales.repository.ISaleRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService implements ISaleService {
    @Autowired
    private ISaleRepository saleRepo;

    @Autowired
    private IAPIShoppingCart apiCart;

    // Metodo para crear ventas
    @Override
    public void saveSale(Long idShoppingCart) {
        Sale sale = new Sale();
        sale.setDateSale(LocalDate.now());
        sale.setIdShoppingCart(idShoppingCart);

        saleRepo.save(sale);
    }

    // Metodo para listar todas las ventas
    @Override
    public List<Sale> getAllSales() {
        return saleRepo.findAll();
    }

    // Metodo para obtener una venta por su codigo
    @Override
    public Sale getSaleByCode(Long codeSale) {
        return saleRepo.findById(codeSale).orElse(null);
    }

    // Metodo para eliminar una venta
    @Override
    public void deleteSale(Long codeSale) {
        saleRepo.deleteById(codeSale);
    }

    // Metodo para editar una venta
    @Override
    public void editSale(Sale sale) {
        saleRepo.save(sale);
    }

    // Metodo para obtener una venta con toda su informacion
    @Override
    @CircuitBreaker(name = "shoppingCart", fallbackMethod = "fallbackMethodGetSaleProductsById")
    @Retry(name = "shoppingCart")
    public SaleDTO getSaleProductsById(Long codeSale) {
        Sale sale = this.getSaleByCode(codeSale);
        ShoppingCartDTO shoppingCartDTO = apiCart.getCart(sale.getIdShoppingCart());

        // Excepcion llamada para probar el funcionamiento de Circuit Breaker
        //createException();
        return new SaleDTO(sale.getCodeSale(), sale.getDateSale(), shoppingCartDTO.getListProducts(),
                            shoppingCartDTO.getTotalPrice());
    }

    public SaleDTO fallbackMethodGetSaleProductsById(Throwable throwable) {
        return new SaleDTO(0L, LocalDate.of(1111, 11, 11), null, 0000.00);
    }

    public void createException() {
        throw new IllegalArgumentException();
    }
}
