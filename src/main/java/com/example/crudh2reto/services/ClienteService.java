package com.example.crudh2reto.services;

import com.example.crudh2reto.model.ClienteEntity;
import com.example.crudh2reto.services.gateway.ClienteGateway;
//  import com.example.crudh2reto.utils.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClienteService {

    @Autowired
    private ClienteGateway gateway;

    public List<ClienteEntity> listarClientes(){
        return gateway.listarClientes();
    }

    public ClienteEntity obtenerClientePorId(Integer id){
        return gateway.obtenerClientePorId(id);
    }

    public ClienteEntity guardarCliente(ClienteEntity cliente){
        return gateway.guardarCliente(cliente);
    }

    public void eliminarCliente(Integer id){
        boolean exist = gateway.existByid(id);
        if(!exist){
            log.info("Cliente no encontrado");
            throw new ObjectNotFoundException(id, "Cliente");
        }
        gateway.eliminarCliente(id);
    }

    public ClienteEntity actualizarCliente(Integer id, ClienteEntity cliente){
        boolean exist = gateway.existByid(id);
        if (!exist){
            log.info("Cliente no encontrado");
            throw new ObjectNotFoundException(id, "Cliente");
        }
        //cliente.setClienteId(id);
        return gateway.actualizarCliente(cliente);
    }
}
