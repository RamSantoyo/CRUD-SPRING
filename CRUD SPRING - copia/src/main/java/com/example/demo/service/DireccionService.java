package com.example.demo.service;

import com.example.demo.model.Direccion;
import com.example.demo.repository.DireccionRespository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DireccionService {
    @Autowired
    private DireccionRespository direccionRespository;

    public Direccion create (Direccion direccion) {
        return direccionRespository.save(direccion);
    }

    public List<Direccion> getAllDireccion (){
        return direccionRespository.findAll();
    }

    public void delete (Direccion direccion) {
        direccionRespository.delete(direccion);
    }

    public Optional<Direccion> findById (Long id) {
        return direccionRespository.findById(id);
    }

}
