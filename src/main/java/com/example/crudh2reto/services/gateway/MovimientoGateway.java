package com.example.crudh2reto.services.gateway;

import com.example.crudh2reto.model.MovimientoEntity;

import java.util.List;

public interface MovimientoGateway {

    List<MovimientoEntity> listarMovimientos();

    MovimientoEntity obtenerMovimientoPorId(Integer id);

    MovimientoEntity crearMovimiento(MovimientoEntity Movimiento);

    void eliminarMovimiento(Integer id);

    Boolean existMovimientoByid(Integer id);

    MovimientoEntity actualizarMovimiento(MovimientoEntity Movimiento);
}
