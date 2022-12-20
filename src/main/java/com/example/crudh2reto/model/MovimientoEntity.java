package com.example.crudh2reto.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "movimientos")
@Data
public class MovimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movimiento_id")
    private Integer movimientoId;

    private String fecha;

    private String tipoDeMovimiento;

    private Double valor;

    private Double saldo;

}
