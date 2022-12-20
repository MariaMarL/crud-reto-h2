package com.example.crudh2reto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cuenta_id")
    @JsonBackReference
    private CuentaEntity cuenta;

    private Long fkCuentaId;
}