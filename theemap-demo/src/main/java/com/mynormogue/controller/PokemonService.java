package com.mynormogue.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mynormogue.bean.Pokemon;

public class PokemonService {
  private Map<String, Pokemon> pokemonMap; // Mapa para almacenar los Pokémon
  private List<Pokemon> allPokemonList; // Lista con todos los Pokémon leídos del archivo CSV

  public PokemonService(Map<String, Pokemon> pokemonMap, List<Pokemon> allPokemonList) {
    this.pokemonMap = pokemonMap;
    this.allPokemonList = allPokemonList;
  }

  /**
   * Método para agregar un Pokémon a la colección del usuario.
   * 
   * @param name Nombre del Pokémon a agregar.
   */
  public void addPokemonToCollection(String name) {
    // Buscar el Pokémon en la lista completa
    Pokemon pokemon = allPokemonList.stream()
        .filter(p -> p.getName().equalsIgnoreCase(name))
        .findFirst()
        .orElse(null);

    if (pokemon == null) {
      System.out.println("Error: Pokémon no encontrado en los datos leídos.");
    } else if (pokemonMap.containsKey(name)) {
      System.out.println("Error: El Pokémon ya está en tu colección.");
    } else {
      pokemonMap.put(name, pokemon);
      System.out.println("Pokémon agregado a tu colección: " + name);
    }
  }

  /**
   * Método para mostrar los datos de un Pokémon.
   * 
   * @param name Nombre del Pokémon a mostrar.
   */
  public void showPokemonData(String name) {
    Pokemon pokemon = pokemonMap.get(name);
    if (pokemon != null) {
      System.out.println("Datos de " + name + ":");
      System.out.println("  - Número en la Pokédex: " + pokemon.getPokedexNumber());
      System.out.println("  - Tipo 1: " + pokemon.getType1());
      System.out.println("  - Tipo 2: " + pokemon.getType2());
      System.out.println("  - Clasificación: " + pokemon.getClassification());
      System.out.println("  - Altura: " + pokemon.getHeight() + " m");
      System.out.println("  - Peso: " + pokemon.getWeight() + " kg");
      System.out.println("  - Habilidades: " + pokemon.getAbilities());
      System.out.println("  - Generación: " + pokemon.getGeneration());
      System.out.println("  - Estado Legendario: " + (pokemon.isLegendary() ? "Sí" : "No"));
    } else {
      System.out.println("Error: El Pokémon no está en tu colección.");
    }
  }

  /**
   * Método para mostrar los nombres y tipos primarios de los Pokémon en la
   * colección del usuario, ordenados por tipo1.
   */
  public void showUserCollectionByType1() {
    if (pokemonMap.isEmpty()) {
      System.out.println("Tu colección está vacía.");
      return;
    }

    // Crear una lista de Pokémon ordenada por tipo1
    List<Pokemon> sortedPokemon = pokemonMap.values().stream()
        .sorted(Comparator.comparing(Pokemon::getType1))
        .collect(Collectors.toList());

    System.out.println("Tu colección ordenada por Tipo 1:");
    for (Pokemon pokemon : sortedPokemon) {
      System.out.println("  - " + pokemon.getName() + " (Tipo 1: " + pokemon.getType1() + ")");
    }
  }

  /**
   * Método para mostrar los nombres y tipos primarios de todos los Pokémon leídos
   * del archivo, ordenados por tipo1.
   */
  public void showAllPokemonByType1() {
    if (allPokemonList.isEmpty()) {
      System.out.println("No se han cargado Pokémon desde el archivo.");
      return;
    }

    // Crear una lista de Pokémon ordenada por tipo1
    List<Pokemon> sortedPokemon = allPokemonList.stream()
        .sorted(Comparator.comparing(Pokemon::getType1))
        .collect(Collectors.toList());

    System.out.println("Todos los Pokémon ordenados por Tipo 1:");
    for (Pokemon pokemon : sortedPokemon) {
      System.out.println("  - " + pokemon.getName() + " (Tipo 1: " + pokemon.getType1() + ")");
    }
  }

  /**
   * Método para mostrar los nombres de los Pokémon que tienen una habilidad
   * específica.
   * 
   * @param ability Habilidad a buscar.
   */
  public void showPokemonByAbility(String ability) {
    List<Pokemon> pokemonWithAbility = allPokemonList.stream()
        .filter(p -> p.getAbilities().toLowerCase().contains(ability.toLowerCase()))
        .collect(Collectors.toList());

    if (pokemonWithAbility.isEmpty()) {
      System.out.println("No se encontraron Pokémon con la habilidad: " + ability);
    } else {
      System.out.println("Pokémon con la habilidad '" + ability + "':");
      for (Pokemon pokemon : pokemonWithAbility) {
        System.out.println("  - " + pokemon.getName());
      }
    }
  }
}
