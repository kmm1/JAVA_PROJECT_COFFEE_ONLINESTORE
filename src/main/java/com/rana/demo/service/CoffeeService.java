package com.rana.demo.service;

import com.rana.demo.entity.Coffee;
import com.rana.demo.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kate M on 02.04.2018.
 */
@Service
@Transactional
public class CoffeeService {


    private CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }


    public List<Coffee> findAll() {
        List<Coffee> list = new ArrayList<>();
        for (Coffee coffee : coffeeRepository.findAll()) {
            list.add(coffee);
        }
        return list;
    }
}
