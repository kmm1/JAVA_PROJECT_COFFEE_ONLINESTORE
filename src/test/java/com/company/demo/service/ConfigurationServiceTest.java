package com.company.demo.service;

import com.company.demo.entity.Configuration;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Kate M on 05.04.2018.
 */
public class ConfigurationServiceTest extends BaseTest {

    @Autowired
    private ConfigurationService configurationService;

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void findByIdTest() {
        Configuration configuration = configurationService.findById(1L);
        assertThat(configuration, notNullValue());
    }

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void getDiscountTest() {
        double discount = configurationService.getDiscount("user1");
        assertThat(discount, notNullValue());
    }

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void getShippingRateTest() {
        double shippingRate = configurationService.getShippingRate("user1", 10D);
        assertThat(shippingRate, notNullValue());
    }

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void updateTest() {
        Configuration configuration = configurationService.findById(1L);
        configurationService.update(configuration);
        assertThat(configuration, notNullValue());
    }
}
