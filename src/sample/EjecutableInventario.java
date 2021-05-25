package sample;

import java.io.*;
import java.util.Scanner;


public class EjecutableInventario {
    public static void main(String[] args) {
        Inventario miInventario;
        miInventario = new Inventario("Teresa Garcia");
        File miArchivo;
        Scanner lectura;
        int i, n;
        String modelo;
        String marca;
        String sistemaOperativo;
        String info;
        String color;
        int precio;
        double tamanioPantalla;
        int memInterna;
        int anio;
        int resp[];
        double porcentaje;
        porcentaje = miInventario.indicaOcupacion();

        miArchivo = new File("Celulares.txt");
        try {
            lectura = new Scanner(miArchivo);
            n = lectura.nextInt();
            for (i = 1; i <= n; i++) {
                modelo = lectura.next();
                marca = lectura.next();
                sistemaOperativo = lectura.next();
                precio = lectura.nextInt();
                tamanioPantalla = lectura.nextDouble();
                memInterna = lectura.nextInt();
                anio = lectura.nextInt();
                color = lectura.next();
                resp = miInventario.altaCelular(modelo, marca, sistemaOperativo, precio, tamanioPantalla, memInterna, anio, color);
                if (resp[0] == -1) {
                    System.out.println("Alta no exitosa");
                } else {
                    System.out.println("Alta exitosa");
                }
            }
            lectura.close();
            System.out.println(miInventario.toString());

            //Buscando celulares por Sistema Operativo
            System.out.println("Busca celulares por Sistema Operativo");
            System.out.println("El numero de celulares con SO Android: " + miInventario.cuentaPorSO("Android"));
            System.out.println("El numero de celulares con SO iOS: " + miInventario.cuentaPorSO("iOS"));

            System.out.println("\n");

            //Buscando celulares por marca
            System.out.println("Busca celulares por marca");
            System.out.println("El numero de celulares de marca Apple: " + miInventario.cuentaPorMarca("Apple"));
            System.out.println("El numero de celulares de marca Samsung: " + miInventario.cuentaPorMarca("Samsung"));
            System.out.println("El numero de celulares de marca Xiaomi: " + miInventario.cuentaPorMarca("Xiaomi"));
            System.out.println("El numero de celulares de marca Huawei: " + miInventario.cuentaPorMarca("Huawei"));

            System.out.println("\n");

            //Imprimiendo el porcentaje de ocupación de la matriz
            System.out.println("Porcentaje de ocupación: ");
            System.out.println("El porcentaje de ocupación es de: " + porcentaje);
            System.out.println("\n");


            //Buscando celular por modelo:
            System.out.println("Busca celulares por modelo:");
            System.out.println(miInventario.buscaCelular("iPhoneSE"));
            System.out.println(miInventario.buscaCelular("GalaxyS20+"));
            System.out.println(miInventario.buscaCelular("Y9"));


        } catch (FileNotFoundException e) {
            System.out.println("Error, archivo no encontrado");
        }

    }
}
