package com.pokeapi.prueba.Models;

import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "trainer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Trainer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  private int Age;

  @ElementCollection
  @CollectionTable(name = "trainer_pokemon")
  private List<Long> team;
}
