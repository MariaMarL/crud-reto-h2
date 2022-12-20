package com.example.crudh2reto.repository;

import com.example.crudh2reto.model.CuentaEntity;
import com.example.crudh2reto.services.gateway.CuentaGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("jpaCuenta")
@Slf4j
public class CuentaRepositoryImp implements CuentaGateway {

    @Autowired
    private CuentaRepository repository;

    @Override
    public List<CuentaEntity> listarCuentas() {
        return repository.findAll();
    }

    @Override
    public CuentaEntity obtenerCuentaPorId(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public CuentaEntity crearCuenta(CuentaEntity cuenta) {
        return repository.save(cuenta);
    }

    @Override
    public void eliminarCuenta(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Boolean existCuentaByid(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public CuentaEntity actualizarCuenta(CuentaEntity Cuenta) {
        return repository.save(Cuenta);
    }
}
