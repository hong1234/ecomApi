package com.hong.ecommerce.ecomapi.domain; 

import java.util.List;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString; 

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Product { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // private int productId;
    private String productUuid;

    @NotBlank(message = "Title is required")
    @Size(min = 10, max = 100, message = "Title must be between 10 and 100 characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(min = 10, max = 256, message = "Title must be between 10 and 100 characters")
    private String descript;

    @NotBlank(message = "Searchkeys is required")
    @Size(min = 10, max = 256, message = "Searchkeys must be between 10 and 256 characters")
    private String searchkeys;

    @NotBlank(message = "Title is required")
    @Size(min = 10, max = 200, message = "Imagename must be between 10 and 255 characters")
    private String imagename;

    @NotBlank(message = "Category is required")
    @Size(min = 4, max = 10, message = "Category must be between 4 and 10 characters")
    private String category;

    @NotBlank(message = "Masstype is required")
    @Size(min = 4, max = 10, message = "Category must be between 4 and 10 characters")
    private String masstype;

    private BigDecimal price;
}
