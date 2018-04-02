package com.rana.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kate M on 02.04.2018.
 */
@Entity
@Table(name = "user")
@ToString(callSuper = true, exclude = {"orders"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {
    private static final long serialVersionUID = -7941769011539363185L;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();


    private enum Role {
        USER,
        ADMIN
    }

}