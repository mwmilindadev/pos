package com.springbootacadamy.pos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseOrderDtailsDTO {

    private String customarName;
    private String customarAdderess;
    private ArrayList contactNumbers;

    private Date date;
    private Double total;
}
