package com.hong.ecommerce.ecomapi.repository;

// import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hong.ecommerce.ecomapi.domain.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository extends JpaRepository<Product, Integer>
// , PagingAndSortingRepository<Product, Integer> 
{
    List<Product> findByPrio(Integer prio);
    List<Product> findByCategory(String category);
    Page<Product> findByCategory(String category, Pageable pageable);

    @Query("from Product p where p.searchkeys like %?1%")
    List<Product> searchByTitle(String keys);

    // @Query("SELECT p FROM Product p WHERE p.category = :category")
    // List<Product> productsOfCategory(@Param("category") String category);

    // Custom Pageable Query
    // @Query(value = "SELECT * FROM product WHERE category = :category", 
    //        countQuery = "SELECT COUNT(*) FROM product WHERE category = :category", 
    //        nativeQuery = true)
    // Page<Product> getAllProductsPage(Pageable pageable, @Param("category") String category);
}
