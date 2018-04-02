package com.rana.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kate M on 02.04.2018.
 */
@Entity
@Table(name = "orders")
@ToString(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class Order extends BaseEntity {

    private static final long serialVersionUID = -794769011539363185L;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "coffee_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "coffee_id"))
    private List<Coffee> coffeesInOrder = new ArrayList();

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "address")
    private String address;

    @Column(name = "reciever_name")
    private String recieverName;

    @Column(name = "free_delivery")
    private String freeDelivery;
}
