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
public class AVL {

    private NodoAVL tRoot;

    public AVL() {
        tRoot = null;
    }

    public NodoAVL getRaiz() {
        return tRoot;
    }

    // Método para insertNode un nuevo nodo en el árbol
    public void insertar(int clave, Habitacion hab) {
        tRoot = insertNode(tRoot, clave, hab);
    }

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

    private int nodeHeight(NodoAVL N) {
        if (N == null)
            return 0;
        return N.getAltura();
    }

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


    private int getBalance(NodoAVL N) {
        if (N == null)
            return 0;
        return nodeHeight(N.getIzquierda()) - nodeHeight(N.getDerecha());
    }


    private NodoAVL rotateRight(NodoAVL y) {
        NodoAVL x = y.getIzquierda();
        NodoAVL T2 = x.getDerecha();

        x.setDerecha(y);
        y.setIzquierda(T2);
        
        y.setAltura(Math.max(nodeHeight(y.getIzquierda()), nodeHeight(y.getDerecha())) + 1);
        x.setAltura(Math.max(nodeHeight(x.getIzquierda()), nodeHeight(x.getDerecha())) + 1);

        return x;
    }

    private NodoAVL rotateLeft(NodoAVL x) {
        NodoAVL y = x.getDerecha();
        NodoAVL T2 = y.getIzquierda();

        y.setIzquierda(x);
        x.setDerecha(T2);

        x.setAltura(Math.max(nodeHeight(x.getIzquierda()), nodeHeight(x.getDerecha())) + 1);
        y.setAltura(Math.max(nodeHeight(y.getIzquierda()), nodeHeight(y.getDerecha())) + 1);

        return y;
    }
    
    public void inOrden() {
        inOrden(tRoot);
    }

    private void inOrden(NodoAVL nodo) {
        if (nodo != null) {
            inOrden(nodo.getIzquierda()); 
            System.out.println(nodo.getClave() + " - " + nodo.getHab().toString()); 
            inOrden(nodo.getDerecha()); 
        }
    }
    
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

