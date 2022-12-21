package com.example.crudh2reto.services;

import com.example.crudh2reto.model.ClienteEntity;
import com.example.crudh2reto.services.gateway.ClienteGateway;
import com.example.crudh2reto.utils.validaciones.Validaciones;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

class ClienteServiceTest {

    @Mock
    private ClienteGateway gateway;

    MockedStatic<Validaciones> mockStatic  = mockStatic(Validaciones.class);

    @InjectMocks
    private ClienteService service;

    private ClienteEntity cliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        cliente = new ClienteEntity();
        cliente.setClienteId(1);
        cliente.setNombre("Maria");
        cliente.setGenero("femenino");
        cliente.setEdad(26);
        cliente.setIdentificacion(1075400876L);
        cliente.setDireccion("calle 100 #40-20");
        cliente.setTelefono(3004567890L);
        cliente.setContrasena("4f5b");
        cliente.setEstado(true);

        mockStatic.when(() -> Validaciones.validarGenero("femenino")).thenReturn(true);
    }

    @Test
    void listarClientes() {

        Mockito.when(gateway.listarClientes()).thenReturn(List.of(cliente));
        assertNotNull(service.listarClientes());
    }

    @Test
    void obtenerClientePorId() {
        Mockito.when(gateway.obtenerClientePorId(1)).thenReturn(cliente);
        assertEquals(service.obtenerClientePorId(1), cliente);
    }

    @Test
    void validarCliente() {
        //mockStatic.when(() -> Validaciones.validarGenero("femenino")).thenReturn(true);
        Assertions.assertTrue(service.validarCliente(cliente));
    }

    @Test
    void guardarCliente() {
        //mockStatic.when(() -> Validaciones.validarGenero("femenino")).thenReturn(true);
        Mockito.when(service.validarCliente(cliente)).thenReturn(true);
        Mockito.when(gateway.guardarCliente(cliente)).thenReturn(cliente);
        Assertions.assertEquals(cliente ,service.guardarCliente(cliente) );
    }

    @Test
    void actualizarCliente() {
        Mockito.when(gateway.existByid(1)).thenReturn(true);
        Mockito.when(service.validarCliente(cliente)).thenReturn(true);
        Mockito.when(gateway.actualizarCliente(cliente)).thenReturn(cliente);
        Assertions.assertEquals(cliente, service.actualizarCliente(1, cliente));
    }


    //@Test
    //void eliminarCliente() {
    //    when(gateway.existByid(1)).thenReturn(true);
    //    Assertions.assertEquals(service.eliminarCliente(1),void);
    //}


}