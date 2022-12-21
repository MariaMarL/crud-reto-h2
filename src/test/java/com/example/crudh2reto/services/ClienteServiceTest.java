package com.example.crudh2reto.services;

import com.example.crudh2reto.model.ClienteEntity;
import com.example.crudh2reto.services.gateway.ClienteGateway;
import com.example.crudh2reto.utils.validaciones.Validaciones;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteGateway gateway;


    private Validaciones validaciones = new Validaciones();

    //MockedStatic<Validaciones> mockStatic  = mockStatic(Validaciones.class);

    @InjectMocks
    private ClienteService service = new ClienteService(validaciones);

    private ClienteEntity cliente;

    @BeforeEach
    void setUp() {
        //MockitoAnnotations.openMocks(this);

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
        //Mockito.when(service.validarCliente(cliente)).thenReturn(true);
        Mockito.when(gateway.guardarCliente(cliente)).thenReturn(cliente);
        Assertions.assertEquals(cliente ,service.guardarCliente(cliente) );
    }

    @Test
    void actualizarCliente() {
        Mockito.when(gateway.existByid(1)).thenReturn(true);
        //Mockito.when(service.validarCliente(cliente)).thenReturn(true);
        Mockito.when(gateway.actualizarCliente(cliente)).thenReturn(cliente);
        Assertions.assertEquals(cliente, service.actualizarCliente(1, cliente));
    }


    //@Test
    //void eliminarCliente() {
    //    Mockito.when(gateway.existByid(1)).thenReturn(true);
    //    Assertions.(service.eliminarCliente(1), void);
    //}


}