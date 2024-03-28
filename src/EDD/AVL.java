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
 * Clase AVL que representa un árbol AVL (Árbol Binario de Búsqueda Auto-
 * equilibrado) y contiene métodos para insertar, eliminar, buscar y recorrer el
 * árbol.
 */
public class AVL {

    /**
     * Referencia al nodo raíz del árbol.
     */
    private NodoAVL tRoot;
    
    /**
     * Constructor de la clase AVL, crea un árbol vacío.
     */
    public AVL() {
        tRoot = null;
    }

      /**
     * Método getRaiz que devuelve el nodo raíz del árbol.
     *
     * @return NodoAVL tRoot, la raíz del árbol.
     */
    public NodoAVL getRaiz() {
        return tRoot;
    }

 /**
     * Método insertar que recibe un entero y un objeto de la clase Habitación
     * y lo inserta en el árbol AVL.
     *
     * @param clave  el entero que se utilizará como clave para el nuevo nodo.
     * @param hab    el objeto de la clase Habitación que se almacenará en el nuevo nodo.
     */
    public void insertar(int clave, Habitacion hab) {
        tRoot = insertNode(tRoot, clave, hab);
    }

 /**
     * Método insertNode que recibe un nodo y un entero y un objeto de la clase Habitación
     * e inserta un nuevo nodo en el árbol AVL.
     * Si el árbol está vacío, crea un nodo con el valor y la habitación recibidos,
     * de lo contrario, se llama recursivamente a este método hasta encontrar el
     * lugar donde insertar el nuevo nodo.
     *
     * @param nodo   el nodo en el que se insertará el nuevo nodo.
     * @param clave  el entero que se utilizará como clave para el nuevo nodo.
     * @param hab    el objeto de la clase Habitación que se almacenará en el nuevo nodo.
     * @return NodoAVL el nuevo nodo con su clave y habitación, y los punteros a sus
     * subárboles izquierdo y derecho.
     */
    private NodoAVL insertNode(NodoAVL nodo, int clave, Habitacion hab) {
        if (nodo == null) {
            return new NodoAVL(clave, hab);
        }

        if (clave < nodo.getClave()) {
            nodo.setIzquierda(insertNode(nodo.getIzquierda(), clave, hab));
        } else if (clave > nodo.getClave()) {
            nodo.setDerecha(insertNode(nodo.getDerecha(), clave, hab));
        } else {
            // La clave ya existe, no se permiten claves duplicadas
            return nodo;
        }

        // Actualizar nodeHeight del nodo actual
        nodo.setAltura(1 + Math.max(nodeHeight(nodo.getIzquierda()), nodeHeight(nodo.getDerecha())));

        // Verificar el balanceo del árbol y aplicar rotaciones si es necesario
        return balanceTree(nodo, clave);
    }

    /**
     * Método nodeHeight que calcula la altura del árbol a partir de un nodo
     * dado.
     *
     * @param N El nodo desde el cual se calculará la altura.
     * @return int La altura del árbol.
     */
    private int nodeHeight(NodoAVL N) {
        if (N == null)
            return 0;
        return N.getAltura();
    }

    /**
     * Método balanceTree que realiza las rotaciones necesarias en un nodo dado
     * para mantener el equilibrio del árbol AVL.
     *
     * @param nodo El nodo desde el cual se iniciará el proceso de rotación.
     * @param clave La clave que se utilizó para insertar o eliminar un nodo.
     * @return NodoAVL El nodo que se obtiene luego de realizar las rotaciones
     * necesarias.
     */
    private NodoAVL balanceTree(NodoAVL nodo, int clave) {
        int balance = getBalance(nodo);

        // Rotación simple a la derecha
        if (balance > 1 && clave < nodo.getIzquierda().getClave()) {
            return rotateRight(nodo);
        }

        // Rotación simple a la izquierda
        if (balance < -1 && clave > nodo.getDerecha().getClave()) {
            return rotateLeft(nodo);
        }

        // Rotación doble izquierda derecha
        if (balance > 1 && clave > nodo.getIzquierda().getClave()) {
            nodo.setIzquierda(rotateLeft(nodo.getIzquierda()));
            return rotateRight(nodo);
        }


        if (balance < -1 && clave < nodo.getDerecha().getClave()) {
            nodo.setDerecha(rotateRight(nodo.getDerecha()));
            return rotateLeft(nodo);
        }

        return nodo;
    }


