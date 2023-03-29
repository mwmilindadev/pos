package com.springbootacadamy.pos.controller;

import com.springbootacadamy.pos.dto.CustomarDTO;
import com.springbootacadamy.pos.dto.request.CustomarUpdateDTO;
import com.springbootacadamy.pos.servise.CustomarServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customar")
@CrossOrigin
public class CustomarController {

    @Autowired
    private CustomarServise customarServise;

  @PostMapping("/save")
    public String saveCustomar(@RequestBody CustomarDTO customarDTO){
        //String message=customarDTO.getCustomarName();
        customarServise.saveCustomar(customarDTO);
        return "save";
    }

    @PutMapping("/update")
    public String updateCustomar(@RequestBody CustomarUpdateDTO customarUpdateDTO){
      String message=customarServise.updateCustomar(customarUpdateDTO);
        return message;
    }

    @GetMapping(path="get-by-id",params = "id")
    public CustomarDTO getCustomarById(@RequestParam(value = "id") int customarId){
        CustomarDTO customarDTO= customarServise.getCustomarById(customarId);

      return customarDTO;
    }

    @GetMapping(path="/get-all-customars")
    public List<CustomarDTO> getAllCustomars(){
      List<CustomarDTO> customarDTOList=customarServise.getAllCustomars();
      return customarDTOList;

    }

    @DeleteMapping(path = "/delete-customar/{id}")
    public String deleteCustomarById(@PathVariable(value = "id") int customarId){
      String deleteCustomar=customarServise.deleteCustomarById(customarId);
      return deleteCustomar;
    }

    @GetMapping(
            path = {"/get-all-cusromars-by-active-state"},
            params = {"status"})
  public List<CustomarDTO>getAllCustomarsByActiveState(@RequestParam(value = "status") boolean status){
    List<CustomarDTO> customarDTOList = customarServise.getAllCustomarsByActiveState(status);
   return  customarDTOList;
    }


    @GetMapping(path = "get-all-active-customars/{status}")
    public List<CustomarDTO> getAllCustomarsWithActive(@PathVariable (value = "status") boolean activeStatus){
        List<CustomarDTO> customarDTOList=customarServise.getAllCustomarsByActiveState(activeStatus);
        return customarDTOList;
    }

    @GetMapping(path = {"/get-all-customats-with-activestate-and-id"},
            params = {"status","id"}
    )

    public List<CustomarDTO> getAllCustomarsWithActiveStateAndId(@RequestParam(value = "status") boolean activeStatus,@RequestParam (value = "id") int customarId){
    List<CustomarDTO> customarDTOList=customarServise.getAllCustomarsWithActiveStateAndId(activeStatus,customarId);
    return customarDTOList;
    }


}
