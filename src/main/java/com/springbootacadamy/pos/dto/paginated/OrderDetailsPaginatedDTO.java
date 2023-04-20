package com.springbootacadamy.pos.dto.paginated;

import com.springbootacadamy.pos.dto.response.ResponseOrderDtailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailsPaginatedDTO {
    List<ResponseOrderDtailsDTO> list;
    private  Long count;
}
