package com.springbootacadamy.pos.servise;

import com.springbootacadamy.pos.dto.ItemDTO;
import com.springbootacadamy.pos.dto.paginated.ItemPaginatedDTO;
import com.springbootacadamy.pos.dto.request.ItemUpdateDTO;
import com.springbootacadamy.pos.dto.response.ItemDTOResponse;

import java.util.List;

public interface ItemSerivse {
    String saveItem(ItemDTO itemDTO);

    ItemDTO getItemById(int itemId);

    String itemUpdate(ItemUpdateDTO itemUpdateDTO);


    List<ItemDTOResponse> getItemByName(String itemName);



    List<ItemDTOResponse> getItemByNameMapstruct(String itemName);

    ItemDTOResponse getItemByIdMapstruct(int itemId);

    List<ItemDTOResponse> getItemsByActiveStatu(boolean activeStatus, int page, int size);

    ItemPaginatedDTO getItemsByActiveStatusPaginated(boolean activeStatus, int page, int size);
}
