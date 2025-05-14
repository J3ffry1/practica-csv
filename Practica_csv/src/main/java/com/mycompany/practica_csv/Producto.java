/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_csv;

/**
 *
 * @author jeffry
 */
 public class Producto {
    String nombre;
    double precio;
    int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String toCSV() {
        return nombre + "," + precio + "," + cantidad;
    }

    public static Producto fromCSV(String linea) {
        String[] partes = linea.split(",");
        String nombre = partes[0];
        double precio = Double.parseDouble(partes[1]);
        int cantidad = Integer.parseInt(partes[2]);
        return new Producto(nombre, precio, cantidad);
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre + " | Precio: " + precio + " | Cantidad: " + cantidad);
    }
}
   

