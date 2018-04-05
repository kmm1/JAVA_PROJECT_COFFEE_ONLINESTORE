package com.company.demo.repository;

import com.company.demo.entity.Coffee;
import com.company.demo.entity.Order;
import com.company.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Kate M on 01.04.2018.
 */
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    private UserRepository userRepository;

    private CoffeeRepository coffeeRepository;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public OrderRepositoryImpl(UserRepository userRepository, CoffeeRepository coffeeRepository) {
        this.userRepository = userRepository;
        this.coffeeRepository = coffeeRepository;
    }


    @Override
    public Map<Coffee, Integer> findInfoAboutProductsInCartByUserId(Long id) {
        List<Coffee> productList = em.createQuery(
                "SELECT c FROM  CoffeeOrder co JOIN co.coffee c JOIN co.order o WHERE o.status='NEW' AND o.user.id=:id order by c.name", Coffee.class)
                .setParameter("id", id)
                .getResultList();
        Map<Coffee, Integer> map = new TreeMap<>();
        for (Coffee product : productList) {
            map.put(product, map.get(product) == null ? 1 : map.get(product) + 1);
        }
        return map;
    }

    @Override
    public Order findUserCartByUserId(Long id) {
        List<Order> resultList = em.createQuery(
                "SELECT o FROM Order o WHERE o.status='NEW' and o.user.id=:id", Order.class)
                .setParameter("id", id)
                .getResultList();
        return resultList.size() > 0 ? resultList.get(0) : new Order();
    }

    @Override
    public void updateProductsInUserCartByUserIdProductIdAmount(String userName, Long productId, int amountToUpdate) {
        User foundUser = userRepository.findUserByName(userName);
        Map<Coffee, Integer> productsInCart = findInfoAboutProductsInCartByUserId(foundUser.getId());
        Order foundOrder = findUserCartByUserId(foundUser.getId());
        Coffee foundProduct = coffeeRepository.findById(productId).get();
        for (Map.Entry<Coffee, Integer> p : productsInCart.entrySet()) {
            if (p.getKey().getId().equals(productId)) {
                Integer amountInCart = p.getValue();
                if (amountToUpdate > amountInCart) {
                    for (int i = 1; i <= amountToUpdate - amountInCart; i++) {
                        foundOrder.getCoffeesInOrder().add(foundProduct);
                    }
                }
                if (amountToUpdate < amountInCart) {
                    Iterator<Coffee> iterator = foundOrder.getCoffeesInOrder().iterator();
                    while (iterator.hasNext()) {
                        Coffee next = iterator.next();
                        if (next.getId() == foundProduct.getId()) {
                            iterator.remove();
                        }
                    }
                    for (int i = 1; i <= amountToUpdate; i++) {
                        foundOrder.getCoffeesInOrder().add(foundProduct);
                    }
                }
                em.merge(foundOrder);
            }
        }
    }

    @Override
    public void deleteProductsInUserCartByUserNameAndProductId(String userName, Long productId) {
        User foundUser = userRepository.findUserByName(userName);
        Map<Coffee, Integer> productsInCart = findInfoAboutProductsInCartByUserId(foundUser.getId());
        Order foundOrder = findUserCartByUserId(foundUser.getId());
        Coffee foundProduct = coffeeRepository.findById(productId).get();
        for (Map.Entry<Coffee, Integer> p : productsInCart.entrySet()) {
            if (p.getKey().getId().equals(productId)) {
                Iterator<Coffee> iterator = foundOrder.getCoffeesInOrder().iterator();
                while (iterator.hasNext()) {
                    Coffee next = iterator.next();
                    if (next.getId() == foundProduct.getId()) {
                        iterator.remove();
                    }
                }
            }
            em.merge(foundOrder);

        }
    }

    @Override
    public void addProductsToUserCartByUserNameProductId(String userName, Long productId) {
        User foundUser = userRepository.findUserByName(userName);
        Coffee foundProduct = coffeeRepository.findById(productId).get();
        Order foundOrder = findUserCartByUserId(foundUser.getId());
        List<Coffee> coffeesInOrder = foundOrder.getCoffeesInOrder();
        coffeesInOrder.add(foundProduct);
        em.merge(foundOrder);
    }

    @Override
    public void updateOrder(String address, String receiverName, double shippingRate, double total, Long userId) {
        Order cart = findUserCartByUserId(userId);
        cart.setStatus(Order.OrderStatus.PAID);
        cart.setAddress(address);
        cart.setTotal(total);
        cart.setFreeDelivery(shippingRate == 0 ? true : false);
        cart.setReceiverName(receiverName);
        cart.setOrderDate(LocalDateTime.now());
        Order order = new Order(userRepository.findById(userId).get(), Order.OrderStatus.NEW, 0d);
        em.merge(cart);
        em.persist(order);
    }

}
