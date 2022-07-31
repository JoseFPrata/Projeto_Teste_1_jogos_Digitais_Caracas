package com.prata.web_corrida.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prata.web_corrida.entities.Jogador;
import com.prata.web_corrida.services.JogadorService;

@RestController
@RequestMapping(value = "/jogadores")
public class JogadorResource {
	
	/* @GetMapping  s
	public ResponseEntity<Jogador> findAll(){
		Jogador j = new Jogador(1L, "jose santos", "senha1");  // Só para test se o REST está funcionando. Imprimirá em localhost:8080/jogadores
		return ResponseEntity.ok().body(j);
		
	} Usado apenas para teste no inicio */  
	
	// Trocado por:
	
	@Autowired
	private JogadorService service;
	
	@GetMapping
	public ResponseEntity<List<Jogador>> findAll(){
		List<Jogador> list = service.findAll();
		return ResponseEntity.ok().body(list);  
		
	}
	
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Jogador> findById(@PathVariable Long id){
		Jogador obj = service.findById(id);
		return ResponseEntity.ok().body(obj);  
		
	}



}
