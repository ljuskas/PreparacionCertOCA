package com.certoca.colecciones;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IterationPerformance {
    /*
    Pruebas de Iteración
    Ejercicio

    Itera sobre todos los elementos de una colección y mide el tiempo necesario para completar la iteración.

    RESULTADOS: 

    -for each: GANA ArrayList
    -for : Gana Arraylist, linkedList no terminó la prueba.

     */
    public static void main(String[] args) {
        int size = 1_000_000;

        // Crear listas
        List<Integer> arrayList = new ArrayList<>(size);
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // Pruebas de iteración
        performIterationTests(arrayList, "ArrayList");
        performIterationTests(linkedList, "LinkedList");
    }

    private static void performIterationTests(List<Integer> list, String listType) {
        long startTime, endTime;

        // Iteración usando for-each
        startTime = System.nanoTime();
        for (int element : list) {
            // No hacer nada
        }
        endTime = System.nanoTime();
        System.out.println(listType + " - Iteración for-each: " + (endTime - startTime) + " ns");

        // Iteración usando un iterador
        startTime = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.nanoTime();
        System.out.println(listType + " - Iteración con índice: " + (endTime - startTime) + " ns");
    }
}
