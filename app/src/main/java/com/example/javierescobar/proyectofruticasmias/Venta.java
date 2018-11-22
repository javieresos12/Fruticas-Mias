package com.example.javierescobar.proyectofruticasmias;

public class Venta {
    private String id;
    private String cliente;
    private String producto;
    private int cantidad;
    private int subtotal;
    private int total;

    public Venta(String id, String cliente, String producto, int cantidad, int subtotal, int total) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void guardar(){
        Datos.agregarVenta(this);
    }

    public void eliminar(){
        Datos.eliminarVenta(this);
    }

    public void editar(){
        Datos.editarVenta(this);
    }
}
