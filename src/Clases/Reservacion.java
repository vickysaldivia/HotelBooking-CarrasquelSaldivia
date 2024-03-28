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
 * Clase Reservacion que representa una reservación de una habitación de hotel.
 */
public class Reservacion {
    // Atributos de la clase Reservacion
    private Cliente cliente;
    private String tipoHab;
    private String llegada;
    private String salida;

    /**
     * Constructor de la clase Reservacion que asigna valores a todos los atributos.
     * @param cliente Cliente del hotel
     * @param tipoHab Tipo de habitacion
     * @param llegada Fecha de llegada al hotel
     * @param salida Fecha de salida del hotel
     */
    public Reservacion(Cliente cliente, String tipoHab, String llegada, String salida) {
        this.cliente = cliente;
        this.tipoHab = tipoHab;
        this.llegada = llegada;
        this.salida = salida;
    }

    // Getters y Setters de cada uno de los atributos
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipoHab() {
        return tipoHab;
    }

    public void setTipoHab(String tipoHab) {
        this.tipoHab = tipoHab;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    // Métodos adicionales para convertir la reservacion en cadenas
    public String toString1() {
        return "Reservacion{" + "cliente=" + cliente.getCedula() + ", tipoHab=" + tipoHab + ", llegada=" + llegada + ", salida=" + salida + "\n";
    }
    
    public String toString(){
        return cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getEmail() + "," + cliente.getGenero() + "," + tipoHab + "," + cliente.getCelular() + "," + llegada + "," + salida;
    }
    
}
