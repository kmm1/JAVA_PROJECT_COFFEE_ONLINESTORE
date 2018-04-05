package com.company.demo.repository;

import com.company.demo.entity.Configuration;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Kate M on 02.04.2018.
 */
public interface ConfigurationRepository extends CrudRepository<Configuration, Long>, ConfigurationRepositoryCustom {

}
