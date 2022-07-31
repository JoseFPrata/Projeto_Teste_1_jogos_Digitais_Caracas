package com.prata.web_corrida.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prata.web_corrida.entities.Carro;
import com.prata.web_corrida.services.CarroService;

@RestController
@RequestMapping(value = "/carros")
public class CarroResource {
	
	/* @GetMapping  s
	public ResponseEntity<Carro> findAll(){
		Carro j = new Carro(1L, "jose santos", "senha1");  // Só para test se o REST está funcionando. Imprimirá em localhost:8080/jogadores
		return ResponseEntity.ok().body(j);
		
	} Usado apenas para teste no inicio */  
	
	// Trocado por:
	
	@Autowired
	private CarroService service;
	
	@GetMapping
	public ResponseEntity<List<Carro>> findAll(){
		List<Carro> list = service.findAll();
		return ResponseEntity.ok().body(list);  
		
	}
	
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Carro> findById(@PathVariable Long id){
		Carro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);  
		
	}



}
