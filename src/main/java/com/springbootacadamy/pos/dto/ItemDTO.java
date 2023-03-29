package com.springbootacadamy.pos.dto;

import com.springbootacadamy.pos.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {
    private int id;
    private String itemName;
    private MeasuringUnitType measuringType;
    private double balanceQty;
    private double supplierPrice;
    private String sellingPrice;
    private boolean activeStatus;
}
