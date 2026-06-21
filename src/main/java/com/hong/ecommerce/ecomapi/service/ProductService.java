package com.hong.ecommerce.ecomapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.hong.ecommerce.ecomapi.repository.ProductRepository;
import com.hong.ecommerce.ecomapi.domain.Product;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public Product getProduct(int productId) throws ProductServiceException {
        return productRepository.findById(productId).get();
        // Product product = Product.builder().productId(1).title("Spring Testing Book").build();
        // return product;  
    }

    public List<Product> productsOfCategory(String category) {
        // return productRepository.productsOfCategory(category);
        return productRepository.findByCategory(category);
    }

    public List<Product> searchByTitle(String keywords) {
        return productRepository.searchByTitle(keywords.toLowerCase());
    }

    // Pagination with custom WHERE clause
    public Page<Product> getAllProductWithPage(String category, int pageNumber, int pageSize) {
        // Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("title").ascending());
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize, Sort.by("id").ascending());
        // return productRepository.getAllProductsPage(pageable, category);
        return productRepository.findByCategory(category, pageable);
    }

}
