/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaResporitory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ramse
 */
@Service
public class PersonaService {
    @Autowired
	private PersonaResporitory personaResporitory;
	
	
	public Persona create (Persona persona) {
		return personaResporitory.save(persona);
	}
	
	public List<Persona> getAllPersonas (){
		return personaResporitory.findAll();
	}
	
	public void delete (Persona persona) {
		personaResporitory.delete(persona);
	}
	
	public Optional<Persona> findById (Long id) {
		return personaResporitory.findById(id);
	}
}
