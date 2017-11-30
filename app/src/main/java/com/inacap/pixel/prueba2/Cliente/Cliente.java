package com.inacap.pixel.prueba2.Cliente;

/**
 * Created by Pixel on 30-11-2017.
 */

public class Cliente {
    private String rut;
    private String n_local;
    private String n_contacto;
    private String direccion;
    private String telefono;
    private String estado;
    public Cliente(String rut, String n_local, String n_contacto, String direccion, String telefono, String estado){
        this.rut = rut;
        this.n_local = n_local;
        this.n_contacto = n_contacto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

    public String getRut() {
        return rut;
    }

    public String getN_local() {
        return n_local;
    }

    public String getN_contacto() {
        return n_contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "[" +
                "rut='" + rut + '\'' +
                ", n_local='" + n_local + '\'' +
                ", n_contacto='" + n_contacto + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", estado='" + estado + '\'' +
                ']';
    }
}
