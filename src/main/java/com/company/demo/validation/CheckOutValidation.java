package com.company.demo.validation;

import com.company.demo.entity.Order;
import com.company.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Kate M on 24.03.2018.
 */
public class CheckOutValidation implements Validator {

    private OrderService orderService;

    @Autowired
    public CheckOutValidation(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Order.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Order order = (Order) target;
        if (order.getAddress().equals("")) {
            errors.rejectValue("address", null, "Please, enter valid address");
        }
        if (order.getReceiverName().equals("")) {
            errors.rejectValue("receiverName", null, "Please, enter valid Receiver Name");
        }
    }
}
