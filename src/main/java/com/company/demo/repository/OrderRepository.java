package com.company.demo.repository;

import com.company.demo.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Kate M on 02.04.2018.
 */
public interface OrderRepository extends CrudRepository<Order, Long>, OrderRepositoryCustom {

    @Query("SELECT count (co) FROM CoffeeOrder co JOIN co.coffee c JOIN co.order as o WHERE o.status='NEW' and o.user.id=?1")
    Long countProductsInCartByUserId(Long id);

    @Query("SELECT sum(p.price) FROM  CoffeeOrder co JOIN co.coffee p JOIN co.order o WHERE o.status='NEW' AND o.user.id=?1")
    Double findCartTotalByUserId(Long id);





}
