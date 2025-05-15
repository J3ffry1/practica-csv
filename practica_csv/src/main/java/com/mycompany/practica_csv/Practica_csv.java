package com.mycompany.practica_csv;

import java.io.*;
import java.util.*;

public class Practica_csv {

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        
        do{
            System.out.println("SISTEMA DE PRODUCTOS");
            System.out.println("1:ingresa productos");
            System.out.println("2:modificar productos ");
            System.out.println("3:mostar desde arcgivo");
            System.out.println("4:salir");
            System.out.println("eliga una opcion");
            while (!scanner.hasNextInt()) { 
                System.out.println("Por favor, ingrese un numero validoentre (1-4).");
                scanner.next();
            }
            op =scanner.nextInt();
          switch(op){
              case 1:
                          System.out.print("Cuantos productos quieres ingresar? ");
                          while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); 
            }
        int cantidadProductos = scanner.nextInt();
       

        for (int i = 0; i < cantidadProductos; i++) {
            System.out.println("\nProducto #" + (i + 1));
            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            System.out.print("Nombre: ");
            String nombre = scanner.next();

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); 

            productos.add(new Producto(nombre, precio, cantidad));
        }
         try (FileWriter writer = new FileWriter("productos.csv", true)) {
                        for (Producto p : productos) {
                            writer.write(p.toCSV() + "\n");
                        }
                        System.out.println("Productos guardados correctamente en 'productos.csv'.");
                    } catch (IOException e) {
                        System.out.println("Error al guardar: " + e.getMessage());
                    }
                    break;
              case 2:
                  System.out.println("Seleccione el producto a modificar:");
                    for (int i = 0; i < productos.size(); i++) {
                        System.out.println((i + 1) + ": " + productos.get(i).getNombre());
                    }

                    int productoId = scanner.nextInt() - 1; 
                    Producto productoModificar = productos.get(productoId);

                    System.out.println("Modificar precio o cantidad?");
                    System.out.println("1: Modificar precio");
                    System.out.println("2: Modificar cantidad");
                    int modificacion = scanner.nextInt();

                    if (modificacion == 1) {
                        System.out.print("Nuevo precio: ");
                        double nuevoPrecio = scanner.nextDouble();
                        productoModificar.setPrecio(nuevoPrecio);
                    } else if (modificacion == 2) {
                        System.out.print("Nueva cantidad: ");
                        int nuevaCantidad = scanner.nextInt();
                        productoModificar.setCantidad(nuevaCantidad);
                    }
                    System.out.println("Producto modificado correctamente.");
                  break;
              case 3:
                  System.out.println("los productos guardados son ");
                    try (BufferedReader reader = new BufferedReader(new FileReader("productos.csv"))) {
                        String linea;
                        while ((linea = reader.readLine()) != null) {
                            Producto p = Producto.fromCSV(linea);
                            p.mostrar();
                        }
                    } catch (IOException e) {
                        System.out.println("Error al leer: " + e.getMessage());
                    }
                  break;
              case 4:
                  System.out.println("saiendo del sistema ");
                  break;
              case 5:
                  
              default:
                  System.out.println("opcion invalida");
                  break;
                  
          } 
    }while(op !=4);
        scanner.close();
}
}