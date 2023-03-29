package com.springbootacadamy.pos.dto.request;

import com.springbootacadamy.pos.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemUpdateDTO {
    private int id;
    private String itemName;
    private MeasuringUnitType measuringType;
    private double balanceQty;
    private double supplierPrice;
    private String sellingPrice;

}
