package com.example.cart.service;

import com.example.cart.dto.CartDTO;
import com.example.cart.entity.Book;
import com.example.cart.entity.Cart;
import com.example.cart.entity.User;
import com.example.cart.exception.CustomException;
import com.example.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    private RestTemplate restTemplate;

    //add data through post method
    public Cart addData(CartDTO cartDTO) {
        Cart cart = new Cart(cartDTO);
        return cartRepository.save(cart);
    }

    public Cart addCart(CartDTO cartDTO) {
        User userdata = restTemplate.getForObject("http://book-user-server/user/get/" + cartDTO.userid, User.class);
        Book bookdata = restTemplate.getForObject("http://book-book-server/book/get/" + cartDTO.bookid, Book.class);
        //if (userdata!=null && bookdata!=null)
       // if (cartDTO.getUserid().equals(userdata.get().getUserid()) && cartDTO.getBookid().equals(bookdata.get().getBookid()))

        if(userdata.equals(cartDTO.getUserid())) {
            throw new CustomException("Userid  not present");
        }
        else if (bookdata.equals(cartDTO.getBookid())) {
            throw new CustomException("Bookid not present");
        }
        else {
            Cart cart = new Cart(userdata.getUserid(), bookdata.getBookid(), cartDTO.getQuantity(), bookdata.getPrice());
            cart.setPrice(cart.getPrice() * cartDTO.getQuantity());
            cartRepository.save(cart);
            return cart;
        }
    }
}
