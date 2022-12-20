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

    @NotBlank(message = "Por favor ingrese un numero de cuenta")
    private Long numeroDeCuenta;

    private String tipoDeCuenta;

    @Positive(message = "El saldo de la cuenta no puede ser negativo")
    private Double saldoInicial;


    private String estadoCuenta;
}
