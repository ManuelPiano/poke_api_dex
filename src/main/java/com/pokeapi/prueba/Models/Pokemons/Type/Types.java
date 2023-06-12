package com.pokeapi.prueba.Models.Pokemons.Type;

import lombok.*;

import java.util.List;
@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
@ToString
public class Types {

    private int id;
    private String name;

    private List<TypePokemon> pokemon;


}
