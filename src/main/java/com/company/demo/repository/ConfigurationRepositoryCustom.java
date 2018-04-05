package com.company.demo.repository;

/**
 * Created by Kate M on 04.04.2018.
 */
public interface ConfigurationRepositoryCustom {
    double getDiscount(String userName);

    double getShippingRate(String name, double orderTotal);


}
