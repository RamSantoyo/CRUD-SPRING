package com.example.demo.repository;


import com.example.demo.model.Pasatiempos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasatiemposResporitory extends JpaRepository<Pasatiempos, Long> {
    
}   
