package com.company.demo.service;

import com.company.demo.entity.Configuration;
import com.company.demo.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Kate M on 02.04.2018.
 */
@Service
@Transactional
public class ConfigurationServiceImpl implements ConfigurationService {

    private ConfigurationRepository configurationRepository;

    @Autowired
    public ConfigurationServiceImpl(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    @Override
    public Configuration findById(Long id) {
        return configurationRepository.findById(id).get();
    }

    @Override
    public double getDiscount(String userName) {
        return configurationRepository.getDiscount(userName);
    }

    @Override
    public double getShippingRate(String name, double orderTotal) {
        return configurationRepository.getShippingRate(name, orderTotal);
    }

    @Override
    public Configuration update(Configuration configuration) {
        Configuration conf = configurationRepository.save(configuration);
        return conf;
    }
}