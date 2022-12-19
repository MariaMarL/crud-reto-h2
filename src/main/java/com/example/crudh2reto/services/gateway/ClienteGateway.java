package com.example.crudh2reto.services.gateway;

import com.example.crudh2reto.model.ClienteEntity;

import java.util.List;
import java.util.Optional;

public interface ClienteGateway {

    List<ClienteEntity> listarClientes();

    ClienteEntity obtenerClientePorId(Integer id);

    ClienteEntity guardarCliente(ClienteEntity cliente);

    void eliminarCliente(Integer id);

    Boolean existByid(Integer id);

    ClienteEntity actualizarCliente(ClienteEntity cliente);

}
