package com.rana.demo.repository;

import com.rana.demo.entity.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Kate M on 02.04.2018.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}
