package com.certoca.colecciones;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class MapPerformance {
    /*
    Mapas (HashMap vs TreeMap)
    Ejercicio

    Crea un mapa de 1 millón de entradas aleatorias y realiza las siguientes operaciones:

        Añadir una entrada.
        Obtener un valor por clave.
        Eliminar una entrada.
     */
    public static void main(String[] args) {
        int size = 1_000_000;
        Random random = new Random();

        // Crear mapas
        Map<Integer, Integer> hashMap = new HashMap<>(size);
        Map<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < size; i++) {
            int key = random.nextInt();
            int value = random.nextInt();
            hashMap.put(key, value);
            treeMap.put(key, value);
        }

        // Pruebas de rendimiento
        performTests(hashMap, "HashMap");
        performTests(treeMap, "TreeMap");
    }

    private static void performTests(Map<Integer, Integer> map, String mapType) {
        Random random = new Random();
        int key = random.nextInt();
        int value = random.nextInt();
        long tiempoTotal = 0;

        long startTime, endTime;

        // Añadir una entrada
        startTime = System.nanoTime();
        map.put(key, value);
        endTime = System.nanoTime();
        System.out.println(mapType + " - Añadir una entrada: " + (endTime - startTime) + " ns");
        tiempoTotal += endTime - startTime;

        // Obtener un valor por clave
        startTime = System.nanoTime();
        map.get(key);
        endTime = System.nanoTime();
        System.out.println(mapType + " - Obtener un valor por clave: " + (endTime - startTime) + " ns");
        tiempoTotal += endTime - startTime;

        // Eliminar una entrada
        startTime = System.nanoTime();
        map.remove(key);
        endTime = System.nanoTime();
        System.out.println(mapType + " - Eliminar una entrada: " + (endTime - startTime) + " ns");
        tiempoTotal += endTime - startTime;

        System.out.println("TIEMPO TOTAL "+ mapType + " " + String.valueOf(tiempoTotal) +"\n");
    }
}
