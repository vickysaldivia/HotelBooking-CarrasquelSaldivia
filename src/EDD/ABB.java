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
/**
 * Clase que representa un árbol binario de búsqueda (ABB).
 */
public class ABB {

     /**
     * Referencia al nodo raíz del árbol.
     */
    private NodoAB nodoRaiz;

     /**
     * Constructor por defecto que inicializa el árbol como vacío.
     */
    public ABB() {
        this.nodoRaiz = null;
    }

     // Getter y Setter de la raiz
    public NodoAB getNodoRaiz() {
        return nodoRaiz;
    }

    public void setNodoRaiz(NodoAB nodoRaiz) {
        this.nodoRaiz = nodoRaiz;
    }

    /**
     * Indica si el árbol está vacío.
     *
     * @return true si el árbol está vacío, false en caso contrario.
     */

    public boolean esVacio() {
        return this.getNodoRaiz() == null;
    }

    /**
     * Vacía el árbol.
     */
    public void vaciar() {
        this.setNodoRaiz(null);
    }

    /**
     * Inserta un nuevo nodo en el árbol.
     *
     * @param raiz       el nodo en el que se insertará el nuevo nodo.
     * @param element    el elemento asociado al nuevo nodo.
     * @param num        la clave asociada al nuevo nodo.
     */
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
/**
     * Busca un nodo en el árbol por su clave.
     *
     * @param num   la clave del nodo a buscar.
     * @param root  la raíz del árbol.
     * @return el nodo encontrado o null si no existe.
     */
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
    
    
/**
     * Busca un nodo en el árbol por su clave de forma recursiva.
     *
     * @param nodoActual la raíz actual del árbol.
     * @param num        la clave del nodo a buscar.
     * @return el nodo encontrado
     */
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

    /**
     * Modifica el historial asociado al nodo con la clave num en el árbol.
     *
     * @param num la clave del nodo a modificar.
     * @param root la raíz del árbol.
     * @param estado el nuevo estado del historial.
     */
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

    /**
     * Realiza un recorrido preorden del árbol y muestra el dato de cada nodo.
     *
     * @param root la raíz del árbol.
     */
    public void preOrden(NodoAB root) {
        if (root != null) {
            System.out.println("{ " + root.getDato() + " }");
            preOrden(root.getHijoIzq());
            preOrden(root.getHijoDer());
        }
    }

    /**
     * Realiza un recorrido preorden del árbol y devuelve una cadena con la
     * información de cada nodo.
     *
     * @param root la raíz del árbol.
     * @param cadena la cadena donde se guardará la información.
     * @return la cadena con la información de los nodos.
     */
    public String preOrden2(NodoAB root, String cadena) {
        if (root != null) {
            cadena = cadena + root.getNum() + "," + root.getDato().toString() + "\n";
            cadena = preOrden2(root.getHijoIzq(), cadena);
            cadena = preOrden2(root.getHijoDer(), cadena);
        }

        return cadena;
    }


    /**
     * Realiza un recorrido inorden del árbol y muestra el dato de cada nodo.
     *
     * @param root la raíz del árbol.
     */
    public void inOrden(NodoAB root) {
        if (root != null) {
            preOrden(root.getHijoIzq());
            System.out.println("{ " + root.getDato() + " }");
            preOrden(root.getHijoDer());
        }
    }

    /**
     * Realiza un recorrido postorden del árbol y muestra el dato de cada nodo.
     *
     * @param root la raíz del árbol.
     */
    public void postOrden(NodoAB root) {
        if (root != null) {
            preOrden(root.getHijoIzq());
            preOrden(root.getHijoDer());
            System.out.println("{ " + root.getNum() + " }");
        }
    }
    
    /**
     * Elimina recursivamente un nodo con la clave num del árbol.
     *
     * @param nodoActual la raíz actual del árbol.
     * @param num la clave del nodo a eliminar.
     * @return la raíz actual del árbol después de la eliminación.
     */
    public NodoAB eliminarRecursivo(NodoAB nodoActual, int num) {
        if (nodoActual == null) {
            return null;
        }

        if (num < nodoActual.getNum()) {
            nodoActual.setHijoIzq(eliminarRecursivo(nodoActual.getHijoIzq(), num));
        } else if (num > nodoActual.getNum()) {
            nodoActual.setHijoDer(eliminarRecursivo(nodoActual.getHijoDer(), num));
        } else {
            // Caso 1: Nodo sin hijos
            if (nodoActual.getHijoIzq() == null && nodoActual.getHijoDer() == null) {
                return null;
            }
            // Caso 2: Nodo con un hijo
            if (nodoActual.getHijoIzq() == null) {
                return nodoActual.getHijoDer();
            }
            if (nodoActual.getHijoDer() == null) {
                return nodoActual.getHijoIzq();
            }
            // Caso 3: Nodo con dos hijos
            NodoAB sucesor = encontrarSucesor(nodoActual.getHijoDer());
            nodoActual.setNum(sucesor.getNum());
            nodoActual.setDato(sucesor.getDato());
            nodoActual.setHijoDer(eliminarRecursivo(nodoActual.getHijoDer(), sucesor.getNum()));
        }
        return nodoActual;
    }

    /**
     * Encuentra el sucesor inorder del nodo dado.
     *
     * @param nodo el nodo del cual se quiere encontrar el sucesor.
     * @return el nodo sucesor.
     */
    public NodoAB encontrarSucesor(NodoAB nodo) {
        while (nodo.getHijoIzq() != null) {
            nodo = nodo.getHijoIzq();
        }
        return nodo;
    }

}
