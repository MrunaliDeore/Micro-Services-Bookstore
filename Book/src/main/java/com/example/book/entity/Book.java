package com.example.book.entity;

import com.example.book.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "book_id", nullable = false)
    private int bookid;
    private String name;
    private String author;
    private float price;
    private LocalDate arrivaldate;
    private String coverimage;
    private int quantity;

    public Book(BookDTO bookDTO) {
        this.name = bookDTO.getName();
        this.author = bookDTO.getAuthor();
        this.price = bookDTO.getPrice();
        this.arrivaldate = bookDTO.getArrivaldate();
        this.coverimage = bookDTO.getCoverimage();
        this.quantity = bookDTO.getQuantity();
    }
}