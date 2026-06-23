package com.hong.ecommerce.ecomapi.service;

import java.util.List;
// import java.util.UUID;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.hong.ecommerce.ecomapi.repository.CartItemRepository;
import com.hong.ecommerce.ecomapi.domain.CartItem;
import com.hong.ecommerce.ecomapi.domain.CartItemDTO;

@RequiredArgsConstructor
@Service
public class CartService {
    private final CartItemRepository cartRepository;

    public List<CartItem> getCartByUuid(String cartUuid){
        // UUID.fromString('9d927bff-8d5b-4929-8c26-a9be00173adc')
        // return cartRepository.itemsInCart(cartUuid);
        return cartRepository.findByCartUuid(cartUuid);
    }

    public CartItem addCartItem(CartItemDTO dto) throws ProductServiceException {
        CartItem item = new CartItem();
        item.setCartUuid(dto.getCartUuid());
        item.setProductUuid(dto.getProductUuid());
        item.setMasstype(dto.getMasstype());
        item.setTitle(dto.getTitle());
        item.setPrice(dto.getPrice());
        item.setQuantity(dto.getQuantity());
        item.setColor(dto.getColor());
        
        item.setHoseVbung(dto.getHoseVbung());
        item.setHoseVmong(dto.getHoseVmong());
        item.setHoseVdui(dto.getHoseVdui());
        item.setHoseDdui(dto.getHoseDdui());
        item.setHoseDcang(dto.getHoseDcang());

        item.setHemdVco(dto.getHemdVco());
        item.setHemdVnach(dto.getHemdVnach());
        item.setHemdVnguc(dto.getHemdVnguc());
        item.setHemdVeo(dto.getHemdVeo());
        item.setHemdVcotay(dto.getHemdVcotay());
        item.setHemdDvai(dto.getHemdDvai());
        
        item.setHemdDtay(dto.getHemdDtay());
        item.setHemdDao(dto.getHemdDao());
        
        item = cartRepository.save(item);
        return item;
        // return productRecord(newProd);
    }

}
