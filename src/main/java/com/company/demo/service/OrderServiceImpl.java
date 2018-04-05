package com.company.demo.service;

import com.company.demo.entity.Coffee;
import com.company.demo.entity.Order;
import com.company.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Kate M on 02.04.2018.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Long countProductsInCartByUserId(Long id) {
        return orderRepository.countProductsInCartByUserId(id);
    }

    @Override
    public Double findCartTotalByUserId(Long id) {
        return orderRepository.findCartTotalByUserId(id);
    }

    @Override
    public Map<Coffee, Integer> findInfoAboutProductsInCartByUserId(Long id) {
        return orderRepository.findInfoAboutProductsInCartByUserId(id);
    }

    @Override
    public Order findUserCartByUserId(Long id) {
        return orderRepository.findUserCartByUserId(id);
    }

    @Override
    public void updateProductsInUserCartByUserIdProductIdAmount(String userName, Long productId, int amountToUpdate) {
        orderRepository.updateProductsInUserCartByUserIdProductIdAmount(userName, productId, amountToUpdate);
    }

    @Override
    public void deleteProductsInUserCartByUserNameAndProductId(String userName, Long productId) {
        orderRepository.deleteProductsInUserCartByUserNameAndProductId(userName, productId);
    }

    @Override
    public void addProductsToUserCartByUserNameProductId(String userName, Long productId) {
        orderRepository.addProductsToUserCartByUserNameProductId(userName, productId);
    }

    @Override
    public void updateOrder(String address, String receiverName, double shippingRate, double total, Long userId) {
        orderRepository.updateOrder(address, receiverName, shippingRate, total, userId);
    }

}
