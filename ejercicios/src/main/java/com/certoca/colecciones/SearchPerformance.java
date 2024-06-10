package com.certoca.colecciones;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SearchPerformance {
    public static void main(String[] args) {
        /*
        Pruebas de Búsqueda
        Ejercicio

        Comprueba el tiempo necesario para buscar un elemento en una colección.

        RESULTADOS
        -Busqueda: HashSet
         */
        int size = 1_000_000;
        Random random = new Random();

        // Crear conjuntos
        Set<Integer> hashSet = new HashSet<>(size);
        Set<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            int num = random.nextInt();
            hashSet.add(num);
            treeSet.add(num);
        }

        // Pruebas de búsqueda
        performSearchTests(hashSet, "HashSet");
        performSearchTests(treeSet, "TreeSet");
    }

    private static void performSearchTests(Set<Integer> set, String setType) {
        Random random = new Random();
        int num = random.nextInt();

        long startTime, endTime;

        // Buscar un elemento
        startTime = System.nanoTime();
        set.contains(num);
        endTime = System.nanoTime();
        System.out.println(setType + " - Buscar un elemento: " + (endTime - startTime) + " ns");
    }
}
