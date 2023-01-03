/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.rest;
import com.example.demo.model.Pasatiempos;
import com.example.demo.service.PasatiemposService;
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

/**
 *
 * @author ramse
 */
@RestController
@RequestMapping ("/api/pasatiempos/")
public class PasatiemposRest {
    @Autowired
    private PasatiemposService pasatiemposService;

    @PostMapping
    private ResponseEntity<Pasatiempos> guardar (@RequestBody Pasatiempos pasatiempos){
        Pasatiempos temporal = pasatiemposService.create(pasatiempos);

        try {
            return ResponseEntity.created(new URI("/api/pasatiempos"+temporal.getId())).body(temporal);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<Pasatiempos>> listarTodasLasPersona (){
        return ResponseEntity.ok(pasatiemposService.getAllPasatiempos());
    }

    @DeleteMapping
    private ResponseEntity<Void> eliminarPersona (@RequestBody Pasatiempos pasatiempos){
        pasatiemposService.delete(pasatiempos);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "{id}")
    private ResponseEntity<Optional<Pasatiempos>> listarPersonasPorID (@PathVariable ("id") Long id){
        return ResponseEntity.ok(pasatiemposService.findById(id));
    }
    
}
