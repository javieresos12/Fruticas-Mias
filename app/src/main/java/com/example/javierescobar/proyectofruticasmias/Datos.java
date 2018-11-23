package com.example.javierescobar.proyectofruticasmias;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Datos {
    private static String dbProducto = "Productos";
    private static String dbCliente = "Clientes";
    private static String dbVentas = "Ventas";

    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    public static ArrayList<Producto> productos = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Venta> ventas = new ArrayList<>();

    public static void agregarProducto(Producto p){
        databaseReference.child(dbProducto).child(p.getId()).setValue(p);
    }

    public static void agregarCliente(Cliente c){
        databaseReference.child(dbCliente).child(c.getId()).setValue(c);
    }

    public static void agregarVenta(Venta v){
        databaseReference.child(dbVentas).child(v.getId()).setValue(v);
    }

    public static void eliminarProducto(Producto p){
        databaseReference.child(dbProducto).child(p.getId()).removeValue();
    }

    public static void eliminarCliente(Cliente c){
        databaseReference.child(dbCliente).child(c.getId()).removeValue();
    }

    public static void eliminarVenta(Venta v){
        databaseReference.child(dbVentas).child(v.getId()).removeValue();
    }

    public static void editarProducto(Producto p){
        agregarProducto(p);
    }

    public static void editarCliente(Cliente c){
        agregarCliente(c);
    }

    public static void editarVenta(Venta v){
        agregarVenta(v);
    }

    public static String getId(){
        return databaseReference.push().getKey();
    }

    public static void setProductos(ArrayList<Producto> productos){
        Datos.productos = productos;
    }

    public static void setClientes(ArrayList<Cliente> clientes){
        Datos.clientes = clientes;
    }

    public static void setVentas(ArrayList<Venta> ventas){
        Datos.ventas = ventas;
    }

    public static ArrayList<Producto> obtenerProducto(){
        return productos;
    }

    public static ArrayList<Cliente> obtenerCliente(){
        return clientes;
    }

    public static ArrayList<Venta> obtenerVenta(){
        return ventas;
    }
}
