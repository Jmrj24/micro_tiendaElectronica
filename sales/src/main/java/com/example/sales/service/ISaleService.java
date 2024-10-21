package com.example.sales.service;

import com.example.sales.dto.SaleDTO;
import com.example.sales.model.Sale;

import java.util.List;

public interface ISaleService {
    // Metodo para crear ventas
    public void saveSale(Long idShoppingCart);

    // Metodo para listar todas las ventas
    public List<Sale> getAllSales();

    // Metodo para obtener una venta por su codigo
    public Sale getSaleByCode(Long codeSale);

    // Metodo para eliminar una venta
    public void deleteSale(Long codeSale);

    // Metodo para editar una venta
    public void editSale(Sale sale);

    // Metodo para obtener una venta con toda su informacion
    public SaleDTO getSaleProductsById(Long codeSale);
}
