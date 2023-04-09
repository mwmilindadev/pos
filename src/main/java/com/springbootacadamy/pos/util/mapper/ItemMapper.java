package com.springbootacadamy.pos.util.mapper;

import com.springbootacadamy.pos.dto.ItemDTO;
import com.springbootacadamy.pos.dto.response.ItemDTOResponse;
import com.springbootacadamy.pos.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemDTOResponse> entityListToDtoList(List<Item> itemList);
    ItemDTOResponse itemToDto(Item item);

    Item dtoToItem(ItemDTO itemDTO);

    List<ItemDTOResponse> listDtoToPage(Page<Item> itemPage);

}
