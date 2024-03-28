/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Victoria Saldivia
 */

/**
 * Clase Nodo que representa un nodo en una lista enlazada. Cada nodo tiene tres
 * partes: un elemento (objeto), un nodo siguiente y un nodo anterior.
 */
public class Nodo {
    
    // Atributos de la clase Nodo
    private Object element;
    private Nodo next;
    private Nodo previous;

    /**
     * Crea un nuevo nodo con el elemento especificado.
     *
     * @param elemento El elemento del nuevo nodo.
     */
    public Nodo(Object elemento) {
        this.element = elemento;
        this.next = null;
        this.previous = null;
    }

    /**
     * Crea un nuevo nodo sin elemento.
     */
    public Nodo() {
        this.element = null;
        this.next = null;
        this.previous = null;
    }
    
    
    // Getters y Setters de cada uno de los atributos
    public Object getElement() {
        return element;
    }

    public void setElement(Object elemento) {
        this.element = elemento;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo siguiente) {
        this.next = siguiente;
    }

    public Nodo getPrevious() {
        return previous;
    }

    public void setPrevious(Nodo previous) {
        this.previous = previous;
    }
    
}
