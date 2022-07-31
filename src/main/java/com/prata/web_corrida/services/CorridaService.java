package com.prata.web_corrida.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prata.web_corrida.entities.Corrida;
import com.prata.web_corrida.repositories.CorridaRepository;

@Service // para registrar como uma classe de serviço no Spring. Isso resolve aquela
			// dependência que CorridaResource tem do serviço
public class CorridaService {

	// Serão feitas operações de busca de todos e também por id

	@Autowired
	private CorridaRepository repository;

	public List<Corrida> findAll() {
		return repository.findAll();
	}

	
	public Corrida findById(Long id) {
		Optional<Corrida> obj = repository.findById(id);
		return obj.get(); // Esse get vai retornar o que estiver no Optional<jogador>
	}

}
