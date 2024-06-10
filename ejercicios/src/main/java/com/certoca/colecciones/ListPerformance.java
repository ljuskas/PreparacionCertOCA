package com.certoca.colecciones;
//PRUEBA DE PERFORMANCE ArrayList vs LinkedList
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListPerformance {
    /*
    PRUEBA DE PERFORMANCE ArrayList vs LinkedList

    Ejercicio:
    Crea una lista de 1 millón de elementos aleatorios y realiza las siguientes operaciones:

        Añadir un elemento al final.
        Añadir un elemento al inicio.
        Acceder al elemento en la posición 500,000.
        Eliminar el elemento en la posición 500,000.

        RESULTADOS:
        -Añade all:      Arraylist
        -Añade final:    LinkedList
        -Añade inicio:   LinkedList
        -Acceso:         ArrayList
        -Elimina:        ArrayList
        Tiempo total todas las pruebas: ArrayList
    */
    public static void main(String[] args) {
        int size = 1_000_000;
        Random random = new Random();

        // Pruebas de rendimiento
        performTests(size, random, "ArrayList");
        performTests(size, random, "LinkedList");
    }


    private static void performTests(int size, Random random, String listType) {
        List<Integer> list = listType.equals("ArrayList") ? new ArrayList<>(size) : new LinkedList<>();
        long tiempoTotal = 0;
        long startTime, endTime;

        // Añadir todos los elementos
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt());
        }
        endTime = System.nanoTime();
        System.out.println(listType + " - Añadir todos los elementos: " + (endTime - startTime) + " ns");
        tiempoTotal += endTime - startTime;

        // Añadir al final
        startTime = System.nanoTime();
        list.add(0);
        endTime = System.nanoTime();
        System.out.println(listType + " - Añadir al final: " + (endTime - startTime) + " ns");
        tiempoTotal += endTime - startTime;

        // Añadir al inicio
        startTime = System.nanoTime();
        list.add(0, 0);
        endTime = System.nanoTime();
        System.out.println(listType + " - Añadir al inicio: " + (endTime - startTime) + " ns");
        tiempoTotal += endTime - startTime;

        // Acceder al elemento 500,000
        startTime = System.nanoTime();
        list.get(500_000);
        endTime = System.nanoTime();
        System.out.println(listType + " - Acceder al elemento 500,000: " + (endTime - startTime) + " ns");
        tiempoTotal += endTime - startTime;

        // Eliminar el elemento 500,000
        startTime = System.nanoTime();
        list.remove(500_000);
        endTime = System.nanoTime();
        System.out.println(listType + " - Eliminar el elemento 500,000: " + (endTime - startTime) + " ns");
        tiempoTotal += endTime - startTime;

        System.out.println("TIEMPO TOTAL "+ listType + " " + String.valueOf(tiempoTotal) +"\n");

    }
}
