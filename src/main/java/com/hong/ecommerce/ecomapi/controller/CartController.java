package com.hong.ecommerce.ecomapi.controller;

import java.util.List;
import jakarta.validation.Valid;

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

import com.hong.ecommerce.ecomapi.domain.CartItem;
import com.hong.ecommerce.ecomapi.domain.CartItemDTO;
import com.hong.ecommerce.ecomapi.service.CartService;
import com.hong.ecommerce.ecomapi.service.ProductServiceException;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private CartService cartService; 

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{uuId}")
    public List<CartItem> getCart(@PathVariable String uuId) throws ProductServiceException {
        return cartService.getCartByUuid(uuId);
    }

    @PostMapping
    public CartItem addProduct(@RequestBody @Valid CartItemDTO dto) throws ProductServiceException {
        return cartService.addCartItem(dto);
    }
}
