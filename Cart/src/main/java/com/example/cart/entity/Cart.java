package com.example.cart.entity;

import com.example.cart.dto.CartDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private int cartid;
    private int userid;
    public int bookid;
    public int quantity;
    @Column(name = "totalprice")
    public float price;

    public Cart(CartDTO cartDTO) {
        this.userid = cartDTO.getUserid();
        this.bookid = cartDTO.getBookid();
        this.quantity = cartDTO.getQuantity();
        this.price = cartDTO.getPrice();
    }


    public Cart(int userid, int bookid, int quantity, float price) {
        this.bookid = bookid;
        this.userid=userid;
        this.quantity=quantity;
        this.price=price;
    }
}
