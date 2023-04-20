package com.springbootacadamy.pos.controller;

import com.springbootacadamy.pos.dto.paginated.OrderDetailsPaginatedDTO;
import com.springbootacadamy.pos.dto.request.RequestOrderSaveDTO;
import com.springbootacadamy.pos.servise.OrderServise;
import com.springbootacadamy.pos.util.StandardRespons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

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
        return new ResponseEntity<StandardRespons>(new StandardRespons(200,"ok",message), HttpStatus.CREATED);
    }

    @GetMapping(params = {"stateType","page","size"},
                path = "/get-order-details")

    public ResponseEntity<StandardRespons>getAllOrderDetails(
            @RequestParam(value = "stateType") String stateType,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "size")@Max(50)int size
    ) {
        OrderDetailsPaginatedDTO p = null;
        if (stateType.equalsIgnoreCase("active") || stateType.equalsIgnoreCase("inactive")) {
            boolean b = stateType.equalsIgnoreCase("active") ? true : false;
            p = orderServise.getAllOrderDetails(b, page, size);


        }
        return new ResponseEntity<StandardRespons>(new StandardRespons(200, "OK", p), HttpStatus.OK);

    }




}
