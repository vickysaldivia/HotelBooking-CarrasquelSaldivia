/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Clases.Habitacion;

/**
 *
 * @author vickysaldivia
 */
/**
 * Clase NodoAVL que representa un nodo en un árbol AVL. Cada nodo almacena un
 * número de habitación y una referencia a una instancia de la clase Habitacion.
 * Además, cada nodo tiene una altura, una referencia a su subárbol izquierdo y
 * una referencia a su subárbol derecho.
 */
public class NodoAVL {

    // Atributos de la clase NodoAVL
    private int num_hab;
    private Habitacion hab;
    private int altura;
    private NodoAVL izquierda;
    private NodoAVL derecha;

    /**
     * Constructor de la clase NodoAVL. Inicializa las propiedades del nodo con
     * los parámetros dados.
     *
     * @param clave El número de habitación a almacenar en el nodo.
     * @param hab Una referencia a una instancia de la clase Habitacion asociada
     * con el número de habitación.
     */
    public NodoAVL(int clave, Habitacion hab) {
        this.hab = hab;
        this.num_hab = clave;
        this.altura = 1;
        this.izquierda = null;
        this.derecha = null;
    }

    // Getters, Setters y Verificaciones
    public int getClave() {
        return num_hab;
    }

    public void setClave(int clave) {
        this.num_hab = clave;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public NodoAVL getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoAVL izquierda) {
        this.izquierda = izquierda;
    }

    public NodoAVL getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoAVL derecha) {
        this.derecha = derecha;
    }
        
    public boolean nodeFull(){
        return (getDerecha()!=null && getIzquierda()!=null);
    }
    
    public boolean isLeaf(){
        return (getDerecha()==null && getIzquierda()==null);
    }

    public boolean hasLeft(){
        return (getIzquierda()!=null);
    }

    public boolean hasRight(){
        return (getDerecha()!=null);
    }

    public Habitacion getHab() {
        return hab;
    }

    public void setHab(Habitacion hab) {
        this.hab = hab;
    }
    
    
}

