package com.springbootacadamy.pos.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
@Data
@TypeDefs(
        @TypeDef(name = "json",typeClass = JsonType.class)
)
public class OrderDetais {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_details_id")
    private int orderDetailsId;

    @Column(name="item_name",length = 500,nullable = false)
    private String itemName;

    @Column(name = "qty",length = 100,nullable = false)
    private double qty;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item items;

}
