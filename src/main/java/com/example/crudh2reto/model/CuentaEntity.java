package com.example.crudh2reto.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "cuenta")
@Data
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cuenta_id")
    private Integer cuentaId;

    private Long numeroDeCuenta;

    private String tipoDeCuenta;

    private Double saldoInicial;

    private String estadoCuenta;
}
