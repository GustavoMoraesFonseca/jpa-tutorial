package com.github.pokemon.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonDto implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private Long id;
    private String pokemonName;
    private Long pokemonFirstType;
    private Long pokemonSecondType;
    private int pokedexNumber;
    private Date dthrCriacao;
    private Date dthrAtualizacao;
}
