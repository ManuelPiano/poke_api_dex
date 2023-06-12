package com.pokeapi.prueba.Exceptions;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PokemonNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(PokemonNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Map<String, String> exceptionHandler(PokemonNotFoundException exception) {
    Map<String, String> errorMap = new HashMap<>();
    errorMap.put("Error message: ", exception.getMessage());
    return errorMap;
  }
}
