package com.example.book.controller;

import com.example.book.dto.BookDTO;
import com.example.book.dto.ResponseDTO;
import com.example.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    //add data into book table
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> createBook(@Valid @RequestBody BookDTO bookDTO) {
        ResponseDTO responseDTO = new ResponseDTO("New Book Store into DB Successfully", bookService.addData(bookDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //get data by id from table - get method
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getById (@Valid @PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO("Get data by ID:", bookService.getBytId(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
