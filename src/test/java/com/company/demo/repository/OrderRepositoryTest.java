package com.company.demo.repository;

import com.company.demo.entity.Coffee;
import com.company.demo.entity.Order;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

/**
 * Created by Kate M on 05.04.2018.
 */
public class OrderRepositoryTest extends BaseTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void countProductsInCartByUserIdTest() {
        Long count = orderRepository.countProductsInCartByUserId(2L);
        assertThat(count, is(2L));
    }

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void findCartTotalByUserIdTest() {
        Double total = orderRepository.findCartTotalByUserId(2L);
        assertThat(total, is(4d));
    }

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void findInfoAboutProductsInCartByUserIdTest() {
        Map<Coffee, Integer> map = orderRepository.findInfoAboutProductsInCartByUserId(2L);
        assertThat(map, notNullValue());
        List<Coffee.name> list = map.keySet().stream().map(Coffee::getName).collect(Collectors.toList());
        assertThat(list, containsInAnyOrder(Coffee.name.CAPPUCINO));
    }

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void findUserCartByUserIdTest() {
        Order cart = orderRepository.findUserCartByUserId(2L);
        assertThat(cart.getStatus(), is(Order.OrderStatus.NEW));
    }

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void updateProductsInUserCartByUserIdProductIdAmountTest() {
        orderRepository.updateProductsInUserCartByUserIdProductIdAmount("user1", 1L, 4);
        Map<Coffee, Integer> map = orderRepository.findInfoAboutProductsInCartByUserId(2L);
        assertThat(map, notNullValue());
    }

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void deleteProductsInUserCartByUserNameAndProductIdTest() {
        orderRepository.deleteProductsInUserCartByUserNameAndProductId("user1", 1L);
        Map<Coffee, Integer> map = orderRepository.findInfoAboutProductsInCartByUserId(2L);
        List<Coffee.name> list = map.keySet().stream().map(Coffee::getName).collect(Collectors.toList());
        assertThat(list, Matchers.empty());
    }

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void addProductsToUserCartByUserNameProductIdTest() {
        orderRepository.addProductsToUserCartByUserNameProductId("user1", 3L);
        Map<Coffee, Integer> map = orderRepository.findInfoAboutProductsInCartByUserId(2L);
        assertThat(map, notNullValue());
        List<Coffee.name> list = map.keySet().stream().map(Coffee::getName).collect(Collectors.toList());
        assertThat(list, containsInAnyOrder(Coffee.name.CAPPUCINO, Coffee.name.ESPRESSO));
    }

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void updateOrderTest() {
        orderRepository.updateOrder("Minsk, Gurteva str, 1,1", "Alise", 0, 55, 2L);
        Order foundOrder = orderRepository.findUserCartByUserId(2L);
        assertThat(foundOrder, notNullValue());
    }

}
