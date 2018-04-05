package com.company.demo.entity;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kate M on 03.04.2018.
 */
@Entity
@Table(name = "user")
@ToString(callSuper = true, exclude = {"orders"})
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    private static final long serialVersionUID = -7941769011539363185L;

    @Getter
    @Setter
    @Column(name = "name", nullable = false, unique = true)
    @NotBlank
    private String name;

    @Getter
    @Setter
    @Column(name = "email", nullable = false, unique = true)
    @NotBlank
    @Email
    private String email;

    @Getter
    @Setter
    @Column(name = "password", nullable = false)
    @NotBlank
    private String password;

    @Getter
    @Setter
    @Transient
    @NotBlank
    private String confirmPassword;

    @Getter
    @Setter
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Getter
    @Setter
    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();


    public enum Role {
        USER,
        ADMIN
    }

}