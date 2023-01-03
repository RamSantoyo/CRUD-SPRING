package com.example.demo.service;

import com.example.demo.model.Pasatiempos;
import com.example.demo.repository.PasatiemposResporitory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PasatiemposService {
    @Autowired
    private PasatiemposResporitory pasatiemposResporitory;

    public Pasatiempos create (Pasatiempos pasatiempos) {
        return pasatiemposResporitory.save(pasatiempos);
    }

    public List<Pasatiempos> getAllPasatiempos (){
        return pasatiemposResporitory.findAll();
    }

    public void delete (Pasatiempos pasatiempos) {
        pasatiemposResporitory.delete(pasatiempos);
    }

    public Optional<Pasatiempos> findById (Long id) {
        return pasatiemposResporitory.findById(id);
    }
    //URL PARA ELIMINAR UN PASATIEMPO ES http://localhost:8080/api/pasatiempos/1
    //URL PARA AGREGAR UN PASATIEMPO ES http://localhost:8080/api/pasatiempos/
    //URL PARA LISTAR TODOS LOS PASATIEMPOS ES http://localhost:8080/api/pasatiempos/
    //URL PARA LISTAR UN PASATIEMPO ES http://localhost:8080/api/pasatiempos/1   
}
