package com.company.demo.service;

import com.company.demo.entity.Coffee;

import java.util.List;

/**
 * Created by Kate M on 05.04.2018.
 */
public interface CoffeeService {

     Coffee findById(Long id);

     List<Coffee> findAll();
}
