package com.example.crudh2reto.services.gateway;

import com.example.crudh2reto.model.ClienteEntity;
import com.example.crudh2reto.model.ReportOnly;

import java.util.Date;
import java.util.List;

public interface ClienteGateway {

    List<ClienteEntity> listarClientes();

    ClienteEntity obtenerClientePorId(Integer id);

    ClienteEntity guardarCliente(ClienteEntity cliente);

    void eliminarCliente(Integer id);

    Boolean existByid(Integer id);

    ClienteEntity actualizarCliente(ClienteEntity cliente);

    List<ReportOnly> generarReporte(int clienteid, Date fechainicial, Date fechafinal);

}
