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
/**
 * Clase Historial que representa un objeto que almacena el número de habitación
 * y una lista doblemente enlazada de estados.
 */
public class Historial {
      // Atributos de la clase Historia
    private int num_hab;
    private ListaDoble estados;

    /**
     * Constructor de la clase Historial que asigna valores a todos los atributos.
     * @param num_hab Numero de habitacion
     * @param estados Estados
     */
    public Historial(int num_hab, ListaDoble estados) {
        this.num_hab = num_hab;
        this.estados = estados;
    }

     // Getters y Setters de cada uno de los atributos
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
