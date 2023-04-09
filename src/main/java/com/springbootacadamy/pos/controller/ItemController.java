package com.springbootacadamy.pos.controller;

import com.springbootacadamy.pos.dto.ItemDTO;
import com.springbootacadamy.pos.dto.paginated.ItemPaginatedDTO;
import com.springbootacadamy.pos.dto.request.ItemUpdateDTO;
import com.springbootacadamy.pos.dto.response.ItemDTOResponse;
import com.springbootacadamy.pos.servise.ItemSerivse;
import com.springbootacadamy.pos.util.StandardRespons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("api/vi/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemSerivse itemSerivse;

    @PostMapping("/save")
//    public String saveItem(@RequestBody ItemDTO itemDTO){
//
//        String message= itemSerivse.saveItem(itemDTO);
//        return message;
//
//    }

    public ResponseEntity<StandardRespons> saveItem(@RequestBody ItemDTO itemDTO) {

        String message = itemSerivse.saveItem(itemDTO);
        return new ResponseEntity<StandardRespons>(new StandardRespons(200, "Saved", message), HttpStatus.CREATED);

    }

    @GetMapping(path = "/get-item-by-id",
            params = {"id"})
//    public ItemDTO itemDTO(@RequestParam(value = "id")int itemId){
//     ItemDTO itemDTO = itemSerivse.getItemById(itemId);
//     return  itemDTO;
//    }

    public ResponseEntity<StandardRespons> itemDTO(@RequestParam(value = "id") int itemId) {
        ItemDTO itemDTO = itemSerivse.getItemById(itemId);
        return new ResponseEntity<StandardRespons>(new StandardRespons(200, "OK", itemDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/get-item-by-id-mapstruct",
            params = "id")

//    public ItemDTOResponse getItemByIdMapstruct(@RequestParam(name = "id") int itemId) {
//        ItemDTOResponse itemDTOResponse = itemSerivse.getItemByIdMapstruct(itemId);
//        return itemDTOResponse;
//
//
//    }

    public ResponseEntity<StandardRespons> getItemByIdMapstruct(@RequestParam(name = "id") int itemId) {
        ItemDTOResponse itemDTOResponse = itemSerivse.getItemByIdMapstruct(itemId);
        return new ResponseEntity<StandardRespons>(
                new StandardRespons(200,"OK",itemDTOResponse),HttpStatus.OK);


    }

    @PutMapping("/update")
//    public String updateItem(@RequestBody ItemUpdateDTO itemUpdateDTO){
//        String message=itemSerivse.itemUpdate(itemUpdateDTO);
//
//        return message;
//    }

    public ResponseEntity<StandardRespons> updateItem(@RequestBody ItemUpdateDTO itemUpdateDTO) {
        String message = itemSerivse.itemUpdate(itemUpdateDTO);

        return new ResponseEntity<StandardRespons>(new StandardRespons(200, "Updated", message), HttpStatus.OK);
    }

    @GetMapping(path = "/get-item-by-name-with-active-status",
            params = "name")
//    public List<ItemDTOResponse> getItemByName(@RequestParam(value = "name") String itemName){
//        List<ItemDTOResponse> itemDTOList=itemSerivse.getItemByName(itemName);
//        return itemDTOList;

    public ResponseEntity<StandardRespons> getItemByName(@RequestParam(value = "name") String itemName) {
        List<ItemDTOResponse> itemDTOList = itemSerivse.getItemByName(itemName);
        return new ResponseEntity<StandardRespons>(new StandardRespons(200, "ok", itemDTOList), HttpStatus.OK);


    }

    @GetMapping(path = "/get-item-by-name-mapstructs",
            params = "name")
//    public  List<ItemDTOResponse>  getItemByNameMapstruct(@RequestParam(value = "name") String ItemName) {
//        List<ItemDTOResponse> itemDTOResponseList = itemSerivse.getItemByNameMapstruct(ItemName);
//        return itemDTOResponseList;
//    }

    public ResponseEntity<StandardRespons> getItemByNameMapstruct(@RequestParam(value = "name") String ItemName) {
        List<ItemDTOResponse> itemDTOResponseList = itemSerivse.getItemByNameMapstruct(ItemName);
        return new ResponseEntity<StandardRespons>(new StandardRespons(200, "ok", itemDTOResponseList), HttpStatus.OK);
    }

    @GetMapping(path = "/get-atems-by-activeStatus",
    params = {"activeStatus","page","size"})
    public ResponseEntity<StandardRespons>getItemsByactiveTatusPaginated(
            @RequestParam(value = "activeStatus") boolean activeStatus,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "size") @Max(50) int size
    ){
        //List<ItemDTOResponse>itemDTOResponseList=itemSerivse.getItemsByActiveStatu(activeStatus,page,size);
        ItemPaginatedDTO itemPaginatedDTO=itemSerivse.getItemsByActiveStatusPaginated(activeStatus,page,size);

        return new ResponseEntity<StandardRespons>(
                new StandardRespons(200,"Success",itemPaginatedDTO),HttpStatus.OK);
    }

}
