package com.example.order.service;

import com.example.order.dto.OrderDTO;
import com.example.order.entity.Orderentity;
import com.example.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    //add data through post method
    public Orderentity addData(OrderDTO orderDTO) {
        Orderentity order = new Orderentity(orderDTO);
        return orderRepository.save(order);
    }


}
