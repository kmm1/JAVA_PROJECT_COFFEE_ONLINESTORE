package com.company.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "coffee_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "coffee_id"))
    private List<Coffee> coffeesInOrder = new ArrayList();

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "total")
    private double total;

    @Column(name = "address")
    private String address;

    @Column(name = "reciever_name")
    private String receiverName;

    @Column(name = "free_delivery")
    private Boolean freeDelivery;


    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public enum OrderStatus {
        NEW,
        PAID,
        DECLINED,
        DELIVERED
    }

    public Order(User user, OrderStatus status, double total) {
        this.user = user;
        this.status = status;
        this.total = total;
    }
}