    //Metodo getter del Balance del arbol AVL
    private int getBalance(NodoAVL N) {
        if (N == null)
            return 0;
        return nodeHeight(N.getIzquierda()) - nodeHeight(N.getDerecha());
    }


    /**
     * Realiza una rotación a la derecha en el árbol AVL.
     *
     * @param y Nodo del árbol AVL sobre el que se realiza la rotación.
     * @return El nuevo subárbol resultante de la rotación.
     */
    private NodoAVL rotateRight(NodoAVL y) {
        NodoAVL x = y.getIzquierda();
        NodoAVL T2 = x.getDerecha();

        x.setDerecha(y);
        y.setIzquierda(T2);
        
        y.setAltura(Math.max(nodeHeight(y.getIzquierda()), nodeHeight(y.getDerecha())) + 1);
        x.setAltura(Math.max(nodeHeight(x.getIzquierda()), nodeHeight(x.getDerecha())) + 1);

        return x;
    }

    /**
     * Realiza una rotación a la izquierda en el árbol AVL.
     *
     * @param x Nodo del árbol AVL sobre el que se realiza la rotación.
     * @return El nuevo subárbol resultante de la rotación.
     */
    private NodoAVL rotateLeft(NodoAVL x) {
        NodoAVL y = x.getDerecha();
        NodoAVL T2 = y.getIzquierda();

        y.setIzquierda(x);
        x.setDerecha(T2);

        x.setAltura(Math.max(nodeHeight(x.getIzquierda()), nodeHeight(x.getDerecha())) + 1);
        y.setAltura(Math.max(nodeHeight(y.getIzquierda()), nodeHeight(y.getDerecha())) + 1);

        return y;
    }
    
    
    public String inOrden() {
        return inOrden(tRoot);
    }

    /**
     * Método recursivo para recorrer el árbol AVL en orden in-order (izquierda,
     * raíz, derecha).
     *
     * @param nodo Nodo actual del árbol AVL.
     * @return Cadena con los datos de cada nodo en orden in-order.
     */

    private String inOrden(NodoAVL nodo) {
        String resultado = "";
        if (nodo != null) {
            resultado += inOrden(nodo.getIzquierda()); // Recorre subárbol izquierdo y acumula
            resultado += nodo.getClave() + "," + nodo.getHab().getTipoHab() + "," + nodo.getHab().getPiso() + "\n"; // Acumula los datos del nodo actual
            resultado += inOrden(nodo.getDerecha()); // Recorre subárbol derecho y acumula
        }
        return resultado;
    }
    
    
    public String inOrdenHistorico() {
        return inOrdenHistorico(tRoot);
    }

    /**
     * Método recursivo para recorrer el árbol AVL en orden in-order (izquierda,
     * raíz, derecha) y generar el historial de las habitaciones.
     *
     * @param nodo Nodo actual del árbol AVL.
     * @return Cadena con los datos de cada historial de habitaciones en orden
     * in-order.
     */
    private String inOrdenHistorico(NodoAVL nodo) {
        String resultado = "";
        if (nodo != null && nodo.getHab().getHistorial().getSize() != 0) {
            resultado += inOrdenHistorico(nodo.getIzquierda()); // Recorre subárbol izquierdo y acumula
            resultado += nodo.getHab().getHistorial().transformar(); // Acumula los datos del nodo actual
            resultado += inOrdenHistorico(nodo.getDerecha()); // Recorre subárbol derecho y acumula
        }
        return resultado;
    }
    
    
    /**
    * Busca una habitación en el árbol AVL utilizando la clave (número de habitación) como referencia.
    * 
    * @param num_hab Número de la habitación a buscar.
    * @return Objeto de tipo Habitacion correspondiente a la clave buscada, o null si no se encuentra.
 */

    public Habitacion searchByKey(int num_hab) {
        NodoAVL actual = tRoot;

        while (actual != null) {
            if (num_hab < actual.getClave()) {
                actual = actual.getIzquierda();
            } else if (num_hab > actual.getClave()) {
                actual = actual.getDerecha();
            } else {
                return actual.getHab();
            }
        }
        return null;
    }

}

