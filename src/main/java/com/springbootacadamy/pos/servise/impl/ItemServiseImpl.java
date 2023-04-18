package com.springbootacadamy.pos.servise.impl;

import com.springbootacadamy.pos.dto.ItemDTO;
import com.springbootacadamy.pos.dto.paginated.ItemPaginatedDTO;
import com.springbootacadamy.pos.dto.request.ItemUpdateDTO;
import com.springbootacadamy.pos.dto.response.ItemDTOResponse;
import com.springbootacadamy.pos.entity.Item;
import com.springbootacadamy.pos.repo.ItemRepo;
import com.springbootacadamy.pos.servise.ItemSerivse;
import com.springbootacadamy.pos.util.mapper.ItemMapper;
import exception.DuplicateFoundException;
import exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiseImpl implements ItemSerivse {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;
    @Override
    public String saveItem(ItemDTO itemDTO) {

        Item item = modelMapper.map(itemDTO,Item.class);
       // Item item1 = itemMapper.dtoToItem(itemDTO);//mapstruct
        if(!itemRepo.existsById(item.getId())) {
            itemRepo.save(item);
            return "Item Saved." + itemDTO.getItemName();
        }else{
//            throw new DuplicateKeyException("Already Added");
            throw new DuplicateFoundException("Already Found");
        }

    }

    @Override
    public ItemDTO getItemById(int itemId) {
        if(itemRepo.existsById(itemId)){
           Item item = itemRepo.getReferenceById(itemId) ;
           //using model mapper
           ItemDTO itemDTO=modelMapper.map(item,ItemDTO.class);
           return  itemDTO;
        }else {
            throw new NotFoundException("No Data");
        }

    }

    @Override
    public String itemUpdate(ItemUpdateDTO itemUpdateDTO) {
        if(itemRepo.existsById(itemUpdateDTO.getId())){
            Item item = modelMapper.map(itemUpdateDTO,Item.class);
            itemRepo.save(item);

            return  itemUpdateDTO.getId()+" Updated";
        }else {
            throw new NotFoundException("no data found");
        }

    }

    @Override
    public List<ItemDTOResponse> getItemByName(String itemName) {
        List<Item>items=itemRepo.findAllByItemNameEqualsAndActiveStatus(itemName,true);
        if(items.size()>0){
          List<ItemDTOResponse>  itemDTOResponseList=modelMapper.map(items,new TypeToken<List<ItemDTOResponse>>(){}.getType());
            return itemDTOResponseList;
        }else{
            throw new RuntimeException("Item is not Active");
            }
        }

    @Override
    public List<ItemDTOResponse> getItemByNameMapstruct(String itemName) {
        List<Item>items=itemRepo.findAllByItemNameEqualsAndActiveStatus(itemName,true);
        if(items.size()>0){
            List<ItemDTOResponse>  itemDTOResponseList=itemMapper.entityListToDtoList(items);
            return itemDTOResponseList;
        }else{
            throw new RuntimeException("Item is not Active");
        }
    }

    @Override
    public ItemDTOResponse getItemByIdMapstruct(int itemId) {
        if(itemRepo.existsById(itemId)){
            Item item=itemRepo.getReferenceById(itemId);
            ItemDTOResponse itemDTOResponse=itemMapper.itemToDto(item);
            return  itemDTOResponse;
        }else{
            throw new NotFoundException("Item Not Found");
        }

    }

    @Override
    public List<ItemDTOResponse> getItemsByActiveStatu(boolean activeStatus, int page, int size) {
        return null;
    }

    @Override
    public ItemPaginatedDTO getItemsByActiveStatusPaginated(boolean activeStatus, int page, int size) {

        Page<Item>itemPage=itemRepo.findAllByActiveStatusEquals(activeStatus,PageRequest.of(page,size));
        if(itemPage.getSize()<1){
            throw new NotFoundException("No Data");

        }
//        List<ItemDTOResponse> itemDTOResponseList= modelMapper.map(itemPage,new TypeToken<List<ItemDTOResponse>>(){}.getType());
//        ItemPaginatedDTO itemPaginatedDTO= new ItemPaginatedDTO(
//                itemDTOResponseList,
//                2L
//
//        );
         //size with manual
//        ItemPaginatedDTO itemPaginatedDTO= new ItemPaginatedDTO(
//                itemMapper.listDtoToPage(itemPage),
//                2L
//
//        );
        //size with getcount using repo
        ItemPaginatedDTO itemPaginatedDTO= new ItemPaginatedDTO(
                itemMapper.listDtoToPage(itemPage),
                itemRepo.countAllByActiveStatusEquals(activeStatus)

        );


        return itemPaginatedDTO;
    }

    @Override
    public ItemPaginatedDTO getAllItemByPeginated(int page, int size) {
        Page<Item>itemPage=itemRepo.findAll(PageRequest.of(page, size));
        if(itemPage.getSize()<1){
           throw new NotFoundException("NoData");
        }

        ItemPaginatedDTO itemPaginatedDTO = new ItemPaginatedDTO(
           itemMapper.listDtoToPage(itemPage),
           itemRepo.count()
        );
        return itemPaginatedDTO;
    }

}



