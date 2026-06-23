package com.hong.ecommerce.ecomapi.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedModel;

import com.hong.ecommerce.ecomapi.domain.Product;
import com.hong.ecommerce.ecomapi.service.ProductService;
import com.hong.ecommerce.ecomapi.service.ProductServiceException; 

@RestController
@RequestMapping("/api/products")
public class ProductController {  
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable int productId) throws ProductServiceException {
        return productService.getProduct(productId);
    }

    @GetMapping("/best")
    public List<Product> bestProducts() throws ProductServiceException {  
        return productService.bestProducts();
    }

    @GetMapping("/search")
    // @ResponseStatus(HttpStatus.OK)
    public List<Product> searchProductsByTitle(@RequestParam String title) throws ProductServiceException {  
        return productService.searchByTitle(title);
    }

    @GetMapping("/filter")
    // @ResponseStatus(HttpStatus.OK)
    public List<Product> productsOfCategory(@RequestParam String category) throws ProductServiceException {  
        return productService.productsOfCategory(category);
    }

    // Pagination using custom WHERE clause
    // @GetMapping("/getProductsWithPage")
    // public ResponseEntity<Page<Product>> getAllProductsWithPage(
    //     @RequestParam(defaultValue = "0") int page,
    //     @RequestParam(defaultValue = "10") int size) {
    //     return ResponseEntity.ok(productService.getAllProductWithPage(size, page));
    // }

    @GetMapping("/page")
    public PagedModel<Product> productsPage(
        @RequestParam String category,
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "4") int size) {
        Page<Product> productPage = productService.getAllProductWithPage(category, page, size);
        return new PagedModel<>(productPage);
    }

}
