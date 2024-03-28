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
 * Clase que representa un nodo en un árbol binario de búsqueda.
 */
public class NodoAB {
    // Atributos de la clase NodoAB
    private int num;
    private Object dato;
    private NodoAB HijoIzq;
    private NodoAB HijoDer;
    private NodoAB father;

    /**
     * Constructor de la clase NodoAB.
     *
     * @param num El número del nodo.
     * @param dato El dato almacenado en el nodo.
     * @param HijoIzq El hijo izquierdo del nodo.
     * @param HijoDer El hijo derecho del nodo.
     * @param father El nodo padre del nodo.
     */
    public NodoAB(int num,Object dato, NodoAB HijoIzq, NodoAB HijoDer, NodoAB father) {
        this.num = num;
        this.dato = dato;
        this.HijoIzq = HijoIzq;
        this.HijoDer = HijoDer;
        this.father = father;
    }
    
    /**
     * Constructor de la clase NodoAB.
     *
     * @param dato El dato almacenado en el nodo.
     * @param num El número del nodo.
     */
    public NodoAB(Object dato, int num) {
        this.num = num;
        this.dato = dato;
        this.HijoIzq = null;
        this.HijoDer = null;
        this.father = null;
    }

    // Getters y Setters de cada uno de los atributos
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoAB getHijoIzq() {
        return HijoIzq;
    }

    public void setHijoIzq(NodoAB HijoIzq) {
        this.HijoIzq = HijoIzq;
    }

    public NodoAB getHijoDer() {
        return HijoDer;
    }

    public void setHijoDer(NodoAB HijoDer) {
        this.HijoDer = HijoDer;
    }

    public NodoAB getFather() {
        return father;
    }

    public void setFather(NodoAB father) {
        this.father = father;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
     
    
}
