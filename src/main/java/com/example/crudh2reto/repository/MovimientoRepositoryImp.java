package com.example.crudh2reto.repository;

import com.example.crudh2reto.model.MovimientoEntity;
import com.example.crudh2reto.services.gateway.MovimientoGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("JpaMoves")
@Slf4j
public class MovimientoRepositoryImp implements MovimientoGateway {

    @Autowired
    private MovimientoRepository repository;

    @Override
    public List<MovimientoEntity> listarMovimientos() {
        return repository.findAll();
    }

    @Override
    public MovimientoEntity obtenerMovimientoPorId(Integer id) {
        return repository.findById(id).get();
    }


    @Override
    public MovimientoEntity crearMovimiento(MovimientoEntity Movimiento) {
        return repository.save(Movimiento);
    }

    @Override
    public void eliminarMovimiento(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Boolean existMovimientoByid(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public MovimientoEntity actualizarMovimiento(MovimientoEntity Movimiento) {
        return repository.save(Movimiento);
    }
}
