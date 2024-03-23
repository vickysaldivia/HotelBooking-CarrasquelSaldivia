/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Ramón Carrasquel
 */
public class Cliente {
    private String nombre;
    private String apellido;
    private int cedula;
    private String email;
    private String genero;
    private String celular;

    public Cliente(String nombre, String apellido, int cedula, String email, String genero, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.email = email;
        this.genero = genero;
        this.celular = celular;
    }
    
    public Cliente(String nombre, String apellido, int cedula, String email, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.email = email;
        this.genero = genero;
        this.celular = null;
    }
    
    public Cliente(String nombre, String apellido, String email, String genero, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.celular = celular;
    }
    
    //constructor solo nombre y apellido
    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = null;
        this.genero = null;
        this.celular = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
    
}
