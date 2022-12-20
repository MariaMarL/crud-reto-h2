package com.example.crudh2reto.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
@Data
public class ClienteEntity extends PersonaEntity{

    public ClienteEntity(String nombre, String genero,
                         Integer edad, Long identificacion,
                         String direccion, Long telefono,
                         Integer clienteId, String contrasena,
                         Boolean estado) {
        super(nombre, genero, edad, identificacion, direccion, telefono);
        this.clienteId = clienteId;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public ClienteEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer clienteId;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private Boolean estado;

    //@OneToMany(mappedBy = "cliente")
    //@JsonManagedReference
    ///private List<CuentaEntity> cuentas;

}
