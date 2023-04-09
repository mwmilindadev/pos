package com.springbootacadamy.pos.adviser;

import com.springbootacadamy.pos.util.StandardRespons;
import exception.DuplicateFoundException;
import exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdviser {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardRespons> getExceptions(NotFoundException e){
        return new ResponseEntity<StandardRespons>(
                new StandardRespons(404,"Error Comming",e.getMessage())
                , HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(DuplicateFoundException.class)
    public ResponseEntity<StandardRespons>getException(DuplicateFoundException e){
        return new ResponseEntity<StandardRespons>(
                new StandardRespons(207,"Error",e.getMessage()),HttpStatus.OK);

    }
}
