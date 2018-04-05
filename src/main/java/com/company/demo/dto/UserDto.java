package com.company.demo.dto;

import com.company.demo.entity.Order;
import com.company.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by Kate M on 26.03.2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserDto {

    private Long id;
    private String name;
    private User.Role role;
    private Long numberOfProductsInCart;
    private Order currentOrder;
    private double cartTotal;

}
