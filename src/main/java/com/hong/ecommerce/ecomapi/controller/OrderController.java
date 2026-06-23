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

import com.hong.ecommerce.ecomapi.domain.CartOrder;
import com.hong.ecommerce.ecomapi.domain.CartOrderDTO;
import com.hong.ecommerce.ecomapi.domain.OrderDTO;
import com.hong.ecommerce.ecomapi.service.CartService;
import com.hong.ecommerce.ecomapi.service.OrderService;
import com.hong.ecommerce.ecomapi.service.ProductServiceException;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // @GetMapping("/{cartUuid}")
    // public List<CartOrder> getOrder(@PathVariable String cartUuid) throws ProductServiceException {
    //     return orderService.getOrderByUuid(cartUuid);
    // }

    @GetMapping("/{cartUuid}")
    public OrderDTO getOrder(@PathVariable String cartUuid) throws ProductServiceException {
        return orderService.getOrderByUuid(cartUuid);
    }

    @PostMapping
    public CartOrder addOrder(@RequestBody @Valid CartOrderDTO dto) throws ProductServiceException {
        return orderService.addCartOrder(dto);
    }

}
