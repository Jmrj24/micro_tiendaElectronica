package com.example.sales.controller;

import com.example.sales.dto.SaleDTO;
import com.example.sales.model.Sale;
import com.example.sales.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private ISaleService saleServ;

    // EndPoint para crear ventas
    @PostMapping("/create")
    public String saveSale(@RequestParam Long idShoppingCart) {
        saleServ.saveSale(idShoppingCart);
        return "Venta creada de manera exitosa!";
    }

    // EndPoint para listar todas las ventas
    @GetMapping("/get")
    public List<Sale> getAllSales() {
        return saleServ.getAllSales();
    }

    // EndPoint para eliminar una venta
    @DeleteMapping("/delete")
    public String deleteSale(@PathVariable Long codeSale) {
        saleServ.deleteSale(codeSale);
        return "Venta eliminada de forma exitosa!";
    }

    // EndPoint para editar una ventas
    @PutMapping("/edit")
    public Sale editSale(@RequestBody Sale sale) {
        saleServ.editSale(sale);
        return saleServ.getSaleByCode(sale.getCodeSale());
    }

    // EndPoint para obtener una venta con toda su informacion
    @GetMapping("/get/{codeSale}")
    public SaleDTO getSaleProductsById(@PathVariable Long codeSale) {
        return saleServ.getSaleProductsById(codeSale);
    }
}
