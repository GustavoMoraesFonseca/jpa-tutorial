package com.github.pokemon.service;

import static com.github.pokemon.commons.CommonUtils.validatePokemonSecondType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pokemon.adapter.PokemonAdapter;
import com.github.pokemon.dto.PokemonDto;
import com.github.pokemon.entity.PokemonEntity;
import com.github.pokemon.entity.PokemonTypeEntity;
import com.github.pokemon.repository.IPokemonRepository;
import com.github.pokemon.repository.IPokemonTypeRepository;

@Service
public class PokemonService {

	@Autowired
	PokemonAdapter adapter;
	
	@Autowired
	IPokemonTypeRepository pokemonTypeRepository;
	
	@Autowired
	IPokemonRepository pokemonRepository;
	
	public Long createPokemon(PokemonDto pokemonDto) throws Exception {
		PokemonTypeEntity pokemonFirstTypeEntity = new PokemonTypeEntity();
		PokemonTypeEntity pokemonSecondTypeEntity = new PokemonTypeEntity();
		PokemonEntity pokemonEntity = new PokemonEntity();
		long id = 0;
		try {
			pokemonFirstTypeEntity = pokemonTypeRepository.findById(pokemonDto.getPokemonFirstType()).get();
			pokemonSecondTypeEntity = pokemonTypeRepository.findById(validatePokemonSecondType(pokemonDto.getPokemonFirstType(), pokemonDto.getPokemonSecondType())).get();
			pokemonEntity = adapter.pokemonAdapterDtoToEntity(pokemonDto, pokemonFirstTypeEntity, pokemonSecondTypeEntity);
			id = pokemonRepository.save(pokemonEntity).getPokemonId();
		} catch (Exception e) {
			throw e;
		}
		return id;
	}
	
	public void deletePokemon(long pokemonId) {
		pokemonRepository.deleteById(pokemonId);
	}
	
	public PokemonEntity findPokemon(long pokemonId) {
		return pokemonRepository.findById(pokemonId).get();
	}

	public List<PokemonEntity> findAllPokemon() {
		return pokemonRepository.findAll();
	}

	public PokemonEntity findPokemonByName(String name) {
		return pokemonRepository.findByPokemonName(name);
	}
	
	public void updatePokemon(PokemonEntity pokemon) {
		PokemonEntity pantsInDB = pokemonRepository.findById(pokemon.getPokemonId()).get(); 
		pantsInDB.setPokemonName(pokemon.getPokemonName());
		pantsInDB.setPokedexNumber(pokemon.getPokedexNumber());
		pantsInDB.setPokemonFirstType(pokemon.getPokemonFirstType());
		pantsInDB.setPokemonSecondType(pokemon.getPokemonSecondType());
		pokemonRepository.save(pantsInDB);
	}
}
