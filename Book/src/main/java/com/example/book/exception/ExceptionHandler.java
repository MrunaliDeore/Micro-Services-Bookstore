package com.example.book.exception;

import com.example.book.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
    public ResponseEntity<ResponseDTO> handleNonExistingID(CustomException exception) {
        ResponseDTO responseDTO = new ResponseDTO("Exception while parsing Rest request", exception.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}