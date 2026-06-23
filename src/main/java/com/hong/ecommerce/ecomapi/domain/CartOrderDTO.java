package com.hong.ecommerce.ecomapi.domain;

import lombok.Data;
// import java.math.BigDecimal;

import jakarta.validation.constraints.*; 

@Data
public class CartOrderDTO {
    @NotNull(message = "cartUuid is required.")
    private String cartUuid;
    @NotNull(message = "customerFname is required.")
    private String customerFname;
    @NotNull(message = "customerLname is required.")
    private String customerLname;
    @NotNull(message = "customerEmail is required.")
    private String customerEmail;
    @NotNull(message = "customerFonnumber is required.")
    private String customerFonnumber;
    @NotNull(message = "customerAddress is required.")
    private String customerAddress;
}
