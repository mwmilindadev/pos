package com.springbootacadamy.pos.servise.impl;

import com.springbootacadamy.pos.dto.request.RequestOrderSaveDTO;
import com.springbootacadamy.pos.entity.OrderDetais;
import com.springbootacadamy.pos.entity.Orders;
import com.springbootacadamy.pos.repo.CustomarRepo;
import com.springbootacadamy.pos.repo.ItemRepo;
import com.springbootacadamy.pos.repo.OrderDetailsRepo;
import com.springbootacadamy.pos.repo.OrderRepo;
import com.springbootacadamy.pos.servise.OrderServise;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiseImpl implements OrderServise {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private CustomarRepo customarRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Orders orders= new Orders(
                customarRepo.getReferenceById(requestOrderSaveDTO.getCustomar()),
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotal()
        );
        orderRepo.save(orders);
        if(orderRepo.existsById(orders.getOrderId())){
            List<OrderDetais> orderDetaisList=modelMapper.
                                              map(requestOrderSaveDTO.getOrerDetails(), new TypeToken<List<OrderDetais>>(){}.getType());
            for (int i=0;i<orderDetaisList.size();i++){
                orderDetaisList.get(i).setOrders(orders);
                orderDetaisList.get(i).setItems(itemRepo.getReferenceById(requestOrderSaveDTO.getOrerDetails().get(i).getItems()));

            }

            if(orderDetaisList.size()>0){
                orderDetailsRepo.saveAll(orderDetaisList);
            }
            return "Saved";
        }
       return null;
    }
}
