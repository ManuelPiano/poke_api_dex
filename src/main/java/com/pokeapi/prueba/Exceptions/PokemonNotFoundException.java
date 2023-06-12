package com.pokeapi.prueba.Exceptions;

public class PokemonNotFoundException extends RuntimeException {

  public PokemonNotFoundException(int PokemonId) {
    super("Could not found pokemon with id:" + PokemonId);
  }
}
