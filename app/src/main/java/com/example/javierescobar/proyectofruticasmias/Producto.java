package com.example.javierescobar.proyectofruticasmias;

public class Producto {
    private String id;
    private String codigo;
    private String nombre;
    private double precio;
    private String descripcion;
    private String foto;

    public Producto(){

    }

    public Producto(String id, String codigo, String nombre, double precio, String descripcion, String foto) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void guardar(){
        Datos.agregarProducto(this);
    }

    public void eliminar(){Datos.eliminarProducto(this);}

    public void editar(){Datos.editarProducto(this);}

}
