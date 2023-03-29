package com.springbootacadamy.pos.servise.impl;

import com.springbootacadamy.pos.dto.CustomarDTO;
import com.springbootacadamy.pos.dto.request.CustomarUpdateDTO;
import com.springbootacadamy.pos.entity.Customar;
import com.springbootacadamy.pos.repo.CustomarRepo;
import com.springbootacadamy.pos.servise.CustomarServise;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomarServiseImpl implements CustomarServise {

    @Autowired
    private CustomarRepo customarRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveCustomar(CustomarDTO customarDTO) {

        Customar customar = modelMapper.map(customarDTO,Customar.class);

        System.out.println(customarDTO.getCustomarAdderess());
        //Old Structure[values assign to all args contructor]
//        Customar customar = new Customar(customarDTO.getCustomarId(),
//        customarDTO.getCustomarName(),
//        customarDTO.getCustomarAdderess(),
//        customarDTO.getCustomarSalary(),
//        customarDTO.getContactNumbers(),
//        customarDTO.getNic(),
//        customarDTO.isActiveStatus()
//
//        );
        customarRepo.save(customar);
        return customarDTO.getCustomarName();
    }

    @Override
    public String updateCustomar(CustomarUpdateDTO customarUpdateDTO) {

        if(customarRepo.existsById(customarUpdateDTO.getCustomarId())){

            Customar customar= modelMapper.map(customarUpdateDTO,Customar.class);
            //Old Structure[values assign to all args contructor]
//            Customar customar = customarRepo.getReferenceById(customarUpdateDTO.getCustomarId());
//                  customar.setCustomarName(customarUpdateDTO.getCustomarName());
//                  customar.setCustomarAdderess(customarUpdateDTO.getCustomarAdderess());
//                  customar.setCustomarSalary(customarUpdateDTO.getCustomarSalary());
                  customarRepo.save(customar);
            return customarUpdateDTO.getCustomarName()+ " Successfully Updated!";
        }else{
            throw new RuntimeException("not found");
        }

    }

    @Override
    public CustomarDTO getCustomarById(int customarId) {
        if(customarRepo.existsById(customarId)){
            Customar customar=customarRepo.getReferenceById(customarId);
            CustomarDTO customarDTO = modelMapper.map(customar,CustomarDTO.class);
            //Old Structure[values assign to all args contructor]
//            CustomarDTO customarDTO = new CustomarDTO(customar.getCustomarId(),
//                    customar.getCustomarName(),
//                    customar.getCustomarAdderess(),
//                    customar.getCustomarSalary(),
//                    customar.getContactNumbers(),
//                    customar.getNic(),
//                    customar.isActiveStatus()
//
//            );


            return customarDTO;
        }else{
            throw new RuntimeException("No Customar");
        }

    }

    @Override
    public List<CustomarDTO> getAllCustomars() {
        List<Customar>getAllCustomars=customarRepo.findAll();

        if(getAllCustomars.size()>0) {
            List<CustomarDTO> customarDTOList= new ArrayList<>();
            for (Customar customar : getAllCustomars) {
                CustomarDTO customarDTO = new CustomarDTO(customar.getCustomarId(),
                        customar.getCustomarName(),
                        customar.getCustomarAdderess(),
                        customar.getCustomarSalary(),
                        customar.getContactNumbers(),
                        customar.getNic(),
                        customar.isActiveStatus());
                customarDTOList.add(customarDTO);
            }

        return customarDTOList;
        }else {
            throw new RuntimeException("No Data");
        }
    }

    @Override
    public String deleteCustomarById(int customarId) {
        if(customarRepo.existsById(customarId)){

            customarRepo.deleteById(customarId);
            return "Deleted Success"+ customarId;
        }
        else{
            throw new RuntimeException("Customa Not Found");
        }

    }

    @Override
    public List<CustomarDTO> getAllCustomarsByActiveState(boolean status) {
        List<Customar> customarList = customarRepo.findAllByActiveStatusEquals(status);
        if (customarList.size()>0){
            List<CustomarDTO>customarDTOList = new ArrayList<>();
            for (Customar customar:customarList){
                CustomarDTO customarDTO = new CustomarDTO(customar.getCustomarId(),
                        customar.getCustomarName(),
                        customar.getCustomarAdderess(),
                        customar.getCustomarSalary(),
                        customar.getContactNumbers(),
                        customar.getNic(),
                        customar.isActiveStatus());
                customarDTOList.add(customarDTO);
            }
           return customarDTOList;
        }else {
            throw new RuntimeException("No data Found");
        }

    }

    @Override
    public List<CustomarDTO> getAllCustomarsWithActiveStateAndId(boolean activeStatus, int customarId) {
       List<Customar>customarList =customarRepo.findAllByActiveStatusEqualsAndCustomarIdEquals(activeStatus,customarId);

       if(customarList.size()>0) {
           List<CustomarDTO> customarDTOList = new ArrayList<>();
           for (Customar customar : customarList) {
               CustomarDTO customarDTO = new CustomarDTO(customar.getCustomarId(),
                       customar.getCustomarName(),
                       customar.getCustomarAdderess(),
                       customar.getCustomarSalary(),
                       customar.getContactNumbers(),
                       customar.getNic(),
                       customar.isActiveStatus());
               customarDTOList.add(customarDTO);

           }
           return customarDTOList;
       }else {
           throw new RuntimeException("No data");
       }

    }


}
