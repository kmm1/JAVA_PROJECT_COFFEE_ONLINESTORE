package com.company.demo.repository;

import com.company.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Kate M on 02.04.2018.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByName(String name);

    User findByEmail(String name);


}
