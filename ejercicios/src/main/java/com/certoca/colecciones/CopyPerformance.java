package com.certoca.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CopyPerformance {
    /*
    Pruebas de Copia
    Ejercicio

    Copia una colección a otra y mide el tiempo necesario para realizar la copia.

    RESULTADOS:
    Copia más rápido: ArrayList
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

        // Pruebas de copia
        performCopyTests(arrayList, "ArrayList");
        performCopyTests(linkedList, "LinkedList");
    }

    private static void performCopyTests(List<Integer> list, String listType) {
        long startTime, endTime;

        // Inicializar la lista de destino con el tamaño adecuado
        List<Integer> copyList = new ArrayList<>(Collections.nCopies(list.size(), 0));

        // Copiar la lista
        startTime = System.nanoTime();
        Collections.copy(copyList, list);
        endTime = System.nanoTime();
        System.out.println(listType + " - Copiar la lista: " + (endTime - startTime) + " ns");
    }
}
