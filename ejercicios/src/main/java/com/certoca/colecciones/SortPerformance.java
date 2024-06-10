package com.certoca.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SortPerformance {
    /*
    Pruebas de Ordenamiento
    Ejercicio

    Ordena una lista de elementos aleatorios y mide el tiempo necesario para completar el ordenamiento.

    RESULTADOS:
    -Ordenamiento: ArrayList
     */
    public static void main(String[] args) {
        int size = 1_000_000;
        Random random = new Random();

        // Crear listas
        List<Integer> arrayList = new ArrayList<>(size);
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            int num = random.nextInt();
            arrayList.add(num);
            linkedList.add(num);
        }

        // Pruebas de ordenamiento
        performSortTests(arrayList, "ArrayList");
        performSortTests(linkedList, "LinkedList");
    }

    private static void performSortTests(List<Integer> list, String listType) {
        long startTime, endTime;

        // Ordenar la lista
        startTime = System.nanoTime();
        Collections.sort(list);
        endTime = System.nanoTime();
        System.out.println(listType + " - Ordenar la lista: " + (endTime - startTime) + " ns");
    }
}
