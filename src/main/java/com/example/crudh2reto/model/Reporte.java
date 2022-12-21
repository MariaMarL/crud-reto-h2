package com.example.crudh2reto.model;

import java.sql.Date;
import java.util.List;

public class Reporte {

    private Date fecha;

    private String cliente;

    private Integer numeroDeCuenta;

    private List<MovimientoEntity> movimientos;
}
