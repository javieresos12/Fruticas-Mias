package com.example.javierescobar.proyectofruticasmias;

public class Cliente {
    private String id;
    private String nombre;
    private String Apellido;
    private String tel;
    private String direccion;

    public Cliente(String id, String nombre, String apellido, String tel, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.Apellido = apellido;
        this.tel = tel;
        this.direccion = direccion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
