package com.github.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.pokemon.entity.PokemonTypeEntity;

@Repository
public interface IPokemonTypeRepository 
	extends JpaRepository<PokemonTypeEntity, Long> {
}