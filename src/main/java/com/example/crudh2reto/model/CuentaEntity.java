package com.example.crudh2reto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "cuenta")
    @JsonManagedReference
    private List<MovimientoEntity> movimientos = new ArrayList<>();
    //private MovimientoEntity movimiento

    //private Long fkClienteId;
}
