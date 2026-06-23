package com.hong.ecommerce.ecomapi.service;

import java.util.List;
// import java.util.UUID;
import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.hong.ecommerce.ecomapi.repository.CartOrderRepository;
import com.hong.ecommerce.ecomapi.repository.CartItemRepository;
import com.hong.ecommerce.ecomapi.domain.CartOrder;
import com.hong.ecommerce.ecomapi.domain.CartItem;
import com.hong.ecommerce.ecomapi.domain.CartOrderDTO;
import com.hong.ecommerce.ecomapi.domain.OrderDTO;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final CartOrderRepository orderRepository;
    private final CartItemRepository cartRepository;

    // public List<CartOrder> getOrderByUuid(String cartUuid){ 
    //     return orderRepository.findByCartUuid(cartUuid);
    // }

    public OrderDTO getOrderByUuid(String cartUuid){
        // List<CartOrder> rs = orderRepository.findByCartUuid(cartUuid);
        CartOrder rs = orderRepository.findByCartUuid(cartUuid).get(0);
        List<CartItem> items = cartRepository.findByCartUuid(cartUuid);
        BigDecimal total = BigDecimal.ZERO;
        for (CartItem item : items) { 
            total = (BigDecimal.valueOf(item.getQuantity()).multiply(item.getPrice())).add(total);
        }

        OrderDTO order = new OrderDTO();
        order.setCartUuid(cartUuid);
        order.setCustomerFname(rs.getCustomerFname());
        order.setCustomerLname(rs.getCustomerLname());
        order.setTotalPrice(total);
        order.setItems(items);
        // return orderRepository.findByCartUuid(cartUuid).get(0);
        return order;
    }

    public CartOrder addCartOrder(CartOrderDTO dto) throws ProductServiceException {
        CartOrder order = new CartOrder();

        order.setCartUuid(dto.getCartUuid());
        order.setCustomerFname(dto.getCustomerFname());
        order.setCustomerLname(dto.getCustomerLname());
        order.setCustomerEmail(dto.getCustomerEmail());
        order.setCustomerFonnumber(dto.getCustomerFonnumber());
        order.setCustomerAddress(dto.getCustomerAddress());
        order = orderRepository.save(order);
        return order;
    }
}
