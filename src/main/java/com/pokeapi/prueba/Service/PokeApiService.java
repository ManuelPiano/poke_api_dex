package com.pokeapi.prueba.Service;

import com.pokeapi.prueba.Models.Pokemons.Pokemon;
import com.pokeapi.prueba.Models.Pokemons.Type.Types;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeApiService {

  private RestTemplate restTemplate;

  public PokeApiService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Pokemon getPokemon(int pokemonId) {
    String apiUrl = "https://pokeapi.co/api/v2/pokemon/" + pokemonId;
    ResponseEntity<Pokemon> response = restTemplate.getForEntity(apiUrl, Pokemon.class);
    return response.getBody();
  }

  public Types getPokemonsTypes(String TypeId) {
    String apiUrl = "https://pokeapi.co/api/v2/type/ " + TypeId;
    ResponseEntity<Types> response = restTemplate.getForEntity(apiUrl, Types.class);
    return response.getBody();
  }

  public List<Pokemon> getTeamOfPokemon(int teamSize) {
    List<Pokemon> team = new ArrayList<>();

    // Lógica para obtener un equipo de Pokémon desde la API
    for (int i = 0; i < teamSize; i++) {
      // Obtener un Pokémon de la API y agregarlo al equipo
      Pokemon pokemon =
          restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + i, Pokemon.class);
      team.add(pokemon);
    }

    return team;
  }
}
