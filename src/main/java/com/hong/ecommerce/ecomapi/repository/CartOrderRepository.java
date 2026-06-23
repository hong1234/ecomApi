package com.hong.ecommerce.ecomapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

import com.hong.ecommerce.ecomapi.domain.CartOrder;

public interface CartOrderRepository extends JpaRepository<CartOrder, Integer> {
    List<CartOrder> findByCartUuid(String cartUuid);
}
