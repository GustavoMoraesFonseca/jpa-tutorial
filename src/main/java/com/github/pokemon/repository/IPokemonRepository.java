package com.github.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.pokemon.entity.PokemonEntity;

@Repository
public interface IPokemonRepository 
	extends JpaRepository<PokemonEntity, Long> {
	
	@Query(value = "SELECT * FROM tap_pokemon p WHERE p.pokemon_name = ?1", nativeQuery = true)
	PokemonEntity findByPokemonName(String pokemonName);
}