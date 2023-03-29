package com.springbootacadamy.pos.servise.impl;

import com.springbootacadamy.pos.dto.ItemDTO;
import com.springbootacadamy.pos.dto.request.ItemUpdateDTO;
import com.springbootacadamy.pos.entity.Item;
import com.springbootacadamy.pos.repo.ItemRepo;
import com.springbootacadamy.pos.servise.ItemSerivse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiseImpl implements ItemSerivse {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public String saveItem(ItemDTO itemDTO) {

        Item item = modelMapper.map(itemDTO,Item.class);
        itemRepo.save(item);
        return "Item Saved." + itemDTO.getItemName();
    }

    @Override
    public ItemDTO getItemById(int itemId) {
        if(itemRepo.existsById(itemId)){
           Item item = itemRepo.getReferenceById(itemId) ;
           ItemDTO itemDTO=modelMapper.map(item,ItemDTO.class);
           return  itemDTO;
        }else {
            throw new RuntimeException("No data found");
        }

    }

    @Override
    public String itemUpdate(ItemUpdateDTO itemUpdateDTO) {
        if(itemRepo.existsById(itemUpdateDTO.getId())){
            Item item = modelMapper.map(itemUpdateDTO,Item.class);
            itemRepo.save(item);

            return  itemUpdateDTO.getId()+" Updated";
        }else {
            throw new RuntimeException("no data found");
        }

    }
}
