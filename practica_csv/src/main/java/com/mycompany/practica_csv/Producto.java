
package com.mycompany.practica_csv;

class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public static Producto fromCSV(String csv) {
        String[] data = csv.split(",");
        String nombre = data[0];
        double precio = Double.parseDouble(data[1]);
        int cantidad = Integer.parseInt(data[2]);
        return new Producto(nombre, precio, cantidad);
    }

    public String toCSV() {
        return nombre + "," + precio + "," + cantidad;
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre + ", Precio: " + precio + ", Cantidad: " + cantidad);
    }


    public String getNombre() {
        return nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}