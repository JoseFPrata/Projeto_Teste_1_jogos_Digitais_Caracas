package com.prata.web_corrida.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prata.web_corrida.entities.Jogador;
import com.prata.web_corrida.repositories.JogadorRepository;

@Service // para registrar como uma classe de serviço no Spring. Isso resolve aquela
			// dependência que JogadorResource tem do serviço
public class JogadorService {

	// Serão feitas operações de busca de todos e também por id

	@Autowired
	private JogadorRepository repository;

	public List<Jogador> findAll() {
		return repository.findAll();
	}

	
	public Jogador findById(Long id) {
		Optional<Jogador> obj = repository.findById(id);
		return obj.get(); // Esse get vai retornar o que estiver no Optional<jogador>
	}

}
