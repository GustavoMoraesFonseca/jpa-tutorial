package com.github.pokemon.adapter;

import org.springframework.stereotype.Component;

import com.github.pokemon.dto.PokemonDto;
import com.github.pokemon.entity.PokemonEntity;
import com.github.pokemon.entity.PokemonTypeEntity;

@Component
public class PokemonAdapter {

	public PokemonEntity pokemonAdapterDtoToEntity(PokemonDto pokemonDto, 
												   PokemonTypeEntity pokemonFirstTypeEntity, 
												   PokemonTypeEntity pokemonSecondTypeEntity) throws Exception {
		PokemonEntity pokemonEntity = new PokemonEntity();
		try {
			pokemonEntity.setPokemonName(pokemonDto.getPokemonName());
			pokemonEntity.setPokedexNumber(pokemonDto.getPokedexNumber());
			pokemonEntity.setPokemonFirstType(pokemonFirstTypeEntity);
			pokemonEntity.setPokemonSecondType(pokemonSecondTypeEntity);
		} catch (Exception e) {
			throw e;
		}
		return pokemonEntity;
	}
}
