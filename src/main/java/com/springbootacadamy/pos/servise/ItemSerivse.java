package com.springbootacadamy.pos.servise;

import com.springbootacadamy.pos.dto.ItemDTO;
import com.springbootacadamy.pos.dto.request.ItemUpdateDTO;

public interface ItemSerivse {
    String saveItem(ItemDTO itemDTO);

    ItemDTO getItemById(int itemId);

    String itemUpdate(ItemUpdateDTO itemUpdateDTO);
}
