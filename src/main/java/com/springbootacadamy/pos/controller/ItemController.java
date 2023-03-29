package com.springbootacadamy.pos.controller;

import com.springbootacadamy.pos.dto.ItemDTO;
import com.springbootacadamy.pos.dto.request.ItemUpdateDTO;
import com.springbootacadamy.pos.servise.ItemSerivse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vi/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemSerivse itemSerivse;
    @PostMapping("/save")
    public String saveItem(@RequestBody ItemDTO itemDTO){

        String message= itemSerivse.saveItem(itemDTO);
        return message;

    }

    @GetMapping(path = "/get-item-by-id",
    params = {"id"})
    public ItemDTO itemDTO(@RequestParam(value = "id")int itemId){
     ItemDTO itemDTO = itemSerivse.getItemById(itemId);
     return  itemDTO;
    }

    @PutMapping("/update")
    public String updateItem(@RequestBody ItemUpdateDTO itemUpdateDTO){
        String message=itemSerivse.itemUpdate(itemUpdateDTO);

        return message;
    }


}
