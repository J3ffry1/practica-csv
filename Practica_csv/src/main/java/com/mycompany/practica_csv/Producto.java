
package com.mycompany.practica_csv;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

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

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
