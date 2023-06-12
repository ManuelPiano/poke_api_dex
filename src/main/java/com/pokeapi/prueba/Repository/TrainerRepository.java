package com.pokeapi.prueba.Repository;

import com.pokeapi.prueba.Models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {}
