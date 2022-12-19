package com.example.crudh2reto.repository;

import com.example.crudh2reto.model.ClienteEntity;
import com.example.crudh2reto.services.gateway.ClienteGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("jpa")
@Slf4j
public class ClienteRepositoryImp implements ClienteGateway {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<ClienteEntity> listarClientes() {
        return repository.findAll();
    }

    @Override
    public ClienteEntity obtenerClientePorId(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public ClienteEntity guardarCliente(ClienteEntity cliente) {
        return repository.save(cliente);
    }

    @Override
    public void eliminarCliente(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Boolean existByid(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public ClienteEntity actualizarCliente(ClienteEntity cliente) {
            return repository.save(cliente);
    }
}
