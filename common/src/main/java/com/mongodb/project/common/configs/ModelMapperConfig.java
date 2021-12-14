package com.mongodb.project.common.configs;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}


//Tam eşleştirme sağlar, DTO'daki Field'lara karşılık gelen Entity Employee
//Nesnemizdeki birebir örtüşen alanlar eşleştirilir. - STRICT ile.