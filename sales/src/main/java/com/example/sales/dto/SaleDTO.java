package com.example.sales.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {
    public Long codeSale;
    public LocalDate dateSale;
    public List<ProductDTO> products;
    public Double totalPrice;
}
