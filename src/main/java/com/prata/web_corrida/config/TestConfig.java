package com.prata.web_corrida.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.prata.web_corrida.entities.Carro;
import com.prata.web_corrida.entities.Corrida;
import com.prata.web_corrida.entities.Jogador;
import com.prata.web_corrida.repositories.CarroRepository;
import com.prata.web_corrida.repositories.CorridaRepository;
import com.prata.web_corrida.repositories.JogadorRepository;

@Configuration
@Profile("test")
		
class TestConfig implements CommandLineRunner{
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
	private CorridaRepository corridaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Jogador j1 = new Jogador(null, "Pedro Santos", "senha1");
		Jogador j2 = new Jogador(null, "Luiz Gonçalves", "senha2");	
		
		jogadorRepository.saveAll(Arrays.asList(j1,j2));
		
		Carro c1 = new Carro(null,"Ford", "Maverick", "Valente",j2);
		Carro c2 = new Carro(null, "Chevrolet", "Opala", "Bravo", j2);
		Carro c3 = new Carro(null, "VW", "Fusca", "Mexido", j2);
		
		carroRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		Corrida co1 = new  Corrida(null,  Instant.parse("2019-06-20T19:53:07Z"), "1000 milhas", "corrida que ocorre..");
		Corrida co2 = new  Corrida(null,  Instant.parse("2019-06-20T19:53:07Z"), "500 milhas", "corrida que ocorre..");		
		
		
		corridaRepository.saveAll(Arrays.asList(co1,co2));
		
		//abaixo associamos os objetos na tabela CarroCorrida criada pelo JoinTable. associamos os carros nas corridas e salvamos
		co1.getCarros().add(c1);  // esse método getCorre é que foi adicionado em Carro no relacionamento entre carro e corrida
		co1.getCarros().add(c2);
		co2.getCarros().add(c1);
		
		
		corridaRepository.saveAll(Arrays.asList(co1,co2));
		
		
		
		
		
	} 
	
	

	
	

}
