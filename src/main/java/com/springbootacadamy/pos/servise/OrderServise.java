package com.springbootacadamy.pos.servise;

import com.springbootacadamy.pos.dto.paginated.OrderDetailsPaginatedDTO;
import com.springbootacadamy.pos.dto.request.RequestOrderSaveDTO;

public interface OrderServise {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);

    OrderDetailsPaginatedDTO getAllOrderDetails(boolean b, int page, int size);
}
