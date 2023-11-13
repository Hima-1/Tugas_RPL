package com.kel5.ecommerce.controller;

import com.kel5.ecommerce.dto.UserDto;
import com.kel5.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import com.kel5.ecommerce.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order-list")
    public String registrationForm(Model model) {
        List<Order> orders = orderService.getAllOrders();
        return "order/orderList";
    }
}

