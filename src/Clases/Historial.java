package Clases;

import EDD.ListaDoble;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vickysaldivia
 */
public class Historial {
    private int num_hab;
    private ListaDoble estados;

    public Historial(int num_hab, ListaDoble estados) {
        this.num_hab = num_hab;
        this.estados = estados;
    }

    public int getNum_hab() {
        return num_hab;
    }

    public void setNum_hab(int num_hab) {
        this.num_hab = num_hab;
    }

    public ListaDoble getEstados() {
        return estados;
    }

    public void setEstados(ListaDoble estados) {
        this.estados = estados;
    }
    
}
