package com.springbootacadamy.pos.servise;

import com.springbootacadamy.pos.dto.CustomarDTO;
import com.springbootacadamy.pos.dto.paginated.CustomarPeginatedDTO;
import com.springbootacadamy.pos.dto.request.CustomarUpdateDTO;

import java.util.List;

public interface CustomarServise {

    public String saveCustomar(CustomarDTO customarDTO);

    public String updateCustomar(CustomarUpdateDTO customarUpdateDTO);


    CustomarDTO getCustomarById(int customarId);


    List<CustomarDTO> getAllCustomars();

    String deleteCustomarById(int customarId);

    List<CustomarDTO> getAllCustomarsByActiveState(boolean status);

    List<CustomarDTO> getAllCustomarsWithActiveStateAndId(boolean activeStatus, int customarId);

    CustomarPeginatedDTO getAllActiveCustomarsWithSatus(boolean activeStatus, int page, int size);
}
