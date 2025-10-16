package com.practice.springboot.prod_ready_features.prod_ready_features.config;

import com.practice.springboot.prod_ready_features.prod_ready_features.auth.AuditorAwareImplemantation;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAwareImplemantation")
public class AppConfig {

    @Bean
    ModelMapper getMapper(){
        return new ModelMapper();
    }

    @Bean
    AuditorAwareImplemantation getAuditorAwareImplemantation(){
        return new AuditorAwareImplemantation();
    }
}
