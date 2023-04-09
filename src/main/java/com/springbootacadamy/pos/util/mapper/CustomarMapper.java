package com.springbootacadamy.pos.util.mapper;

import com.springbootacadamy.pos.dto.CustomarDTO;
import com.springbootacadamy.pos.dto.response.CustomarResponseDTO;
import com.springbootacadamy.pos.entity.Customar;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomarMapper {
    List<CustomarResponseDTO> listToDtoPage(Page<Customar> customarPage);
    List<CustomarDTO> listToDto(List<Customar> customarList);
}
