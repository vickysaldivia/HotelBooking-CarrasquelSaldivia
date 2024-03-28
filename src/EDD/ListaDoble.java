/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Clases.Cliente;
import Clases.Estado;
import javax.swing.JOptionPane;

/**
 *
 * @author Victoria Saldivia
 */
/**
 * Clase ListaDoble que representa una lista doblemente enlazada. Esta clase
 * tiene tres atributos privados: head, tail y size. head es un nodo que
 * representa el inicio de la lista, tail es un nodo que representa el final de
 * la lista y size es un entero que representa el tamaño de la lista.
 */

public class ListaDoble {
    // Atributos de la clase  ListaDoble
    private Nodo head;
    private Nodo tail;
    private int size;

    /**
     * Constructor de la clase ListaDoble. Inicializa los atributos head, tail y
     * size en null y 0 respectivamente.
     */

    public ListaDoble() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Nodo getTail() {
        return tail;
    }

    public void setTail(Nodo tail) {
        this.tail = tail;
    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    //Primitivas
    
    /**
     * Método que verifica si la lista está vacía o no.
     *
     * @return true si la lista está vacía, false de lo contrario
     */
    public boolean isEmpty(){
        return head == null;
    }
    
    /**
     * Método para insertar un elemento al principio de la lista.
     *
     * @param number el elemento a insertar
     * @return el nodo creado
     */
    public Nodo insertBegin(Object number) {
        Nodo node = new Nodo(number);
        if (isEmpty()) {
            setHead(node);
            setTail(node);
        } else {
            node.setNext(getHead());
            getHead().setPrevious(node);
            setHead(node);
            Nodo pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            setTail(pointer);
        }
        size++;
        return node;
    }
    
    /**
     * Método para insertar un elemento al final de la lista.
     *
     * @param number el elemento a insertar
     * @return el nodo creado
     */
    public Nodo insertFinal(Object number){
        Nodo node = new Nodo(number);
        if (isEmpty()) {
            setHead(node);
            setTail(node);
        } else {
            Nodo pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(node);
            node.setPrevious(pointer);
            setTail(node);
        }
        size++;
        return node;
    }
    
    /**
     * Método para insertar un elemento en una posición dada de la lista. Si el
     * índice es mayor que el tamaño de la lista, el elemento se insertará al
     * final.
     *
     * @param index la posición en la que se insertará el elemento
     * @param number el elemento a insertar
     * @return el nodo creado
     */
    public Nodo insertInIndex(int index, Object number) {
        Nodo node = new Nodo(number);
        if (isEmpty()) {
            setHead(node);
        } else {
            if (index > getSize()) {
                System.out.println("The index is bigger than the size");
                return insertFinal(number);
            } else {
                if (index > getSize() / 2) {
                    Nodo pointer = getTail();
                    int cont = 0;
                    while (cont < (getSize() - index) && pointer.getPrevious()!= null) {
                        pointer = pointer.getPrevious();
                        cont++;
                    }
                    //5 8 20 1 2 3 4 12
                    //cont 1 pointer 20
                    node.setNext(pointer.getNext());
                    node.setPrevious(pointer);
                    pointer.getNext().setPrevious(node);
                    pointer.setNext(node);
                } else {
                    Nodo pointer = getHead();
                    int cont = 0;
                    while (cont < (index-1) && pointer.getNext()!= null) {
                        pointer = pointer.getNext();
                        cont++;
                    }
                    node.setNext(pointer.getNext());
                    node.setPrevious(pointer);
                    pointer.getNext().setPrevious(pointer);
                    pointer.setNext(node);
                }
            }
        }
        size++;
        return node;
    }
    
    /**
     * Método para insertar un elemento después de un objeto de referencia dado.
     * Si el objeto de referencia no se encuentra en la lista, no se realiza
     * ninguna inserción.
     *
     * @param ref el objeto de referencia después del cual se insertará el
     * elemento
     * @param valor el elemento a insertar
     * @return el nodo creado, null si el objeto de referencia no se encuentra
     */
    public Nodo insertarPorReferencia(Object ref,Object valor){
        
        Nodo nuevo = new Nodo();
        nuevo.setElement(valor);
        
        if (!isEmpty()) {
            if (buscar(ref)){
                Nodo aux = head;
                while (aux.getElement() != ref) {
                    aux = aux.getNext();
                } 
                Nodo siguiente = aux.getNext();
                
                aux.setNext(nuevo);
                nuevo.setNext(siguiente);
                nuevo.setPrevious(aux);
                
                size++;
                
                return nuevo;
            }
            return null;
        }
        return null;
    }
    
    /**
     * Método para eliminar el primer nodo de la lista.
     *
     * @return el nodo eliminado, null si la lista está vacía
     */
    public Nodo deleteBegin(){
        if (!isEmpty()){
            if (getSize() == 1) {
                setTail(null);
            }
            Nodo pointer = getHead();
            setHead(pointer.getNext());
            pointer.setNext(null);
            size--;
            return pointer;
        }
        return null;
    }
    
    /**
     * Método para eliminar el último nodo de la lista.
     *
     * @return el nodo eliminado, null si la lista está vacía
     */
    public Nodo deleteFinal(){
        if (!isEmpty()){
            Nodo pointer = getHead();
            if (getSize() == 1) {
                setHead(null);
                size--;
            } else {
                while (pointer.getNext() != null && pointer.getNext().getNext() != null){
                    pointer = pointer.getNext();
                }
                pointer.getNext().setPrevious(null);
                Nodo nodeReturn = pointer.getNext();
                pointer.setNext(null);
                setTail(pointer);
                size--;
                return nodeReturn;
            }
        }
        return null;
    }
    
    /**
     * Método para eliminar el nodo en una posición dada de la lista. Si el
     * índice es mayor que el tamaño de la lista, no se realiza ninguna
     * eliminación.
     *
     * @param index la posición del nodo a eliminar
     * @return el nodo eliminado, null si el índice es mayor que el tamaño de la
     * lista
     */
    public Nodo deleteInIndex(int index) {
        if (!isEmpty()){
            Nodo pointer = getHead();
            if (index > getSize()) {
                System.out.println("The index is bigger than the size");
                return tail;
            } else {
                if(index == 0){
                    deleteBegin();
                }else if (index > getSize() / 2) {
                    pointer = getTail();
                    int cont = 0;
                    while (cont < (getSize() - index) && pointer.getPrevious()!= null) {
                        pointer = pointer.getPrevious();
                        cont++;
                    }
                    if(pointer.getNext().getNext()!= null){
                        Nodo temp = pointer.getNext();
                        pointer.setNext(temp.getNext());
                        temp.getNext().setPrevious(pointer);
                        temp.setNext(null);
                        temp.setPrevious(null);
                        size--;
                    }else{
                        Nodo temp = pointer.getNext();
                        pointer.setNext(null);
                        temp.setNext(null);
                        temp.setPrevious(null);
                        size--;
                    }
                    
                } else {
                    pointer = getHead();
                    int cont = 0;
                    while (cont < (index-1) && pointer.getNext()!= null) {
                        pointer = pointer.getNext();
                        cont++;
                    }
                    Nodo temp = pointer.getNext();
                    pointer.setNext(temp.getNext());
                    temp.getNext().setPrevious(pointer);
                    temp.setNext(null);
                    temp.setPrevious(null);
                    size--;
                }
            }
        }
        return null;
    }
    
    /**
     * Método para eliminar el nodo que contiene un objeto dado.
     *
     * @param dato el objeto a eliminar
     * @return el nodo eliminado, null si el objeto no se encuentra en la lista
     */
    public Nodo deleteElement(Object dato){
        if (buscar(dato)) {
            if(head.getElement() == dato){
                head = head.getNext();
            }else{
                Nodo aux = head;
                while(aux.getNext().getElement() != dato){
                    aux = aux.getNext();
                }
                Nodo siguiente = aux.getNext().getNext();
                Nodo previo = aux.getPrevious();
                aux.setNext(siguiente);
                aux.setPrevious(previo);
                size--;
            }
        }
        return null;
    }
    
    /**
     * Método para editar el valor de un nodo que contiene un objeto de
     * referencia dado.
     *
     * @param referencia el objeto de referencia cuyo valor se actualizará
     * @param dato el nuevo valor a asignar al nodo
     */
    public void editarPorReferencia(Object referencia, Object dato){
        if (buscar(referencia)) {
            Nodo aux = head;
            while(aux.getElement() != referencia){
                aux = aux.getNext();
            }
            aux.setElement(dato);
        }
    }
    
    /**
     * Método para editar el valor de un nodo en una posición dada. Si la
     * posición está fuera del rango válido (mayor o igual al tamaño de la
     * lista), no se realiza ninguna modificación.
     *
     * @param posicion la posición del nodo cuyo valor se actualizará
     * @param dato el nuevo valor a asignar al nodo
     */
    public void editarPorPosicion(int posicion , Object dato){

        if(posicion>=0 && posicion<size){
            if(posicion == 0){
                head.setElement(dato);
            }
            else{
                Nodo aux = head;

                for (int i = 0; i < posicion; i++) {
                    aux = aux.getNext();
                }
                aux.setElement(dato);
            }
        }
    }
    
    /**
     * Método para obtener el valor almacenado en un nodo en una posición dada.
     * Si la lista está vacía o la posición está fuera del rango válido, se
     * devuelve -1.
     *
     * @param index la posición del nodo del que se desea obtener el valor
     * @return el valor almacenado en el nodo en la posición dada, o -1 si la
     * lista está vacía o la posición es inválida
     */
    public Object getValor(int index) {
        if (isEmpty()) {
            return -1;
        } else {
            Nodo pointer = getHead();
            int cont = 0;
            while (cont < index && pointer.getNext() != null) {
                pointer = pointer.getNext();
                cont++;
            }
            return pointer.getElement();
        }
    }
    
    /**
     * Método para obtener la posición de un nodo dado en la lista. Si el nodo
     * no se encuentra en la lista, se devuelve -1.
     *
     * @param nodito el nodo del que se desea conocer la posición
     * @return la posición del nodo en la lista, o -1 si el nodo no se encuentra
     * en la lista
     */
    public int getIndex (Nodo nodito){
        if (!isEmpty()){
            Nodo aux = head;
            int count = 0;
            while(aux.getNext() != null){ 
                if (nodito == aux){
                    return count;     //posicion en memoria del nodo
                }
                count ++;
                aux = aux.getNext();
            }
            return -1;
        }
        return -1;
    }
    
    /**
     * Método para consultar la posición de un elemento en la lista. Si el
     * elemento no se encuentra en la lista, se devuelve -1.
     *
     * @param referencia el elemento del que se desea conocer la posición
     * @return la posición del elemento en la lista, o -1 si el elemento no se
     * encuentra en la lista
     */
    public int getPosicion(Object referencia){
        if (buscar(referencia)) {
            
            Nodo aux = head;
            int cont = 0;
            while(referencia != aux.getElement()){
                cont ++;
                aux = aux.getNext();
            }
            return cont;
        } else {
            return -1;
        }
    }
    
    /**
     * Método para imprimir la lista enlazada.
     *
     */
    public void printList(){
        if(!isEmpty()){
            Nodo aux = head;
            String expresion = "Lista:\n";
            for(int i = 0; i < size; i++) {
               expresion = expresion + aux.getElement() + "\n";
               aux = aux.getNext();
            }
            JOptionPane.showMessageDialog(null,expresion);
            
        }else{
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }
    
    //Buscar
    public boolean buscar(Object dato) {
        Nodo aux = head;
        while (aux!=null) {
            if (aux.getElement() == dato)
                return true;
            aux= aux.getNext();
        }
        return false;
    }
    /**
     * Método para eliminar todos los elementos de la lista enlazada.
     */
    public void eliminar(){
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
    * Método que devuelve una representación en forma de cadena de la lista enlazada.
    * Si la lista está vacía, devuelve "[]". En caso contrario, devuelve una cadena
    * en la forma: "[elemento1, elemento2, ..., elementoN]".
    * 
    * @return cadena de caracteres representando la lista enlazada
    */
    public String toString2() {
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            Nodo temp = head;
            
            while (temp != null) {
                sb.append(temp.toString()).append(", ");
                temp = temp.getNext();
            }
            sb.setLength(sb.length() - 2); // para eliminar la última coma y espacio
            sb.append("]");
            return sb.toString();
        }
    }
    
    /**
     * Método que devuelve el historial de los clientes en la lista enlazada en
     * forma de cadena de caracteres. Si la lista está vacía, devuelve null
     *
     * @return historial de los clientes en la lista enlazada
     */
    public String ListaHist_String() {
        if (size == 0) {
            return null;
        } else {
            String historial = "";
            Nodo objeto = this.head;
            int i = 1;
            while(objeto != null){
                Estado dato = (Estado) objeto.getElement();
                historial += i + ") CLIENTE: " + dato.getCliente().getNombre() + " " + dato.getCliente().getApellido() + "\nFECHA DE LLEGADA: " + dato.getLlegada();
                if(dato.getAcompañantes().getSize() != 0){
                    historial += "\nACOMPAÑANTES:\n";
                    for (int j = 0; j < dato.getAcompañantes().getSize(); j++) {
                        Estado cliente = (Estado) dato.getAcompañantes().getValor(j);
                        historial += "\t" + (j+1) + ") " + cliente.getCliente().getNombre() + " " + cliente.getCliente().getApellido() + "\n\tFECHA DE LLEGADA: " + cliente.getLlegada() + "\n";

                    } 
                }
                if(objeto.getNext() != null){
                    historial += "\n\n";
                }
                objeto = objeto.getNext();
                i += 1;
            }
            return historial;
            }
        }
    
    /**
     * Método que devuelve una representación en forma de cadena de la lista
     * enlazada, donde cada elemento de la lista es convertido a una cadena de
     * caracteres usando el método toString2() de la clase Estado. Si la lista
     * está vacía, devuelve null.
     *
     * @return cadena de caracteres representando la lista enlazada
     */

    public String transformar(){
        if(!isEmpty()){
            Nodo aux = head;
            String expresion = "";
            for(int i = 0; i < size; i++) {
                Estado estado = (Estado) aux.getElement();
                
               expresion = expresion + estado.toString2() + "\n";
               aux = aux.getNext();
            }
            return expresion;
            
        }else{
            return null;
        }
    }
    
    }
    

