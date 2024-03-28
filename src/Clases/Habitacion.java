/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EDD.ListaDoble;

/**
 *
 * @author Ramón Carrasquel
 */

/**
  * Esta clase representa una habitación de hotel con un número, tipo, piso, estado de disponibilidad,
  * y una lista doblemente enlazada para almacenar los registros históricos de la sala.
  */
public class Habitacion {
    
    // Atributos de la clase Habitacion
    private int numHab;
    private String tipoHab;
    private int piso;
    private boolean dispo;
    private ListaDoble historial;

     /**
     * Constructor de una habitación con un número, tipo, piso, estado de disponibilidad determinado,
     * y una nueva lista vacía doblemente enlazada para registros históricos.
     * @param numHab el número de habitación
     * @param tipoHab el tipo de habitación
     * @param piso el piso de la habitación
     * @param dispo el estado de disponibilidad de la habitación
     * @param historial la lista doblemente enlazada para registros históricos
     */
    public Habitacion(int numHab, String tipoHab, int piso, boolean dispo, ListaDoble historial) {
        this.numHab = numHab;
        this.tipoHab = tipoHab;
        this.piso = piso;
        this.dispo = dispo;
        this.historial = new ListaDoble();
    }
    
    /**
     * Constructor de una habitación con un número, tipo, piso.
     * @param numHab el número de habitación
     * @param tipoHab el tipo de habitación
     * @param piso el piso de la habitación
     */
    public Habitacion(int numHab, String tipoHab, int piso) {
        this.numHab = numHab;
        this.tipoHab = tipoHab;
        this.piso = piso;
        this.dispo = false;
        this.historial = new ListaDoble();
    }

     // Getters y Setters de cada uno de los atributos

    public int getNumHab() {
        return numHab;
    }

    public void setNumHab(int numHab) {
        this.numHab = numHab;
    }

    public String getTipoHab() {
        return tipoHab;
    }

    public void setTipoHab(String tipoHab) {
        this.tipoHab = tipoHab;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }

    public ListaDoble getHistorial() {
        return historial;
    }

    public void setHistorial(ListaDoble historial) {
        this.historial = historial;
    }

    // Métodos adicionales para convertir la habitación en cadenas
    @Override
    public String toString() {
        return "Habitacion{" + "numHab=" + numHab + ", tipoHab=" + tipoHab + ", piso=" + piso + ", dispo=" + dispo;
    }
    
    /**
     * Este método muestra el historial del hotel. Si el historial no está
     * vacío, imprimirá la lista. De lo contrario, mostrará un mensaje que dice
     * "No hay historial"
     */
    public void mostrar_hitorial(){
        
        if(!historial.isEmpty()){
            historial.printList();
        }else{
            System.out.println("No hay historial");
        }
    
    }
    
}
