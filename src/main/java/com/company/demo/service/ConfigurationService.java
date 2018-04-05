package com.company.demo.service;

import com.company.demo.entity.Configuration;

/**
 * Created by Kate M on 05.04.2018.
 */
public interface ConfigurationService {

    Configuration findById(Long id);

    double getDiscount(String userName);

    double getShippingRate(String name, double orderTotal);

    Configuration update(Configuration configuration);

}