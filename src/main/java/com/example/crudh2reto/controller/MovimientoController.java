package com.example.crudh2reto.controller;

import com.example.crudh2reto.model.MovimientoEntity;
import com.example.crudh2reto.services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService service;

    @GetMapping()
    public ResponseEntity<List<MovimientoEntity>> listarMovimientos(){
        List<MovimientoEntity> movimientos = service.listarMovimientos();
        if(movimientos.isEmpty()){
            return new ResponseEntity("No se encontraron movimientos creados", HttpStatus.OK);
        }
        return new ResponseEntity(movimientos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoEntity> obtenerMovimientoPorId(@PathVariable() Integer id){
        try {
            return new ResponseEntity(service.obtenerMovimientoPorId(id), HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity("Movimiento con id: "+id+ " no encontrado, verifique que el id corresponda a un movimiento realizado", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<MovimientoEntity> realizarMovimiento(@RequestBody() MovimientoEntity movimiento){
        try {
            return new ResponseEntity(service.crearMovimiento(movimiento), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovimientoEntity> actualizarMovimiento(@PathVariable() Integer id,
                                                                 @RequestBody() MovimientoEntity movimiento){
        try {
            return new ResponseEntity(service.actualizarMovimiento(id, movimiento), HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity("Movimiento con id: "+id+ " no encontrado, verifique que el id corresponda a un movimiento realizado", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMovimiento(@PathVariable() Integer id){
        try {
            service.eliminarMovimiento(id);
            return new ResponseEntity("Movimiento con id: "+id+" eliminado", HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity("Movimiento con id: "+id+" no encontrado, verifique que el id corresponda a un movimiento realizado", HttpStatus.BAD_REQUEST);
        }
    }
}
