package com.example.crudh2reto.model;

import lombok.Data;

import java.sql.Date;

@Data
public class ReportOnly {

    //private Date fecha;
//
    //private String cliente;
//
    //private Integer numeroDeCuenta;
//
    //private List<MovimientoEntity> movimientos;

    public Date fecha;
    public String cliente;
    public int numerocuenta;
    public String tipocuenta;
    public Double saldoInicial;
    public String estado;
    public Double movimiento;
    public String saldodisponible;

    @Override
    public String toString() {
        return "ReportOnly{" +
                "fecha=" + fecha +
                ", cliente='" + cliente + '\'' +
                ", numerocuenta=" + numerocuenta +
                ", tipocuenta='" + tipocuenta + '\'' +
                ", saldoInicial=" + saldoInicial +
                ", estado='" + estado + '\'' +
                ", movimiento=" + movimiento +
                ", saldodisponible='" + saldodisponible + '\'' +
                '}';
    }
}
