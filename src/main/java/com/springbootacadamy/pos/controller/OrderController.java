package com.springbootacadamy.pos.controller;

import com.springbootacadamy.pos.dto.request.RequestOrderSaveDTO;
import com.springbootacadamy.pos.servise.OrderServise;
import com.springbootacadamy.pos.util.StandardRespons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderServise orderServise;

    @PutMapping("/save")
    public ResponseEntity<StandardRespons> saevOder(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){
        System.out.println(requestOrderSaveDTO);
        String message=orderServise.addOrder(requestOrderSaveDTO);
        return new ResponseEntity<StandardRespons>(new StandardRespons(200,"ok",message), HttpStatus.OK);
    }
}
