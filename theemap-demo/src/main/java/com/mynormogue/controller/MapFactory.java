package com.mynormogue.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import com.mynormogue.bean.Pokemon;

public class MapFactory {
  public static Map<String, Pokemon> createMap(int choice) {
    switch (choice) {
      case 1:
        return new HashMap<>();
      case 2:
        return new TreeMap<>();
      case 3:
        return new LinkedHashMap<>();
      default:
        throw new IllegalArgumentException("Invalid choice");
    }
  }
}
