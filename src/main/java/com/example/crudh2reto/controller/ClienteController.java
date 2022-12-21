package com.example.crudh2reto.controller;

import com.example.crudh2reto.model.ClienteEntity;
import com.example.crudh2reto.model.ReportOnly;
import com.example.crudh2reto.services.ClienteService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping()
    public ResponseEntity<List<ClienteEntity>> listarClientes(){
        List<ClienteEntity> clientes =service.listarClientes();
        if (clientes.isEmpty()){
            return new ResponseEntity("No se encontraron clientes creados", HttpStatus.OK);
        }
        return new ResponseEntity(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> obtenerClientePorId(@PathVariable() Integer id){
        try {
            return new ResponseEntity(service.obtenerClientePorId(id), HttpStatus.FOUND);
        }
        catch (Exception exception){
                return  new ResponseEntity("Cliente con id: "+id+ " no encontrado, verifique que el id corresponda a un cliente existente", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping()
    public ResponseEntity<ClienteEntity> guardarCliente(@RequestBody() ClienteEntity cliente){
        try {
            return new ResponseEntity(service.guardarCliente(cliente), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarCliente(@PathVariable() Integer id,
                                                    @RequestBody() ClienteEntity cliente){
        try {
            return new ResponseEntity(service.actualizarCliente(id,cliente),HttpStatus.ACCEPTED);
        }
        catch (Exception exception){
            return  new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable() Integer id){
        try {
            service.eliminarCliente(id);
            return new ResponseEntity<String>("Cliente Eliminado",HttpStatus.ACCEPTED);
        }
        catch (Exception exception){
            return  new ResponseEntity<String>("Cliente con id: "+id+ " no encontrado, verifique que el id corresponda a un cliente existente", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/reporte/{clienteid}/{fechainicial}/{fechafinal}")
    public List<ReportOnly> generarReporte(@PathVariable() int clienteid,
                                                           @PathVariable() String fechainicial,
                                                           @PathVariable() String fechafinal ) throws ParseException {
        Date inicial =new SimpleDateFormat("yyyy/MM/dd").parse(fechainicial); ;
        Date fechafinal2 =new SimpleDateFormat("yyyy/MM/dd").parse(fechafinal); ;
        return service.generarReporte(clienteid,inicial, fechafinal2);
    }

}
