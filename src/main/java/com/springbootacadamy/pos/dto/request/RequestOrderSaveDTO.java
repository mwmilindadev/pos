package com.springbootacadamy.pos.dto.request;

import com.springbootacadamy.pos.entity.OrderDetais;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderSaveDTO {

    private int customar;
    private Date date;
    private Double total;
    private List<RequestOrderDetailsSaveDTO> orerDetails;
}
