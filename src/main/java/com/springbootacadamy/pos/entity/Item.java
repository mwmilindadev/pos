package com.springbootacadamy.pos.entity;

import com.springbootacadamy.pos.entity.enums.MeasuringUnitType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="item")
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
public class Item {
    @Id
    @Column(name="item_id",length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="item_name",length = 500,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name="measure_type",length = 500,nullable = false)
    private MeasuringUnitType measuringType;

    @Column(name = "balance_qty",length = 100,nullable = false)
    private double balanceQty;

    @Column(name="supplier_price",length = 100,nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price",length = 50,nullable = false)
    private String sellingPrice;

    @Column(name = "active_status",columnDefinition = "TINYINT default 0")
    private boolean activeStatus;


}
