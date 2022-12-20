package com.example.crudh2reto.services.gateway;

import com.example.crudh2reto.model.CuentaEntity;

import java.util.List;

public interface CuentaGateway {

    List<CuentaEntity> listarCuentas();

    CuentaEntity obtenerCuentaPorId(Integer id);

    CuentaEntity crearCuenta(CuentaEntity Cuenta);

    void eliminarCuenta(Integer id);

    Boolean existCuentaByid(Integer id);

    CuentaEntity actualizarCuenta(CuentaEntity Cuenta);
}
