package com.pokeapi.prueba.Service;

import com.pokeapi.prueba.Models.Pokemons.Pokemon;
import com.pokeapi.prueba.Models.Trainer;
import com.pokeapi.prueba.Repository.TrainerRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {
    private TrainerRepository trainerRepository;
    private PokeApiService pokeApiService;

    public TrainerService(TrainerRepository trainerRepository, PokeApiService pokeApiService) {
        this.trainerRepository = trainerRepository;
        this.pokeApiService = pokeApiService;
    }

    public Trainer createTrainer(Trainer trainer) {
        List<Long> pokemonIds = trainer.getTeam();

        // Consultar la información de los Pokémon desde la API y actualizar los identificadores en el equipo del entrenador
        List<Long> updatedPokemonIds = new ArrayList<>();
        for (Long pokemonId : pokemonIds) {
            Pokemon pokemon = pokeApiService.getPokemon(pokemonId.intValue());
            // Guardar el Pokémon en la API o en la base de datos si es necesario
            // ...

            // Agregar el identificador actualizado al equipo del entrenador
            updatedPokemonIds.add((long) pokemon.getId());
        }

        // Actualizar el equipo del entrenador con los identificadores actualizados
        trainer.setTeam(updatedPokemonIds);

        // Guardar el entrenador en la base de datos
        Trainer savedTrainer = trainerRepository.save(trainer);

        return savedTrainer;
    }
    public Trainer getTrainer(int trainerId) {
        // Lógica para obtener el entrenador desde el repositorio
        return trainerRepository.findById(trainerId).orElse(null);
    }
    public Trainer updateTrainer(int trainerId, Trainer updatedTrainer) {
        Trainer existingTrainer = getTrainer(trainerId);
        existingTrainer.setName(updatedTrainer.getName());
        existingTrainer.setTeam(updatedTrainer.getTeam());
        existingTrainer.setAge(updatedTrainer.getAge());
        // Actualiza cualquier otro campo necesario

        return trainerRepository.save(existingTrainer);
    }

    public void deleteTrainer(int trainerId) {
        Trainer existingTrainer = getTrainer(trainerId);
        trainerRepository.delete(existingTrainer);
    }
    public Trainer getTrainerbyid(int idtrainer) {
        return trainerRepository.findById(idtrainer)
                .orElseThrow(() -> new NotFoundException("Trainer not found with ID: " + idtrainer));
    }
}
