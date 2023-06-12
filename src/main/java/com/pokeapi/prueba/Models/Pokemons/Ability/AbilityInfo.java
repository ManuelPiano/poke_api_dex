package com.pokeapi.prueba.Models.Pokemons.Ability;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AbilityInfo {

  private Ability ability;
  private int slot;
}
