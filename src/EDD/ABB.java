/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Clases.Estado;
import Clases.Historial;
import javax.swing.JOptionPane;

/**
 *
 * @author Victoria Saldivia
 */
public class ABB {

    private NodoAB nodoRaiz;

    public ABB() {
        this.nodoRaiz = null;
    }

    public NodoAB getNodoRaiz() {
        return nodoRaiz;
    }

    public void setNodoRaiz(NodoAB nodoRaiz) {
        this.nodoRaiz = nodoRaiz;
    }

    public boolean esVacio() {
        return this.getNodoRaiz() == null;
    }

    public void vaciar() {
        this.setNodoRaiz(null);
    }

    public void insertNodo(NodoAB raiz, Object element, int num) {
        NodoAB node = new NodoAB(element, num);
        if (esVacio()) {
            setNodoRaiz(node);
        } else {
            if (num <= raiz.getNum()) {
                if (raiz.getHijoIzq() == null) {
                    raiz.setHijoIzq(node);
                    node.setFather(raiz);
                } else {
                    insertNodo(raiz.getHijoIzq(), element, num);
                }
            } else {
                if (raiz.getHijoDer() == null) {
                    raiz.setHijoDer(node);
                    node.setFather(raiz);
                } else {
                    insertNodo(raiz.getHijoDer(), element, num);
                }
            }
        }
    }

    public NodoAB buscarNodo(int num, NodoAB root) {
        if (esVacio()) {
            return null;
        } else {
            if (root != null) {
                if (root.getNum() == num) {
                    return root;
                } else {
                    if (num < root.getNum()) {
                        return buscarNodo(num, root.getHijoIzq());
                    } else {

                        return buscarNodo(num, root.getHijoIzq());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe");
                return null;
            }
        }
    }
    
    public NodoAB buscarRecursivo(NodoAB nodoActual, int num) {
        if (nodoActual == null || nodoActual.getNum() == num) {
            return nodoActual;
        }

        if (num < nodoActual.getNum()) {
            return buscarRecursivo(nodoActual.getHijoIzq(), num);
        } else {
            return buscarRecursivo(nodoActual.getHijoDer(), num);
        }
    }

    public void ModifHistorial(int num, NodoAB root, Estado estado) {
        if (root == null) {
            System.out.println("no se encontro");
        } else {
            if (root.getNum() == num) {
                Historial hist = (Historial) root.getDato();
                hist.getEstados().insertFinal(estado);
                root.setDato(hist);
            } else {
                if (num < root.getNum()) {
                    ModifHistorial(num, root.getHijoIzq(), estado);
                } else {
                    ModifHistorial(num, root.getHijoIzq(), estado);
                }
            }
        }
    }

    public void preOrden(NodoAB root) {
        if (root != null) {
            System.out.println("{ " + root.getDato() + " }");
            preOrden(root.getHijoIzq());
            preOrden(root.getHijoDer());
        }
    }

    public String preOrden2(NodoAB root, String cadena) {
        if (root != null) {
            cadena = cadena + root.getNum() + ", " + root.getDato().toString() + ",";
            cadena = preOrden2(root.getHijoIzq(), cadena);
            cadena = preOrden2(root.getHijoDer(), cadena);
        }

        return cadena;
    }

    public void Lista(NodoAB root, ListaDoble list) {
//        list.InsertarFinal(root.getDato());
//        
//        if(root.getHijoIzq() != null){
//            Lista(root.getHijoIzq(), list);
//        }
//        if(root.getHijoDer() != null){
//            Lista(root.getHijoDer(), list);
//        }   
    }

    public void inOrden(NodoAB root) {
        if (root != null) {
            preOrden(root.getHijoIzq());
            System.out.println("{ " + root.getDato() + " }");
            preOrden(root.getHijoDer());
        }
    }

    public void postOrden(NodoAB root) {
        if (root != null) {
            preOrden(root.getHijoIzq());
            preOrden(root.getHijoDer());
            System.out.println("{ " + root.getNum() + " }");
        }
    }

}
