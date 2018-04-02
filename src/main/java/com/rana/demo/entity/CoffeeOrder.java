package com.rana.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Kate M on 02.04.2018.
 */
@Entity
@Table(name = "coffee_order")
@ToString(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class CoffeeOrder extends BaseEntity {

    private static final long serialVersionUID = -794176901144363185L;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "coffee_id")
    private Coffee coffee;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;
}
