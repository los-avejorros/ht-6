package com.mynormogue.system;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.mynormogue.bean.Pokemon;
import com.mynormogue.controller.MapFactory;
import com.mynormogue.controller.PokemonService;
import com.mynormogue.utils.CSVReader;

/**
 * Hello world!
 * @author mogue - 241257
 *
 */
public class App {
    public static void main(String[] args) {
        String filePath = "pokemon_data_pokeapi.csv";
        List<Pokemon> pokemonList = CSVReader.readPokemonFromCSV(filePath);
        boolean flag = true;

        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione la implementación de Map: 1) HashMap, 2) TreeMap, 3) LinkedHashMap");
        int choice = sc.nextInt();
        Map<String, Pokemon> pokemonMap = MapFactory.createMap(choice);

        PokemonService pokemonService = new PokemonService(pokemonMap, pokemonList);

        // Menú de operaciones
        while (flag) {
            System.out.println("\n# --- [Menú de Pokémon] --- #");
            System.out.println("1. Agregar un Pokémon a la colección");
            System.out.println("2. Mostrar los datos de un Pokémon");
            System.out.println("3. Mostrar la colección del usuario ordenada por Tipo 1");
            System.out.println("4. Mostrar todos los Pokémon ordenados por Tipo 1");
            System.out.println("5. Mostrar Pokémon por habilidad");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre del Pokémon a agregar: ");
                    String name = sc.next();
                    pokemonService.addPokemonToCollection(name);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del Pokémon a mostrar: ");
                    String pokemonName = sc.next();
                    pokemonService.showPokemonData(pokemonName);
                    break;
                case 3:
                    pokemonService.showUserCollectionByType1();
                    break;
                case 4:
                    pokemonService.showAllPokemonByType1();
                    break;
                case 5:
                    System.out.print("Ingrese la habilidad a buscar: ");
                    String ability = sc.next();
                    pokemonService.showPokemonByAbility(ability);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    flag = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        sc.close();
    }
}
