package com.rana.demo.repository;

import com.rana.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Kate M on 02.04.2018.
 */
public interface UserRepository extends CrudRepository<User, Long> {




}
