package com.example.cart.controller;

import com.example.cart.dto.CartDTO;
import com.example.cart.dto.ResponseDTO;
import com.example.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;
    //add data into book table
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> createCart(@Valid @RequestBody CartDTO cartDTO) {
        ResponseDTO responseDTO = new ResponseDTO("New Book Store into DB Successfully", cartService.addCart(cartDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
