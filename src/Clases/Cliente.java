/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Ramón Carrasquel
 */

/**
 * Clase que representa a un cliente del hotel.
 */

public class Cliente {
    // Atributos de la clase Cliente

    private String nombre;
    private String apellido;
    private int cedula;
    private String email;
    private String genero;
    private String celular;

    /**
     * Constructor de la clase Cliente que asigna valores a todos los atributos.
     *
     * @param nombre Nombre del cliente
     * @param apellido Apellido del cliente
     * @param cedula Cédula de identidad del cliente
     * @param email Correo electrónico del cliente
     * @param genero Género del cliente
     * @param celular Número de celular del cliente
     */

    public Cliente(String nombre, String apellido, int cedula, String email, String genero, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.email = email;
        this.genero = genero;
        this.celular = celular;
    }
    
    /**
     * Constructor de la clase Cliente que asigna valores a todos los atributos
     * excepto al número de celular.
     *
     * @param nombre Nombre del cliente
     * @param apellido Apellido del cliente
     * @param cedula Cédula de identidad del cliente
     * @param email Correo electrónico del cliente
     * @param genero Género del cliente
     */

    public Cliente(String nombre, String apellido, int cedula, String email, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.email = email;
        this.genero = genero;
        this.celular = null;
    }
    
    /**
     * Constructor de la clase Cliente que asigna valores a todos los atributos
     * excepto a la cédula de identidad y al número de celular.
     *
     * @param nombre Nombre del cliente
     * @param apellido Apellido del cliente
     * @param email Correo electrónico del cliente
     * @param genero Género del cliente
     * @param celular Número de celular del cliente
     */

    public Cliente(String nombre, String apellido, String email, String genero, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.celular = celular;
    }
    
    /**
     * Constructor de la clase Cliente que asigna valores a los atributos de
     * nombre y apellido, y deja sin asignar valores a los atributos de cédula
     * de identidad, correo electrónico, género y número de celular.
     *
     * @param nombre Nombre del cliente
     * @param apellido Apellido del cliente
     */

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = null;
        this.genero = null;
        this.celular = null;
    }

    // Getters y Setters de cada uno de los atributos
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
    
    /**
     * Formatea el número de cédula dado agregando puntos cada tres dígitos,
     * comenzando desde la derecha.
     *
     * Este método convierte el número de cédula en una cadena y lo itera de
     * derecha a izquierda. Cada tres dígitos, agrega un punto antes de la
     * subcadena actual, excepto la última. La posición del punto es gestionada
     * por un contador que se pone a cero cada vez que llega a tres.
     *
     * @return El número de cédula con puntos cada tres dígitos.
     */

    public String cedulaFormat() {
        String numeroStr = String.valueOf(cedula);
        String resultado = "";
        int contador = 0;

        for (int i = numeroStr.length() - 1; i >= 0; i--) {
            resultado = numeroStr.charAt(i) + resultado;
            contador++;
            if (contador == 3 && i != 0) {
                resultado = "." + resultado;
                contador = 0; 
            }
        }

        return resultado;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", email=" + email + ", genero=" + genero + ", celular=" + celular + '}';
    }
    
}
