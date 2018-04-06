package com.company.demo.repository;

import com.company.demo.entity.Coffee;
import com.company.demo.entity.Order;

import java.util.Map;

/**
 * Created by Kate M on 01.04.2018.
 */
public interface OrderRepositoryCustom {

    Map<Coffee, Integer> findInfoAboutProductsInCartByUserId(Long id);

    Order findUserCartByUserId(Long id);

    void updateProductsInUserCartByUserIdProductIdAmount(String userName, Long productId, int amountToUpdate);

    void deleteProductsInUserCartByUserNameAndProductId(String userName, Long productId);

    void addProductsToUserCartByUserNameProductId(String userName, Long productId);

    void updateOrder(String address, String receiverName, double shippingRate, double total, Long userId);


}
