/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Victoria Saldivia
 */
public class Nodo {
    
    private Object element;
    private Nodo next;
    private Nodo previous;

    public Nodo(Object elemento) {
        this.element = elemento;
        this.next = null;
        this.previous = null;
    }

    public Nodo() {
        this.element = null;
        this.next = null;
        this.previous = null;
    }
    
    

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
