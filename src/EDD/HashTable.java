/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Clases.Cliente;
import Clases.Estado;

/**
 *
 * @author Victoria Saldivia
 */
/**
 * Clase HashTable que representa una tabla hash con una capacidad inicial de 300.
 * Cada celda de la tabla contiene un objeto de la clase Estado.
 * Contiene métodos para obtener y modificar el tamaño de la tabla y los estados almacenados en ella.
 * También incluye un método para inicializar la tabla hash.
 */

public class HashTable {
    
    // Atributos de la clase HashTable
    private int size;
    private Estado[] estado;

    /**
     * Constructor por defecto que inicializa el tamaño de la tabla en 300 y el
     * arreglo de estados en null.
     */
    public HashTable() {
        this.size = 300;
        this.estado = new Estado[size];
    }
    
    // Getters y Setters de cada uno de los atributos
    public int getSize() {
        return size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }

    public Estado[] getEstado() {
        return estado;
    }
    
    public void setEstado(Estado[] estado) {
        this.estado = estado;
    }
    
    /**
     * Método que reinicializa el arreglo de estados de la tabla hash.
     * Inicializa cada celda del arreglo con un objeto null.
     */
    public void initTable(){
        setEstado(new Estado[getSize()]);
        for (int i = 0; i < size; i++) {
            getEstado()[i] = null;
        }
    }
    
    /*Inserta en la HashTable un documento en la posición que indique la clave única*/
    public void insertEstado(Estado estado){
        if (!isInHash(estado)) {
            int index = estado.getNumHab();
            while (getEstado()[index] != null) {
                index++;
            }
//            JOptionPane.showMessageDialog(null, "La clave del Cliente " + estado.getCliente().getNombre()+ " es: " + index);
            getEstado()[index] = estado;
        } else{
//            JOptionPane.showMessageDialog(null, "¡ERROR!\nEl estado ya está registrado");
        }
    }
    
    /*Verifica si un documento ya existe en la HashTable*/
    public boolean isInHash(Estado est){
        boolean aux = false;
        for (int i = 0; i < this.getEstado().length; i++) {
            if (getEstado()[i] != null){
                if (getEstado()[i].compareEstado(est)){
                    aux = true;
                }
            }
        }
        return aux;
    }
    
    /*Verifica si un documento ya existe en la HashTable*/
    public int isInHashIndex(Estado est){
        for (int i = 0; i < this.getEstado().length; i++) {
            if (getEstado()[i] != null){
                if (getEstado()[i].compareEstado(est)){
                    return i;
                }
            }
        }
        
        return -1;
    }
    
    /**
     * Función que busca en la tabla hash un cliente dado por su nombre y
     * apellido y devuelve el índice donde se encuentra este cliente. Si no se
     * encuentra, devuelve -1.
     *
     * @param cliente El cliente a buscar en la tabla hash.
     * @return Un entero que representa el índice donde se encuentra el cliente
     * en la tabla hash. Si no se encuentra, devuelve -1.
     */
    public int isInHashIndexN(Cliente cliente){
        for (int i = 0; i < this.getEstado().length; i++) {
            if (getEstado()[i] != null){
                if (getEstado()[i].getCliente().getNombre().equalsIgnoreCase(cliente.getNombre()) && getEstado()[i].getCliente().getApellido().equalsIgnoreCase(cliente.getApellido())){
                    return i;
                }
            }
        }
        
        return -1;
    }
    
    /**
     * Función que busca en la tabla hash un cliente dado por su nombre y
     * apellido y devuelve el objeto Estado asociado a este cliente. Si no se
     * encuentra, devuelve null.
     *
     * @param cliente El cliente a buscar en la tabla hash.
     * @return Un objeto Estado asociado al cliente dado. Si no se encuentra,
     * devuelve null.
     */
    public Estado isInHashEstado(Cliente cliente){
        for (int i = 0; i < this.getEstado().length; i++) {
            if (getEstado()[i] != null){
                if (getEstado()[i].getCliente().getNombre().equalsIgnoreCase(cliente.getNombre()) && getEstado()[i].getCliente().getApellido().equalsIgnoreCase(cliente.getApellido())){
                    return getEstado()[i];
                }
            }
        }
        
        return null;
    }
    
    /**
     * Función que itera sobre la tabla hash y agrega un objeto Estado a la
     * lista de acompañantes de un objeto Estado dado, en la posición de
     * habitación dada.
     *
     * @param est El objeto Estado a agregar a la lista de acompañantes.
     * @param num_hab La posición de la habitación donde agregar el objeto
     * Estado.
     */
    public void insertAcomp(Estado est, int num_hab) {
        for (int i = 0; i < this.getEstado().length; i++) {
            if (getEstado()[i] != null && i == num_hab) {
                getEstado()[i].agregar_acomp(est);
                break;
            }
        }
    }
    
    /**
     * Función que itera sobre la tabla hash y agrega a una lista doblemente
     * enlazada los índices donde la tabla hash está vacía.
     *
     * @param hab_disp La lista doblemente enlazada donde se van a agregar los
     * índices vacíos de la tabla hash.
     */
    public void Disponibles(ListaDoble hab_disp){
        for (int i = 1; i < this.getEstado().length; i++) {
            if (getEstado()[i] == null){
                hab_disp.insertFinal(i);
            }
        }
    }
    
    /**
     * Función que elimina un objeto Estado de la tabla hash en la posición de
     * habitación dada.
     *
     * @param numHab La posición de la habitación donde se encuentra el objeto
     * Estado a eliminar.
     */
    public void eliminarEstado(int numHab) {
    int index = numHab;
    if (index >= 0 && index < size) {
        if (estado[index] != null) {
            estado[index] = null;
        } else {
            System.out.println("No se encontró un Estado en la posición: " + index);
        }
    } else {
        System.out.println("Número de habitación fuera de rango.");
        }
    }
    
    /**
     * Función que itera sobre la tabla hash y devuelve una representación en
     * forma de cadena de texto de la tabla hash. Cada objeto Estado en la tabla
     * hash se representa en la cadena de texto usando el método toString3() y
     * se guarda en la variable tabla. Si el objeto Estado contiene una lista de
     * acompañantes, cada uno de los objetos Estado en la lista de acompañantes
     * también se representa en la cadena de texto usando el método toString4()
     * y se guarda en la variable tabla.
     *
     * @return La representación en forma de cadena de texto de la tabla hash.
     */

    public String transformar(){
        String tabla =  "";
        for (int i = 1; i < this.getEstado().length; i++) {
            if (getEstado()[i] != null) {
                tabla += getEstado()[i].toString3() + "\n";
                if(!getEstado()[i].getAcompañantes().isEmpty()){
                    for (int j = 0; j < getEstado()[i].getAcompañantes().getSize(); j++) {
                        Estado estado = (Estado) getEstado()[i].getAcompañantes().getValor(j);
                        tabla += estado.toString4() + "\n";    
                    }
                }
            }
        }   
        return tabla;
    }
}
