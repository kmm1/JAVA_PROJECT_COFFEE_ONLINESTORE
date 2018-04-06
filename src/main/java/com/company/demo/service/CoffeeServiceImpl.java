package com.company.demo.service;

import com.company.demo.entity.Coffee;
import com.company.demo.repository.CoffeeRepository;
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
public class CoffeeServiceImpl implements CoffeeService {


    private CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public Coffee findById(Long id) {
        return coffeeRepository.findById(id).get();
    }

    @Override
    public List<Coffee> findAll() {
        List<Coffee> list = new ArrayList<>();
        for (Coffee coffee : coffeeRepository.findAll()) {
            list.add(coffee);
        }
        return list;
    }

    @Override
    public List<Coffee> findAllAvailable() {
        return coffeeRepository.findAllAvailable();
    }
}
