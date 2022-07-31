package com.prata.web_corrida.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prata.web_corrida.entities.Corrida;
import com.prata.web_corrida.services.CorridaService;

@RestController
@RequestMapping(value = "/corridas")
public class CorridaResource {
	
	/* @GetMapping  s
	public ResponseEntity<Corrida> findAll(){
		Corrida j = new Corrida(1L, "jose santos", "senha1");  // Só para test se o REST está funcionando. Imprimirá em localhost:8080/jogadores
		return ResponseEntity.ok().body(j);
		
	} Usado apenas para teste no inicio */  
	
	// Trocado por:
	
	@Autowired
	private CorridaService service;
	
	@GetMapping
	public ResponseEntity<List<Corrida>> findAll(){
		List<Corrida> list = service.findAll();
		return ResponseEntity.ok().body(list);  
		
	}
	
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Corrida> findById(@PathVariable Long id){
		Corrida obj = service.findById(id);
		return ResponseEntity.ok().body(obj);  
		
	}



}
