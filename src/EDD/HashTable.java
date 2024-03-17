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
public class HashTable {
    private int size;
    private Estado[] estado;

    public HashTable() {
        this.size = 300;
        this.estado = new Estado[size];
    }
    
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
    
    public void Disponibles(ListaDoble hab_disp){
        for (int i = 1; i < this.getEstado().length; i++) {
            if (getEstado()[i] == null){
                hab_disp.insertFinal(i);
            }
        }
    }
}
