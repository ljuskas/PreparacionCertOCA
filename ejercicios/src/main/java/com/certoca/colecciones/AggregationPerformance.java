package com.certoca.colecciones;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class AggregationPerformance {
    /*
    Pruebas de Reducción/Agregación
    Ejercicio

    Realiza una operación de reducción o agregación, como sumar todos los elementos de una colección.

    RESULTADOS:
    Menor tiempo: ArrayList 
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

        // Pruebas de agregación
        performAggregationTests(arrayList, "ArrayList");
        performAggregationTests(linkedList, "LinkedList");
    }

    private static void performAggregationTests(List<Integer> list, String listType) {
        long startTime, endTime;

        // Sumar todos los elementos
        startTime = System.nanoTime();
        long sum = 0;
        for (int num : list) {
            sum += num;
        }
        endTime = System.nanoTime();
        System.out.println(listType + " - Sumar todos los elementos: " + (endTime - startTime) + " ns");
    }
}

