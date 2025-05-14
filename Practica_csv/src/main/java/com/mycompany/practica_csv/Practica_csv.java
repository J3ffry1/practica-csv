package com.mycompany.practica_csv;

import java.io.*;
import java.util.*;

public class Practica_csv {

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Cuantos productos quieres ingresar? ");
        int cantidadProductos = scanner.nextInt();
        scanner.nextLine(); // limpia el salto de línea

        for (int i = 0; i < cantidadProductos; i++) {
            System.out.println("\nProducto #" + (i + 1));
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Precio: ");
            double precio = scanner.nextDouble();

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // limpia salto

            productos.add(new Producto(nombre, precio, cantidad));
        }

        // Guardar en archivo CSV
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("productos.csv"));

            for (Producto p : productos) {
                writer.write(p.toCSV());
                writer.newLine();
            }

            writer.close();
            System.out.println("Productos guardados correctamente en 'productos.csv'.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }

        // Leer desde el archivo CSV
        System.out.println("\nProductos leidos desde el archivo:");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("productos.csv"));
            String linea;
            while ((linea = reader.readLine()) != null) {
                Producto p = Producto.fromCSV(linea);
                p.mostrar();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }

        scanner.close();
    }
}
