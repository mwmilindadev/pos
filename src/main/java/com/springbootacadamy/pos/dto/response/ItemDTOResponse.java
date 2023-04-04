package com.springbootacadamy.pos.dto.response;

import com.springbootacadamy.pos.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTOResponse {
    private int id;
    private String itemName;
    private double balanceQty;
    private double supplierPrice;
    private String sellingPrice;
    private boolean activeStatus;
}
