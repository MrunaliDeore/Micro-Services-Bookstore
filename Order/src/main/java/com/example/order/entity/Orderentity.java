package com.example.order.entity;

import com.example.order.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ordertable")
public class Orderentity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int orderid;
    private float price;
    private int quantity;
    private String address;
    private boolean cancel;
    private LocalDate date = LocalDate.now();

    public Orderentity(OrderDTO orderDTO) {
        this.price = orderDTO.getPrice();
        this.quantity = orderDTO.getQuantity();
        this.address = orderDTO.getAddress();
        this.cancel =orderDTO.isCancel();
    }

}
