package com.certoca.colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Colecciones {
    
    public static void arrayListEjemplo(){
        //Podemos acceder por indices a los elementos
        System.out.println("PRUEBAS ARRAYLIST");
        ArrayList<String> estudiantes = new ArrayList<>();
        estudiantes.add("Juan");
        estudiantes.add("María");
        estudiantes.add("Pedro");

        //Listamos la lista
        imprimirColeccion(estudiantes,"Listando estudiantes:");


        //Prueba eliminaciones
        estudiantes.remove(0);
        estudiantes.remove("Pedro");
        imprimirColeccion(estudiantes,"\nDespués de eliminar:");

    }

    public static void linkedListEjemplo(){
        // Podemos agregar o eliminar elementos desde cualquier posición
        System.out.println("\nPRUEBAS LINKEDLIST");
        LinkedList<String> listaEspera = new LinkedList<>();
        listaEspera.add("Cliente 1");
        listaEspera.add("Cliente 2");
        listaEspera.add("Cliente 3");

        imprimirColeccion(listaEspera, "\nListando listaEspera:");


        listaEspera.removeLast();
        listaEspera.removeFirst();
        imprimirColeccion(listaEspera, "\nEliminamos primer y ultimo elemento:");


        listaEspera.addLast("Cliente 4");
        listaEspera.add("Cliente 5");
        listaEspera.addFirst("Cliente 6");
        imprimirColeccion(listaEspera, "\nInsertamos nuevos elementos en diferentes posiciones:");
    }

    public static void main(String[] args) {
        arrayListEjemplo();
        linkedListEjemplo();
    }

    public static <T> void imprimirColeccion(Collection<T> coleccion, String mensaje) {
        System.out.println(mensaje);
        coleccion.forEach(System.out::println);
    }

}
