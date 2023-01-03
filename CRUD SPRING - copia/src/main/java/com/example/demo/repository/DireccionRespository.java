package com.example.demo.repository;


import com.example.demo.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRespository extends JpaRepository<Direccion, Long> {
    
}

