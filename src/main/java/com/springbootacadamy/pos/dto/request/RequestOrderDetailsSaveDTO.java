package com.springbootacadamy.pos.dto.request;

import com.springbootacadamy.pos.entity.Item;
import com.springbootacadamy.pos.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderDetailsSaveDTO {

    private String itemName;
    private double qty;
    private Double amount;
    private int orders;
    private int items;
}
