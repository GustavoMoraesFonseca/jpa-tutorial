package com.github.pokemon.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tap_pokemon", schema = "pokemon")
public class PokemonEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pokemonId;
    
    @Column(name = "pokemon_name", length = 30, nullable = false, unique = true)
    private String pokemonName;
    
	@OneToOne
	@JoinColumn(name="pokemon_first_type_id", nullable = false)
    private PokemonTypeEntity pokemonFirstType;

	@OneToOne
	@JoinColumn(name="pokemon_second_type_id")
    private PokemonTypeEntity pokemonSecondType;

    @Column(name = "pokedex_number", nullable = false, unique = true)
    private int pokedexNumber;
    
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "dthr_criacao", nullable = false)
    private Date dthrCriacao;
    
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "dthr_atualizacao", nullable = false)
    private Date dthrAtualizacao;
    
    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        dthrCriacao = atual;
        dthrAtualizacao = atual;
    }
    
	@PreUpdate
    public void preUpdate() {
		dthrAtualizacao = new Date();
    }
}
