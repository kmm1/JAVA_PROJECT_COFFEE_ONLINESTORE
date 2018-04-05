package com.company.demo.service;

import com.company.demo.entity.User;
import com.company.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Kate M on 02.04.2018.
 */
@Transactional
@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findOne(Long id) {
        return userRepository.findById(id).get();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            list.add(user);
        }
        return list;
    }

    public User save(User user) {
        return userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User foundUser = userRepository.findUserByName(s);
        if (foundUser == null) {
            throw new UsernameNotFoundException("Can't find user by provided name");
        }
        return new org.springframework.security.core.userdetails.User(foundUser.getName(),
                foundUser.getPassword(), getUserAuthority(foundUser));
    }

    private Set<GrantedAuthority> getUserAuthority(User user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(String.valueOf(user.getRole())));
        return grantedAuthorities;
    }
}
