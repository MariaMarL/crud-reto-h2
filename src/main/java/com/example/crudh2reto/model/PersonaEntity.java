package com.example.crudh2reto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@MappedSuperclass
public class PersonaEntity {

    public PersonaEntity(String nombre,
                         String genero,
                         Integer edad,
                         Long identificacion,
                         String direccion,
                         Long telefono) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public PersonaEntity() {
    }

   // @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
   // private Integer id;
    private String nombre;

    private String genero;

    private Integer edad;

    private Long identificacion;

    private String direccion;

    private Long telefono;
}
