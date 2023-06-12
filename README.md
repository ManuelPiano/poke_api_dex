# POKE API DEX
Rest api creada como prueba técnica para Momotolabs

[![Build Status](https://app.travis-ci.com/ManuelPiano/poke_api_dex.svg?branch=master)](https://app.travis-ci.com/ManuelPiano/poke_api_dex)
[![Contributors](https://img.shields.io/github/contributors/ManuelPiano/poke_api_dex.svg)](https://github.com/ManuelPiano/poke_api_dex/graphs/contributors)



# Definición de la prueba
Prueba Técnica - Desarrollo de API de Gestión de equipos con la Poke API
## Objetivos de la prueba:
Consumir la Poké API para obtener información detallada sobre los Pokémon.
Implementar endpoints que permitan a los usuarios realizar diversas acciones relacionadas con los Pokémon y los entrenadores.
Aplicar las reglas de construcción de equipos Pokémon en la lógica de la API.

# Desarrollo 
Este proyecto es una API que permite administrar entrenadores y sus equipos de Pokémon. Permite realizar operaciones CRUD (crear, leer, actualizar y eliminar) sobre los entrenadores y sus equipos, y también proporciona la funcionalidad para obtener información detallada de los Pokémon a través de la integración con la PokéAPI.

## Funcionalidades principales
* Crear un entrenador: Permite crear un nuevo entrenador especificando su nombre, edad y un equipo de Pokémon.
* Obtener información de un entrenador: Permite obtener la información detallada de un entrenador específico, incluyendo su nombre, edad y el equipo de Pokémon asociado.
* Actualizar un entrenador: Permite actualizar los datos de un entrenador existente, como su nombre, edad y equipo de Pokémon.
* Eliminar un entrenador: Permite eliminar un entrenador y todos los datos relacionados, incluyendo su equipo de Pokémon.
* Obtener información detallada de un Pokémon: Permite obtener información detallada de un Pokémon específico, como su nombre, tipo, habilidades, estadísticas, entre otros.
* Obtener equipo de Pokémon de un entrenador: Permite obtener el equipo de Pokémon completo de un entrenador, incluyendo la información detallada de cada Pokémon.
* Agregar Pokémon al equipo de un entrenador: Permite agregar un Pokémon al equipo de un entrenador existente.
* Eliminar Pokémon del equipo de un entrenador: Permite eliminar un Pokémon específico del equipo de un entrenador.

## Tecnologías utilizadas
El proyecto utiliza las siguientes tecnologías:

* Java: Lenguaje de programación principal.
* Java Version: 17
* Spring Boot: Framework de desarrollo de aplicaciones Java.
* Spring Data JPA: Proporciona la capa de persistencia y acceso a la base de datos.
* Hibernate: Framework de mapeo objeto-relacional para el manejo de la base de datos.
* MySQL: Sistema de gestión de bases de datos relacional.
* RestTemplate: Cliente HTTP para realizar solicitudes a la PokéAPI.
* Swagger: Herramienta para la documentación y prueba de la API.
* Git: Sistema de control de versiones para el desarrollo colaborativo.

## Instrucciones de instalación
* Clona el repositorio del proyecto desde GitHub: `git clone https://github.com/ManuelPiano/poke_api_dex.git`
* Abre el proyecto en tu entorno de desarrollo preferido (por ejemplo, IntelliJ IDEA, Eclipse, Visual Studio Code, etc.).
* Configura la base de datos MySQL con los datos de conexión adecuados en el archivo `application.properties`.
* Ejecuta el proyecto desde tu entorno de desarrollo o utilizando el comando ./mvnw spring-boot:run desde la línea de comandos.
* Accede a la documentación de la API a través de la URL (http://localhost:8080/swagger-ui/index.html#/).

# Ejemplos de Uso

## Crea un entrenador con su equipo de pokemon en Swagger

<img width="333" alt="image" src="https://github.com/ManuelPiano/poke_api_dex/assets/101200587/67d21e82-5cd2-4c9b-bbd6-df5224dcf99f">

colocando el siguiente Json 
```
{
  "name": "Ash Ketchum",
  "age": 16,
  "team": [1, 4, 7]
}
```

## Obten la información del entrenador por ID
retorna la información de los entrenadores que ya tenemos
<img width="906" alt="image" src="https://github.com/ManuelPiano/poke_api_dex/assets/101200587/5a25f3c5-8685-4b3a-835a-777ff93098dd">

## Obten una lista del equipo de pokemon del entrenador con sus caractéristicas
<img width="903" alt="image" src="https://github.com/ManuelPiano/poke_api_dex/assets/101200587/946db7c3-070b-48f0-98c7-ca1af5b508cc">

## Modifica la información del Entrenador pokemon existente por medio de su ID
<img width="428" alt="image" src="https://github.com/ManuelPiano/poke_api_dex/assets/101200587/38ba3ac6-576e-4aaa-b0be-50add77fd7fe">

## Elimina un Entrenador por medio de su Id
<img width="385" alt="image" src="https://github.com/ManuelPiano/poke_api_dex/assets/101200587/cce13c98-8446-4f7d-93e8-c2ac0dbb3074">

## Consulta Pokemons por Id
puedes revisar la info en la pokeapi (https://pokeapi.co/)
<img width="913" alt="image" src="https://github.com/ManuelPiano/poke_api_dex/assets/101200587/9e92e11a-7d71-4dc9-ba38-01a307dc1360">

## Consulta Lista de pokemones por tipo
### Actualmente hay 20 tipos de pokemones
A continuacion la lista
* normal
* fighting
* flying
* poison
* ground
* rock
* bug
* ghost
* steel
* fire
* water
* grass
* electric
* psychic
* ice
* dragon
* dark
* fairy
* unknown
* shadow
### Puedes seleccionarlos por ID o por nombre

<img width="906" alt="image" src="https://github.com/ManuelPiano/poke_api_dex/assets/101200587/c3b56885-f357-40f1-baf5-c2ef17dce1b5">

# Patrones de Diseño
En el proyecto se han implementado los siguientes patrones de diseño:

Patrón de Diseño Factory: Se utiliza el patrón Factory para crear instancias de objetos de diferentes tipos de manera centralizada. Por ejemplo, en el servicio PokeApiService, se utiliza un RestTemplateFactory para crear instancias de RestTemplate y establecer la configuración necesaria.

Patrón de Diseño DTO (Data Transfer Object): Se utiliza el patrón DTO para transferir datos entre capas o componentes de la aplicación. En este caso, se definen clases DTO como `Pokemon` y `Trainer` para representar la información que se envía o recibe desde las APIs.

Patrón de Diseño Repositorio: Se utiliza el patrón Repositorio para abstraer el acceso a la base de datos y proporcionar métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar). En el proyecto, se utiliza una interfaz TrainerRepository que define los métodos para interactuar con la entidad Trainer en la base de datos.

Patrón de Diseño Inyección de Dependencias: Se utiliza el patrón Inyección de Dependencias para lograr una alta modularidad y facilitar la prueba unitaria de los componentes. En el proyecto, se utiliza la anotación @Autowired para inyectar dependencias en los componentes, como el TrainerService, que depende del TrainerRepository y el PokeApiService.

Estos patrones de diseño permiten mejorar la estructura y la organización del código, promoviendo la reutilización, la mantenibilidad y la escalabilidad de la aplicación.

# Contacto
Si tienes alguna pregunta o sugerencia sobre este proyecto, puedes contactarme a través de mi dirección de correo electrónico: manuel.alvarado21@itca.edu.sv .
