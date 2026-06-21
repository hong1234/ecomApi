package com.hong.ecommerce.ecomapi.domain;  

// import java.util.Date;
// import java.time.LocalDateTime;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.CascadeType;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

// import jakarta.validation.constraints.Max;
// import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Pattern;
// import jakarta.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString; 

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cartUuid;
    private String productUuid;
    private String masstype;
    private String title;
    private BigDecimal price;
    private Integer quantity;
    // private LocalDateTime createdAt; //  = LocalDateTime.now();
    // private String material;
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
