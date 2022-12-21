package com.example.crudh2reto.services;

import com.example.crudh2reto.model.ClienteEntity;
import com.example.crudh2reto.services.gateway.ClienteGateway;
import com.example.crudh2reto.utils.validaciones.Validaciones;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class ClienteServiceTest {

    @Mock
    private ClienteGateway gateway;

    MockedStatic mockStatic  = mockStatic(Validaciones.class);
    //private Validaciones validaciones;


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
    }

    @Test
    void listarClientes() {

        Mockito.when(gateway.listarClientes()).thenReturn(List.of(cliente));
        assertNotNull(service.listarClientes());
    }

    @Test
    void obtenerClientePorId() {
        Mockito.when(gateway.obtenerClientePorId(1)).thenReturn(cliente);
        assertNotNull(service.obtenerClientePorId(1));
    }

    @Test
    void validarCliente() {
        mockStatic.when(() -> Validaciones.validarGenero("femenino")).thenReturn(true);
        Assertions.assertTrue(service.validarCliente(cliente));
    }
}