package com.prata.web_corrida.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prata.web_corrida.entities.Carro;
import com.prata.web_corrida.repositories.CarroRepository;

@Service // para registrar como uma classe de serviço no Spring. Isso resolve aquela
			// dependência que JogadorResource tem do serviço
public class CarroService {

	// Serão feitas operações de busca de todos e também por id

	@Autowired
	private CarroRepository repository;

	public List<Carro> findAll() {
		return repository.findAll();
	}

	
	public Carro findById(Long id) {
		Optional<Carro> obj = repository.findById(id);
		return obj.get(); // Esse get vai retornar o que estiver no Optional<jogador>
	}

}
