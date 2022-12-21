package com.example.crudh2reto.config;

import com.example.crudh2reto.utils.validaciones.Validaciones;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public Validaciones instanciarValidaciones(){
        return new Validaciones();
    }
}
