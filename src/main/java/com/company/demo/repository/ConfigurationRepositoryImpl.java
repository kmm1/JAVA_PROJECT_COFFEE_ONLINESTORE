package com.company.demo.repository;

import com.company.demo.dto.UserDto;
import com.company.demo.entity.Coffee;
import com.company.demo.entity.Configuration;
import com.company.demo.entity.Order;
import com.company.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

/**
 * Created by Kate M on 04.04.2018.
 */
public class ConfigurationRepositoryImpl implements ConfigurationRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private UserDto userDto;

    @Autowired
    public ConfigurationRepositoryImpl(UserRepository userRepository, OrderRepository orderRepository, UserDto userDto) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.userDto = userDto;
    }

    @Override
    public double getDiscount(String name) {
        Configuration configuration = findOne();
        Map<Coffee, Integer> order = orderRepository.findInfoAboutProductsInCartByUserId(userRepository.findUserByName(name).getId());
        double discount = 0;
        for (Map.Entry<Coffee, Integer> o : order.entrySet()) {
            Integer value = (Integer) o.getValue();
            Integer freeCup = configuration.getFreeCup();
            int i = value / freeCup;
            discount += i * o.getKey().getPrice().doubleValue();
        }
        return discount;
    }

    public Configuration findOne() {
        Configuration configuration = em.createQuery("SELECT c from Configuration c WHERE c.id='1'", Configuration.class).getSingleResult();
        return configuration;
    }

    @Override
    public double getShippingRate(String name, double cartTotal) {
        double discount = getDiscount(name);
        double shippingCost;
        User foundUser = userRepository.findUserByName(name);
        Order currentOrder = orderRepository.findUserCartByUserId(foundUser.getId());
        List<Coffee> products = currentOrder.getCoffeesInOrder();
        double sum = products.stream().mapToDouble(c -> c.getPrice().doubleValue()).sum();
        if (sum - discount >= findOne().getTotalForFreeShipping()) {
            shippingCost = 0;
        } else shippingCost = findOne().getShippingRate();
        return shippingCost;
    }




}
