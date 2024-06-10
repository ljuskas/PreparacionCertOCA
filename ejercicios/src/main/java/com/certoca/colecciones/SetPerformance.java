package com.certoca.colecciones;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetPerformance {
    /*
    PRUEBA DE PERFORMANCE Conjuntos (HashSet vs TreeSet)
    Ejercicio

    Crea un conjunto de 1 millón de elementos aleatorios y realiza las siguientes operaciones:

        -Añadir un elemento.
        -Comprobar si un elemento existe.
        -Eliminar un elemento.

        RESULTADOS:
        -Añade:                 HashSet
        -Comprobar existencia:  HashSet
        -Eliminar:              HashSet
     */

    public static void main(String[] args) {
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

        // Pruebas de rendimiento
        performTests(hashSet, "HashSet");
        performTests(treeSet, "TreeSet");
    }

    private static void performTests(Set<Integer> set, String setType) {
        Random random = new Random();
        int num = random.nextInt();
        long tiempoTotal = 0;

        long startTime, endTime;

        // Añadir un elemento
        startTime = System.nanoTime();
        set.add(num);
        endTime = System.nanoTime();
        System.out.println(setType + " - Añadir un elemento: " + (endTime - startTime) + " ns");
        tiempoTotal += endTime - startTime;

        // Comprobar si un elemento existe
        startTime = System.nanoTime();
        set.contains(num);
        endTime = System.nanoTime();
        System.out.println(setType + " - Comprobar si un elemento existe: " + (endTime - startTime) + " ns");
        tiempoTotal += endTime - startTime;

        // Eliminar un elemento
        startTime = System.nanoTime();
        set.remove(num);
        endTime = System.nanoTime();
        System.out.println(setType + " - Eliminar un elemento: " + (endTime - startTime) + " ns");
        tiempoTotal += endTime - startTime;

        System.out.println("TIEMPO TOTAL "+ setType + " " + String.valueOf(tiempoTotal) +"\n");
    }
}
