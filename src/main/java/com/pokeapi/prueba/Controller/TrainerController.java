package com.pokeapi.prueba.Controller;

import com.pokeapi.prueba.Models.Pokemons.Pokemon;
import com.pokeapi.prueba.Models.Trainer;
import com.pokeapi.prueba.Repository.TrainerRepository;
import com.pokeapi.prueba.Service.PokeApiService;
import com.pokeapi.prueba.Service.TrainerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

  @Autowired private TrainerRepository trainerRepository;
  @Autowired
  private PokeApiService pokeApiService;
  @Autowired
  private TrainerService trainerService;

  @PostMapping("/create")
  @Operation(summary = "create a new trainer with team")
  public Trainer createTrainer(@RequestBody Trainer trainer) {
    Trainer savedTrainer = trainerService.createTrainer(trainer);
    return savedTrainer;
  }


  @GetMapping("/team/{trainerId}")
  @Operation(summary = "Get Trainer's Pokemon team")
  public List<Pokemon> getTrainerTeam(@PathVariable int trainerId) {
    Trainer trainer = trainerService.getTrainer(trainerId);
    List<Pokemon> team = new ArrayList<>();

    for (Long pokemonId : trainer.getTeam()) {
      Pokemon pokemon = pokeApiService.getPokemon(pokemonId.intValue());
      team.add(pokemon);
    }

    return team;
  }

  @PutMapping("/modify/{trainerId}")
  @Operation(summary = "modify an existing trainer by id")
  public ResponseEntity<Trainer> updateTrainer(@PathVariable int trainerId, @RequestBody Trainer updatedTrainer) {
    Trainer trainer = trainerService.updateTrainer(trainerId, updatedTrainer);
    return ResponseEntity.ok(trainer);
  }

  @DeleteMapping("/delete/{trainerId}")
  @Operation(summary = "delete a trainer by id")
  public ResponseEntity<Void> deleteTrainer(@PathVariable int trainerId) {
    trainerService.deleteTrainer(trainerId);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{id}")
  @Operation(summary = "get an existing trainer by id")
  public ResponseEntity<Trainer> getTrainerbyid(@PathVariable("id") int trainerId) {
    Trainer trainer = trainerService.getTrainer(trainerId);
    return ResponseEntity.ok(trainer);
  }
}
