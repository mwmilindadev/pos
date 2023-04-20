package com.springbootacadamy.pos.dto.queryinterface;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailsInterface {

     String getCustomarName();
     String getCustomarAdderess();
     ArrayList getContactNumbers();

     Date getDate();
     Double getTotal();
}
