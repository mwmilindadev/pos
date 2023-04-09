package com.springbootacadamy.pos.controller;

import com.springbootacadamy.pos.dto.CustomarDTO;
import com.springbootacadamy.pos.dto.paginated.CustomarPeginatedDTO;
import com.springbootacadamy.pos.dto.request.CustomarUpdateDTO;
import com.springbootacadamy.pos.servise.CustomarServise;
import com.springbootacadamy.pos.util.StandardRespons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("api/v1/customar")
@CrossOrigin
public class CustomarController {

    @Autowired
    private CustomarServise customarServise;

  @PostMapping("/save")
//    public String saveCustomar(@RequestBody CustomarDTO customarDTO){
//        //String message=customarDTO.getCustomarName();
//        customarServise.saveCustomar(customarDTO);
//        return "save";
//    }

  public ResponseEntity<StandardRespons> saveCustomar(@RequestBody CustomarDTO customarDTO){
      //String message=customarDTO.getCustomarName();
      String message=customarServise.saveCustomar(customarDTO);
      return new ResponseEntity<StandardRespons>(
              new StandardRespons(200,"Saved", message),
              HttpStatus.CREATED);
  }

    @PutMapping("/update")
//    public String updateCustomar(@RequestBody CustomarUpdateDTO customarUpdateDTO){
//      String message=customarServise.updateCustomar(customarUpdateDTO);
//        return message;
//    }

    public ResponseEntity<StandardRespons> updateCustomar(@RequestBody CustomarUpdateDTO customarUpdateDTO){
      String message=customarServise.updateCustomar(customarUpdateDTO);
        return new ResponseEntity<StandardRespons>(
                new StandardRespons(200,"Updated",message)
                ,HttpStatus.CREATED);
   }

    @GetMapping(path="get-by-id",params = "id")
//    public CustomarDTO getCustomarById(@RequestParam(value = "id") int customarId){
//        CustomarDTO customarDTO= customarServise.getCustomarById(customarId);
//
//      return customarDTO;
//    }
    public ResponseEntity<StandardRespons> getCustomarById(@RequestParam(value = "id") int customarId){
        CustomarDTO customarDTO= customarServise.getCustomarById(customarId);

        return new ResponseEntity<StandardRespons>
                (new StandardRespons(200,"Found",customarDTO)
                        ,HttpStatus.OK);
    }

    @GetMapping(path="/get-all-customars")
//    public List<CustomarDTO> getAllCustomars(){
//      List<CustomarDTO> customarDTOList=customarServise.getAllCustomars();
//      return customarDTOList;
//
//    }
    public ResponseEntity<StandardRespons> getAllCustomars(){
        List<CustomarDTO> customarDTOList=customarServise.getAllCustomars();
        return new ResponseEntity<StandardRespons>(
                new StandardRespons(200,"Found List",customarDTOList)
                ,HttpStatus.OK);

    }

    @DeleteMapping(path = "/delete-customar/{id}")
//    public String deleteCustomarById(@PathVariable(value = "id") int customarId){
//      String deleteCustomar=customarServise.deleteCustomarById(customarId);
//      return deleteCustomar;
//    }
    public ResponseEntity<StandardRespons> deleteCustomarById(@PathVariable(value = "id") int customarId){
        String deleteCustomar=customarServise.deleteCustomarById(customarId);
        return new ResponseEntity<StandardRespons>(
                new StandardRespons(200,"OK",deleteCustomar),
                HttpStatus.OK);
    }

    @GetMapping(
            path = {"/get-all-cusromars-by-active-state"},
            params = {"status"})
//  public List<CustomarDTO>getAllCustomarsByActiveState(@RequestParam(value = "status") boolean status){
//    List<CustomarDTO> customarDTOList = customarServise.getAllCustomarsByActiveState(status);
//   return  customarDTOList;
//    }

    public ResponseEntity<StandardRespons> getAllCustomarsByActiveState(@RequestParam(value = "status") boolean status){
        List<CustomarDTO> customarDTOList = customarServise.getAllCustomarsByActiveState(status);
        return  new ResponseEntity<>(
                new StandardRespons(200,"ok",customarDTOList)
                ,HttpStatus.OK);
    }


    @GetMapping(path = "get-all-active-customars/{status}")
//    public List<CustomarDTO> getAllCustomarsWithActive(@PathVariable (value = "status") boolean activeStatus){
////        List<CustomarDTO> customarDTOList=customarServise.getAllCustomarsByActiveState(activeStatus);
////        return customarDTOList;
////    }

    public ResponseEntity<StandardRespons> getAllCustomarsWithActive(@PathVariable (value = "status") boolean activeStatus){
        List<CustomarDTO> customarDTOList=customarServise.getAllCustomarsByActiveState(activeStatus);
        return new ResponseEntity<>(
                new StandardRespons(200,"OK",customarDTOList),
                HttpStatus.OK);
    }

    @GetMapping(path = {"/get-all-customats-with-activestate-and-id"},
            params = {"status","id"}
    )

//    public List<CustomarDTO> getAllCustomarsWithActiveStateAndId(@RequestParam(value = "status") boolean activeStatus,@RequestParam (value = "id") int customarId){
//    List<CustomarDTO> customarDTOList=customarServise.getAllCustomarsWithActiveStateAndId(activeStatus,customarId);
//    return customarDTOList;
//    }
    public ResponseEntity<StandardRespons> getAllCustomarsWithActiveStateAndId(@RequestParam(value = "status") boolean activeStatus,@RequestParam (value = "id") int customarId){
        List<CustomarDTO> customarDTOList=customarServise.getAllCustomarsWithActiveStateAndId(activeStatus,customarId);
        return new ResponseEntity<StandardRespons>(
                new StandardRespons(200,"OK",customarDTOList)
        ,HttpStatus.OK);
    }


    @GetMapping(path = "/get-customar-with-ctivestatus",
    params = {"status","page","size"})

    public ResponseEntity<StandardRespons>getAllCustomarsWithActiveStatus(
            @RequestParam(value = "status") boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size")@Max(50)  int size

    ){
        CustomarPeginatedDTO customarPeginatedDTO=customarServise.getAllActiveCustomarsWithSatus(activeStatus,page,size);
        return new ResponseEntity<StandardRespons>(
                new StandardRespons(200,"OK",customarPeginatedDTO),
                HttpStatus.OK);

    }

}
