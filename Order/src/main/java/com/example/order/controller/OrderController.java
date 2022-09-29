package com.example.order.controller;

import com.example.order.dto.OrderDTO;
import com.example.order.dto.ResponseDTO;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    //add data into book table
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        ResponseDTO responseDTO = new ResponseDTO("New Book Store into DB Successfully", orderService.addData(orderDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
