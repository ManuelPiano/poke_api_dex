package com.pokeapi.prueba.Models.Pokemons.Type;

import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Types {

  private int id;
  private String name;

  private List<TypePokemon> pokemon;
}
