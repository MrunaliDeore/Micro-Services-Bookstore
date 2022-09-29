package com.example.book.dto;

import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class BookDTO {
    @Pattern(regexp = "[A-za-z]{3,}", message = "Invalid book name, Book name should be 4 letters")
    private  String name;

    @Pattern(regexp = "[A-za-z]{3,}", message = "Invalid book name, Book name should be 4 letters")
    private String author;

    @Min(value=20, message = "Minimum price should be 20")
    private float price;

    private LocalDate arrivaldate;

    private String coverimage;

    @Min(value=1, message = "Minimum qty should be 1")
    private  int quantity;
}
