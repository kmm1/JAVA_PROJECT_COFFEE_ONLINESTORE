package com.rana.demo.service;

import com.rana.demo.entity.User;
import com.rana.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kate M on 02.04.2018.
 */
@Transactional
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findOne(Long id) {
        return userRepository.findById(id).get();
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            list.add(user);
        }
        return list;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }


}
