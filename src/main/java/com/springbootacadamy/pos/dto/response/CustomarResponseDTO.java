package com.springbootacadamy.pos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomarResponseDTO {

    private int customarId;
    private String customarName;
    private String customarAdderess;
    private double customarSalary;
    private ArrayList contactNumbers;
    private String nic;
}
