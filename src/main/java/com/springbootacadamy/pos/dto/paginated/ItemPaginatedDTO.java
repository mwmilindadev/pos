package com.springbootacadamy.pos.dto.paginated;

import com.springbootacadamy.pos.dto.response.ItemDTOResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemPaginatedDTO {
    List<ItemDTOResponse> list;
    private Long COUNT;
}
