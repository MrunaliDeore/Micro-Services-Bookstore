package com.example.order.dto;

import lombok.Data;

@Data
public class OrderDTO {
    public int userid;
    public int bookid;
    public int quantity;
    public float price;
    public String address;
    public String email;
    private boolean cancel;
}
