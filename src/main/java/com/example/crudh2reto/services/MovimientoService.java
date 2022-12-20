package com.example.crudh2reto.services;

import com.example.crudh2reto.model.CuentaEntity;
import com.example.crudh2reto.model.MovimientoEntity;
import com.example.crudh2reto.services.gateway.CuentaGateway;
import com.example.crudh2reto.services.gateway.MovimientoGateway;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class MovimientoService {

    @Autowired
    private MovimientoGateway gateway;

    @Autowired
    private CuentaGateway cuentaGateway;
    public List<MovimientoEntity> listarMovimientos(){
        return gateway.listarMovimientos();
    }

    public MovimientoEntity obtenerMovimientoPorId(Integer id){
        return gateway.obtenerMovimientoPorId(id);
    }

    public Boolean validarSaldo(Integer idCuenta, Double valor){
        CuentaEntity cuenta = cuentaGateway.obtenerCuentaPorId(idCuenta);
        Double saldoCuenta = cuenta.getSaldoInicial();
        if(valor>saldoCuenta){
            log.info("No tiene fondos suficientes");
            return false;
        }
        return true;
    }

    public Double saldoEnCuenta(Integer idCuenta){
        CuentaEntity cuenta = cuentaGateway.obtenerCuentaPorId(idCuenta);
        return cuenta.getSaldoInicial();
    }
    public MovimientoEntity crearMovimiento(MovimientoEntity movimiento){
        //se necesita Id de la cuenta
        Double valor = movimiento.getValor();
        Integer idCuenta = movimiento.getCuenta().getCuentaId();

        Boolean fondosSuficiente = validarSaldo(idCuenta, valor);
        if (!fondosSuficiente){
            throw new ObjectNotFoundException( idCuenta, " Movimiento no permitido, fondos insuficientes ");
        }
        System.out.println(fondosSuficiente);
        movimiento.setSaldo(saldoEnCuenta(idCuenta)+ movimiento.getValor());
        //validarSaldo(id, valor);
        return gateway.crearMovimiento(movimiento);
    }

    public void eliminarMovimiento(Integer id){
        boolean exist = gateway.existMovimientoByid(id);
        if (!exist){
            log.info("Movimiento con id "+id+" no encontrado");
            throw new ObjectNotFoundException(id, " Movimiento ");
        }
        gateway.eliminarMovimiento(id);
    }

    public MovimientoEntity actualizarMovimiento(Integer id, MovimientoEntity movimiento){
        boolean exist = gateway.existMovimientoByid(id);
        if (!exist){
            log.info("Movimiento con id "+id+" no encontrado");
            throw new ObjectNotFoundException(id, " Movimiento ");
        }
        movimiento.setMovimientoId(id);
        return gateway.actualizarMovimiento(movimiento);
    }
}
