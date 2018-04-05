package com.company.demo.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Kate M on 05.04.2018.
 */
public class ConfigurationRepositoryTest extends BaseTest{

    @Autowired
    private ConfigurationRepository configurationRepository;



    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void getDiscountTest() {
        double discount = configurationRepository.getDiscount("user1");
        assertThat(discount, notNullValue());
    }

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void getShippingRateTest() {
        double shippingRate = configurationRepository.getShippingRate("user1", 10D);
        assertThat(shippingRate, notNullValue());
    }


}