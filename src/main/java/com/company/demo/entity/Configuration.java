package com.company.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by Kate M on 02.04.2018.
 */
@Entity
@Table(name = "configuration")
@ToString(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class Configuration extends BaseEntity {

    private static final long serialVersionUID = -7941744011539363185L;

    @Column(name = "shipping_rate", nullable = false)
    @NotNull(message = "Please, enter valid shipping rate")
    private double shippingRate;

    @Column(name = "tatal_for_free_shipping", nullable = false)
    @NotNull(message = "Please, enter valid total for free shipping")
    private double totalForFreeShipping;

    @Column(name = "free_cup", nullable = false)
    @NotNull(message = "Please, enter valid free cup")
    private Integer freeCup;

}
