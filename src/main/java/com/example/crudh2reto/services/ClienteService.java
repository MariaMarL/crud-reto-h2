package com.example.crudh2reto.services;

import com.example.crudh2reto.model.ClienteEntity;
import com.example.crudh2reto.model.ReportOnly;
import com.example.crudh2reto.services.gateway.ClienteGateway;
//  import com.example.crudh2reto.utils.exceptions.NotFoundException;
import com.example.crudh2reto.utils.validaciones.Validaciones;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ClienteService {

    @Autowired
    private ClienteGateway gateway;


    private Validaciones validaciones;

    public ClienteService(Validaciones validaciones) {
        this.validaciones = validaciones;
    }

    public List<ClienteEntity> listarClientes(){
        return gateway.listarClientes();
    }

    public ClienteEntity obtenerClientePorId(Integer id){
        return gateway.obtenerClientePorId(id);
    }

    public Boolean validarCliente(ClienteEntity cliente){
        String genero = cliente.getGenero().toLowerCase();
        String estado = cliente.getEstado().toString();
        if (!validaciones.validarGenero(genero)){
            throw new HibernateException("Genero no permitido, Ingrese \"FEMENINO\" o \"MASCULINO\"");
        }
        if (cliente.getEdad()<0 ||
                cliente.getTelefono()<0 ||
                cliente.getIdentificacion()<0){
            throw new HibernateException("No es posible ingresar valores negativos");
        }
        return true;
    }

    public ClienteEntity guardarCliente(ClienteEntity cliente){
        if (!validarCliente(cliente)){
            throw new HibernateException("No es posible crear el cliente");
        }
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
            throw new HibernateException("Cliente con id: "+id+ " no encontrado, verifique que el id corresponda a un cliente existente");
        }
        if (!validarCliente(cliente)){
            throw new HibernateException("No es actualizar crear el cliente");
        }
        cliente.setClienteId(id);
        return gateway.actualizarCliente(cliente);
    }

    public List<ReportOnly> generarReporte(int clienteid, Date fechainicial, Date fechafinal){
        return gateway.generarReporte(clienteid, fechainicial, fechafinal);
    }
}
