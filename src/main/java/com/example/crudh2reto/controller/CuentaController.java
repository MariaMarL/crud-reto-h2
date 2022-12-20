package com.example.crudh2reto.controller;

import com.example.crudh2reto.model.CuentaEntity;
import com.example.crudh2reto.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService service;

    @GetMapping()
    public ResponseEntity<List<CuentaEntity>> listarCuentas(){
        List<CuentaEntity> cuentas = service.listarCuentas();
        if (cuentas.isEmpty()){
            return new ResponseEntity("No se encontraron cuentas creadas", HttpStatus.OK);
        }
        return new ResponseEntity(cuentas,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentaEntity> obtenerCuentaPorId(@PathVariable() Integer id){
        try {
            return new ResponseEntity(service.obtenerCuentaPorId(id),HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity("Cuenta con id: "+id+ " no encontrada, verifique que el id corresponda a una cuenta existente", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<CuentaEntity> crearCuenta(@RequestBody() CuentaEntity cuenta){
        try {
            return new ResponseEntity(service.crearCuenta(cuenta), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuentaEntity> actualizarCuenta(@PathVariable() Integer id,
                                                         @RequestBody() CuentaEntity cuenta){
        try {
            return new ResponseEntity<>(service.actualizarCuenta(id, cuenta), HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity("Cuenta con id: "+id+ " no encontrada, verifique que el id corresponda a una cuenta existente", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCuenta(@PathVariable() Integer id){
        try {
            service.eliminarCuenta(id);
            return new ResponseEntity("Cuenta con id: "+id+" eliminada", HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity("Cuenta con id: "+id+" no encontrada, verifique que el id corresponda a una cuenta existente", HttpStatus.BAD_REQUEST);
        }
    }
}
