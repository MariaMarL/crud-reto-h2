package com.example.crudh2reto.services;

import com.example.crudh2reto.model.CuentaEntity;
import com.example.crudh2reto.services.gateway.CuentaGateway;
import com.example.crudh2reto.utils.validaciones.Validaciones;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CuentaService {

    @Autowired
    private CuentaGateway gateway;

    @Autowired
    private Validaciones validaciones;

    public List<CuentaEntity> listarCuentas(){
        return gateway.listarCuentas();
    }

    public CuentaEntity obtenerCuentaPorId(Integer id){
        return gateway.obtenerCuentaPorId(id);
    }

    public Boolean validarCuenta(CuentaEntity cuenta){
        String tipo = cuenta.getTipoDeCuenta().toLowerCase();
        if(!validaciones.validarTipoDeCuenta(tipo)){
            throw new HibernateException("Tipo de cuenta no permitido, Ingrese \"AHORROS\" o \"CORRIENTE\"");
        }
        if(cuenta.getSaldoInicial()<0 ||
                cuenta.getNumeroDeCuenta()<0){
            throw new HibernateException("No es posible ingresar valores negativos");
        }
        return true;
    }
    public CuentaEntity crearCuenta(CuentaEntity cuenta){
        if (!validarCuenta(cuenta)){
            throw new HibernateException("No es posible crear la cuenta");
        }
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
            throw new HibernateException("Cuenta con id "+id+" no encontrada");
        }
        if (!validarCuenta(cuenta)){
            throw new HibernateException("No fue posible actualizar crear el cliente");
        }
        cuenta.setCuentaId(id);
        return gateway.actualizarCuenta(cuenta);
    }

}
