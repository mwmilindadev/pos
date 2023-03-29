package com.springbootacadamy.pos.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }
}
