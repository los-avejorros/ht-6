package com.mynormogue.utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.mynormogue.bean.Pokemon;

public class CSVReader {
  public static List<Pokemon> readPokemonFromCSV(String filePath) {
    List<Pokemon> pokemonList = new ArrayList<>();

    try (Reader reader = new FileReader(filePath);
        CSVParser csvParser = new CSVParser(reader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

      for (CSVRecord csvRecord : csvParser) {
        String name = csvRecord.get("Name");
        int pokedexNumber = Integer.parseInt(csvRecord.get("Pokedex number"));
        String type1 = csvRecord.get("Type1");
        String type2 = csvRecord.get("Type2");
        String classification = csvRecord.get("Classification");
        double height = Double.parseDouble(csvRecord.get("Height (m)"));
        double weight = Double.parseDouble(csvRecord.get("Weight (kg)"));
        String abilities = csvRecord.get("Abilities");
        int generation = Integer.parseInt(csvRecord.get("Generation"));
        boolean isLegendary = Boolean.parseBoolean(csvRecord.get("Legendary Status"));

        Pokemon pokemon = new Pokemon(name, pokedexNumber, type1, type2, classification, height, weight, abilities,
            generation, isLegendary);
        pokemonList.add(pokemon);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return pokemonList;
  }

}
