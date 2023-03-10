package com.example.crudh2reto.utils.validaciones;

import org.hibernate.HibernateException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Validaciones {

    public Boolean validarGenero(String genero){
        return genero.equalsIgnoreCase("FEMENINO") ||
                genero.equalsIgnoreCase("MASCULINO");
    }

    public Boolean validarTipoDeCuenta(String tipo){
        if(tipo.equalsIgnoreCase("Ahorros") ||
                tipo.equalsIgnoreCase("Corriente")){
            return true;
        }
        return false;
    }
}
