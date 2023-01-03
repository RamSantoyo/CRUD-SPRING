package com.example.demo.rest;

import com.example.demo.model.Direccion;
import com.example.demo.service.DireccionService;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("/api/direccion/")
public class DireccionRest {
    @Autowired
    private DireccionService direccionService;

    @PostMapping
    private ResponseEntity<Direccion> guardar (@RequestBody Direccion direccion){
        Direccion temporal = direccionService.create(direccion);

        try {
            return ResponseEntity.created(new URI("/api/direccion"+temporal.getId())).body(temporal);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<Direccion>> listarTodasLasDireccion (){
        return ResponseEntity.ok(direccionService.getAllDireccion());
    }

    @DeleteMapping
    private ResponseEntity<Void> eliminarDireccion (@RequestBody Direccion direccion){
        direccionService.delete(direccion);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "{id}")
    private ResponseEntity<Optional<Direccion>> listarDireccionPorID (@PathVariable ("id") Long id){
        return ResponseEntity.ok(direccionService.findById(id));
    }

}
