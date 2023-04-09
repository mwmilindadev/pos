package com.springbootacadamy.pos.dto.paginated;

import com.springbootacadamy.pos.dto.response.CustomarResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomarPeginatedDTO {
    List<CustomarResponseDTO> list;
    private long count;

}
