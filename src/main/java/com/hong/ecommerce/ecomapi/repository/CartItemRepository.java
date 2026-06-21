package com.hong.ecommerce.ecomapi.repository;

// import java.util.UUID; 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hong.ecommerce.ecomapi.domain.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    @Query("SELECT c FROM CartItem c WHERE c.cartUuid = :cartUuid")
    List<CartItem> itemsInCart(@Param("cartUuid") String cartUuid);

}
