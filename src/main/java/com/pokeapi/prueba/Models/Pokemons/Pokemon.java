package com.pokeapi.prueba.Models.Pokemons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pokeapi.prueba.Models.Pokemons.Ability.AbilityInfo;
import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {

  private String name;
  private int id;
  private int base_experience;
  private double height;
  private String location_area_encounters;
  private Species species;
  private List<AbilityInfo> abilities;
}
