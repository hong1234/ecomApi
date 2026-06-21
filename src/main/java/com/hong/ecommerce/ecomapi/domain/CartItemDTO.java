package com.hong.ecommerce.ecomapi.domain;

import lombok.Data;
import java.math.BigDecimal;

import jakarta.validation.constraints.*; 

@Data
public class CartItemDTO {
    @NotNull(message = "cartUuid is required.")
    private String cartUuid;

    @NotNull(message = "productUuid is required.")
    private String productUuid;

    @NotNull(message = "masstype is required.")
    private String masstype;

    @NotNull(message = "productUuid is required.")
    private String title;

    @Digits(integer=6, fraction=2)
    @NotNull(message = "price is required.")
    private BigDecimal price;

    // @NotBlank(message = "ProductID is required.") 
    private Integer quantity;

    // private String material;
    @NotNull(message = "color is required.")
    private String color;

    private Integer hoseVbung; 
    private Integer hoseVmong;
    private Integer hoseVdui; 
    private Integer hoseDdui;
    private Integer hoseDcang; 

    private Integer hemdVco;
    private Integer hemdVnach; 
    private Integer hemdVnguc;
    private Integer hemdVeo; 
    private Integer hemdVcotay;
    private Integer hemdDvai; 
    private Integer hemdDtay;
    private Integer hemdDao; 

}


    
    
    
    
    
    
    
    
    
    
    
    
