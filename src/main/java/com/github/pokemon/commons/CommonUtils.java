package com.github.pokemon.commons;

public class CommonUtils {

	public static Long validatePokemonSecondType(Long first, Long second) {
		if (second == null || second.equals(first)) {
			second = first;
		}
		return second;
	}
}
