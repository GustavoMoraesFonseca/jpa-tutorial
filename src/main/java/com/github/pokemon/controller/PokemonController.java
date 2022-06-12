package com.github.pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pokemon.dto.PokemonDto;
import com.github.pokemon.entity.PokemonEntity;
import com.github.pokemon.service.PokemonService;

@RestController
@RequestMapping("pokemon")
public class PokemonController {

	@Autowired
	PokemonService pokemonService;
	
	@PostMapping
	public ResponseEntity<String> createPokemon(@RequestBody PokemonDto pokemon) {
		ResponseEntity<String> response = null;
		try {
			long id = pokemonService.createPokemon(pokemon);
			response = ResponseEntity.ok("Deu Certo " + id);
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}
	
	@PutMapping
	public ResponseEntity<String> updatePayment(@RequestBody PokemonDto pokemon) {
		ResponseEntity<String> response = null;
		try {
			//pokemonService.updatePokemon(pokemon);
			response = ResponseEntity.ok("Deu Certo");
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletePokemon(@PathVariable("id") long id) {
		ResponseEntity<String> response = null;
		try {
			pokemonService.deletePokemon(id);
			response = ResponseEntity.ok("Deu Certo");
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PokemonEntity> findPokemon(@PathVariable("id") long id) {
		ResponseEntity<PokemonEntity> response = null;
		try {
			PokemonEntity pokemon = pokemonService.findPokemon(id);
			response = ResponseEntity.ok(pokemon);
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}
	
	@GetMapping(value = "/name/{name}")
	public ResponseEntity<PokemonEntity> findPokemon(@PathVariable("name") String name) {
		ResponseEntity<PokemonEntity> response = null;
		try {
			PokemonEntity pokemon = pokemonService.findPokemonByName(name);
			response = ResponseEntity.ok(pokemon);
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}
	
	@GetMapping
	public ResponseEntity<List<PokemonEntity>> findPokemon() {
		ResponseEntity<List<PokemonEntity>> response = null;
		try {
			List<PokemonEntity> pokemon = pokemonService.findAllPokemon();
			response = ResponseEntity.ok(pokemon);
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}
}
