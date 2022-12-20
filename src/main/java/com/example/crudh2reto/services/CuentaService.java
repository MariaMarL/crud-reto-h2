package com.example.crudh2reto.services;

import com.example.crudh2reto.model.CuentaEntity;
import com.example.crudh2reto.services.gateway.CuentaGateway;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CuentaService {

    @Autowired
    private CuentaGateway gateway;

    public List<CuentaEntity> listarCuentas(){
        return gateway.listarCuentas();
    }

    public CuentaEntity obtenerCuentaPorId(Integer id){
        return gateway.obtenerCuentaPorId(id);
    }

    public CuentaEntity crearCuenta(CuentaEntity cuenta){
        return gateway.crearCuenta(cuenta);
    }

    public void eliminarCuenta(Integer id){
        boolean exist = gateway.existCuentaByid(id);
        if (!exist){
            log.info("Cuenta con id "+id+" no encontrada");
            throw new ObjectNotFoundException(id, " Cuenta ");
        }
        gateway.eliminarCuenta(id);
    }

    public CuentaEntity actualizarCuenta(Integer id, CuentaEntity cuenta){
        boolean exist = gateway.existCuentaByid(id);
        if (!exist){
            log.info("Cuenta con id "+id+" no encontrada");
            throw new ObjectNotFoundException(id, " Cuenta ");
        }
        cuenta.setCuentaId(id);
        return gateway.actualizarCuenta(cuenta);
    }

}
