/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Clases.Estado;

/**
 *
 * @author Victoria Saldivia
 */
public class NodoAB {
    private int num;
        private Object dato;
    private NodoAB HijoIzq;
    private NodoAB HijoDer;
    private NodoAB father;

    public NodoAB(int num,Object dato, NodoAB HijoIzq, NodoAB HijoDer, NodoAB father) {
        this.num = num;
        this.dato = dato;
        this.HijoIzq = HijoIzq;
        this.HijoDer = HijoDer;
        this.father = father;
    }
    
    public NodoAB(Object dato, int num) {
        this.num = num;
        this.dato = dato;
        this.HijoIzq = null;
        this.HijoDer = null;
        this.father = null;
    }

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
