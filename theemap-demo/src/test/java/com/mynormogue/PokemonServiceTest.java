package com.mynormogue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mynormogue.bean.Pokemon;
import com.mynormogue.controller.PokemonService;

public class PokemonServiceTest {

  @Test
  public void testAddPokemonToCollection() {
    Map<String, Pokemon> pokemonMap = new HashMap<>();
    List<Pokemon> pokemonList = new ArrayList<>();
    pokemonList.add(new Pokemon("Pikachu", 25, "Electric", "", "Mouse Pokémon", 0.4, 6.0, "Static", 1, false));

    PokemonService pokemonService = new PokemonService(pokemonMap, pokemonList);
    pokemonService.addPokemonToCollection("Pikachu");

    assertTrue(pokemonMap.containsKey("Pikachu")); // Verifica que el Pokémon se agregó
    assertEquals(1, pokemonMap.size()); // Verifica que solo hay un Pokémon en la colección
  }

  @Test
  public void testAddPokemonToCollection_Duplicate() {
    Map<String, Pokemon> pokemonMap = new HashMap<>();
    List<Pokemon> pokemonList = new ArrayList<>();
    pokemonList.add(new Pokemon("Pikachu", 25, "Electric", "", "Mouse Pokémon", 0.4, 6.0, "Static", 1, false));

    PokemonService pokemonService = new PokemonService(pokemonMap, pokemonList);
    pokemonService.addPokemonToCollection("Pikachu"); // Agrega por primera vez
    pokemonService.addPokemonToCollection("Pikachu"); // Intenta agregar de nuevo

    assertEquals(1, pokemonMap.size()); // Verifica que no se agregó un duplicado
  }

  @Test
  public void testShowPokemonData() {
    Map<String, Pokemon> pokemonMap = new HashMap<>();
    List<Pokemon> pokemonList = new ArrayList<>();
    Pokemon pikachu = new Pokemon("Pikachu", 25, "Electric", "", "Mouse Pokémon", 0.4, 6.0, "Static", 1, false);
    pokemonMap.put("Pikachu", pikachu);

    PokemonService pokemonService = new PokemonService(pokemonMap, pokemonList);
    pokemonService.showPokemonData("Pikachu"); // Debería imprimir los datos de Pikachu
  }

  @Test
  public void testShowPokemonData_NotFound() {
    Map<String, Pokemon> pokemonMap = new HashMap<>();
    List<Pokemon> pokemonList = new ArrayList<>();

    PokemonService pokemonService = new PokemonService(pokemonMap, pokemonList);
    pokemonService.showPokemonData("Pikachu"); // Debería mostrar un error
  }

  @Test
  public void testShowUserCollectionByType1() {
    Map<String, Pokemon> pokemonMap = new HashMap<>();
    List<Pokemon> pokemonList = new ArrayList<>();
    pokemonMap.put("Pikachu",
        new Pokemon("Pikachu", 25, "Electric", "", "Mouse Pokémon", 0.4, 6.0, "Static", 1, false));
    pokemonMap.put("Bulbasaur",
        new Pokemon("Bulbasaur", 1, "Grass", "Poison", "Seed Pokémon", 0.7, 6.9, "Overgrow", 1, false));

    PokemonService pokemonService = new PokemonService(pokemonMap, pokemonList);
    pokemonService.showUserCollectionByType1(); // Debería mostrar Pikachu y Bulbasaur ordenados por Tipo 1
  }

  @Test
  public void testShowUserCollectionByType1_Empty() {
    Map<String, Pokemon> pokemonMap = new HashMap<>();
    List<Pokemon> pokemonList = new ArrayList<>();

    PokemonService pokemonService = new PokemonService(pokemonMap, pokemonList);
    pokemonService.showUserCollectionByType1(); // Debería mostrar un mensaje de colección vacía
  }

  @Test
  public void testShowAllPokemonByType1() {
    Map<String, Pokemon> pokemonMap = new HashMap<>();
    List<Pokemon> pokemonList = new ArrayList<>();
    pokemonList.add(new Pokemon("Pikachu", 25, "Electric", "", "Mouse Pokémon", 0.4, 6.0, "Static", 1, false));
    pokemonList.add(new Pokemon("Bulbasaur", 1, "Grass", "Poison", "Seed Pokémon", 0.7, 6.9, "Overgrow", 1, false));

    PokemonService pokemonService = new PokemonService(pokemonMap, pokemonList);
    pokemonService.showAllPokemonByType1(); // Debería mostrar Pikachu y Bulbasaur ordenados por Tipo 1
  }

  @Test
  public void testShowAllPokemonByType1_Empty() {
    Map<String, Pokemon> pokemonMap = new HashMap<>();
    List<Pokemon> pokemonList = new ArrayList<>();

    PokemonService pokemonService = new PokemonService(pokemonMap, pokemonList);
    pokemonService.showAllPokemonByType1(); // Debería mostrar un mensaje de que no hay Pokémon
  }
}
