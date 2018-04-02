package com.rana.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kate M on 02.04.2018.
 */
@Entity
@Table(name = "coffee")
@ToString(callSuper = true, exclude = {"orders"})
@NoArgsConstructor
@Getter
@Setter
public class Coffee extends BaseEntity {

    private static final long serialVersionUID = -7941769011539367185L;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private name name;

    @Column(name = "image")
    private String image;

    @Column(name = "available")
    private Boolean available;



    @ManyToMany(mappedBy = "coffeesInOrder")
    private List<Order> orders = new ArrayList();

    public enum name {
        CAPPUCINO,
        AMERICANO,
        ESPRESSO
    }

}
