package com.pokeapi.prueba.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokeapi.prueba.Models.Pokemons.Pokemon;
import com.pokeapi.prueba.Models.Pokemons.Type.Types;
import com.pokeapi.prueba.Service.PokeApiService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Pokemon")
public class PokemonController {

  private final PokeApiService pokeApiService;

  @Autowired
  public PokemonController(PokeApiService pokeApiService) {
    this.pokeApiService = pokeApiService;
  }

  @GetMapping("/{id}")
  @Operation(summary = "get pokemon information by id")
  public Pokemon getPokemonById(@PathVariable int id) throws JsonProcessingException {
    String apiUrl = "https://pokeapi.co/api/v2/pokemon/" + id;
    String jsonResponse = "";
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
    if (response.getStatusCode() == HttpStatus.OK) {
      jsonResponse = response.getBody();
    } else {

    }
    ObjectMapper objectMapper = new ObjectMapper();
    Pokemon pokemon = objectMapper.readValue(jsonResponse, Pokemon.class);
    return pokemon;
  }


  @GetMapping("/types/{typeId}")
  @Operation(summary = "get a list of pokemon by types")
  public Types getPokemonsByType(@PathVariable String typeId) {
    return pokeApiService.getPokemonsTypes(typeId);
  }
}
