package com.example.cart.dto;

import lombok.Data;

@Data
public class CartDTO {
    public int userid;

    public int bookid;

    public int quantity;

    public float price;
}
