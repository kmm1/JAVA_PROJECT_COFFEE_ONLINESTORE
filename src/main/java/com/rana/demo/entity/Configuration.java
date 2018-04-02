package com.rana.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

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

}
