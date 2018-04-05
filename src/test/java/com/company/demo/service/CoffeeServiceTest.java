package com.company.demo.service;

import com.company.demo.entity.Coffee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

/**
 * Created by Kate M on 05.04.2018.
 */
public class CoffeeServiceTest extends BaseTest {

    @Autowired
    CoffeeService coffeeService;

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void findByIdTest() {
        Coffee coffee = coffeeService.findById(1L);
        assertThat(coffee, notNullValue());

    }

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void findAllTest() {
        List<Coffee> list = coffeeService.findAll();
        List<Coffee.name> names = list.stream().map(Coffee::getName).collect(Collectors.toList());
        assertThat(names, containsInAnyOrder(Coffee.name.CAPPUCINO, Coffee.name.AMERICANO, Coffee.name.ESPRESSO));
    }


}
