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
public class Habitacion {
    private int numHab;
    private String tipoHab;
    private int piso;
    private boolean dispo;
    private ListaDoble historial;

    public Habitacion(int numHab, String tipoHab, int piso, boolean dispo, ListaDoble historial) {
        this.numHab = numHab;
        this.tipoHab = tipoHab;
        this.piso = piso;
        this.dispo = dispo;
        this.historial = new ListaDoble();
    }
    
    public Habitacion(int numHab, String tipoHab, int piso) {
        this.numHab = numHab;
        this.tipoHab = tipoHab;
        this.piso = piso;
        this.dispo = false;
        this.historial = new ListaDoble();
    }

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

    @Override
    public String toString() {
        return "Habitacion{" + "numHab=" + numHab + ", tipoHab=" + tipoHab + ", piso=" + piso + ", dispo=" + dispo;
    }
    
    public void mostrar_hitorial(){
        
        if(!historial.isEmpty()){
            historial.printList();
        }else{
            System.out.println("No hay historial");
        }
    
    }
    
}
