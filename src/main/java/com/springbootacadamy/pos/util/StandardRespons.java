package com.springbootacadamy.pos.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardRespons {
    private int code;
    private String message;
    private  Object data;
}
