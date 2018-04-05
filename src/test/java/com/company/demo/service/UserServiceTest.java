package com.company.demo.service;

import com.company.demo.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by Kate M on 05.04.2018.
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Autowired
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void testFindUserByIdTest() {
        User user = userService.findOne(1L);
        assertThat(user, notNullValue());
        assertThat(user.getName(), is("admin"));
    }

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void testSaveUserTest() {
        User user = new User();
        user.setName("test");
        user.setEmail("test@email.com");
        user.setRole(User.Role.USER);
        user.setConfirmPassword("test");
        user.setPassword(encoder().encode("test"));
        User savedUser = userService.save(user);
        assertThat(userService.findOne(savedUser.getId()), notNullValue());
        assertThat(encoder().matches("test", userService.findOne(savedUser.getId()).getPassword()), is(true));
    }

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void testFindAllUserTest() {
        List<User> allUsers = userService.findAll();
        assertThat(allUsers, hasSize(3));
        List<String> list = allUsers.stream().map(e -> e.getName()).collect(Collectors.toList());
        assertThat(list, hasSize(3));
        assertThat(list, containsInAnyOrder("admin", "user1", "user2"));
    }

    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void testFindUserByNameTest() {
        User user = userService.findUserByName("user1");
        assertThat(user.getName(), is("user1"));
    }



    @Test
    @Sql(scripts = "classpath:coffee.sql")
    public void testFindUserByEmailTest() {
        User user = userService.findByEmail("admin@gmail.com");
        assertThat(user.getEmail(), is("admin@gmail.com"));
    }

}