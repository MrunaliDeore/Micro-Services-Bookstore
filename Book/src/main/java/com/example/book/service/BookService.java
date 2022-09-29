package com.example.book.service;

import com.example.book.dto.BookDTO;
import com.example.book.entity.Book;
import com.example.book.exception.CustomException;
import com.example.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    //add data through post method
    public Book addData(BookDTO bookDTO) {
        Book book = new Book(bookDTO);
            return bookRepository.save(book);
    }
    public Optional<Book> getBytId(int id) {
        if(bookRepository.findById(id).isPresent()){
            return bookRepository.findById(id);
        }else
            throw new CustomException("Book Id not found..!");
    }
}
