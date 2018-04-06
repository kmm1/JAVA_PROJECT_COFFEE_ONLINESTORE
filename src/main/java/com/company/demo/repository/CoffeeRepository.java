package com.company.demo.repository;

import com.company.demo.entity.Coffee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Kate M on 02.04.2018.
 */
public interface CoffeeRepository extends CrudRepository<Coffee, Long> {

    @Query("SELECT c FROM Coffee c WHERE c.available='1'")
    List<Coffee> findAllAvailable();

}
