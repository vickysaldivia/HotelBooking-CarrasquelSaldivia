/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EDD.ListaDoble;

/**
 *
 * @author Ramón Carrasquel
 */
public class Estado {

    private Cliente cliente;
    private ListaDoble acompañantes;
    private String llegada;
    private int numHab;

    public Estado(Cliente cliente, String llegada, int numHab) {
        this.cliente = cliente;
        this.llegada = llegada;
        this.numHab = numHab;
        this.acompañantes = new ListaDoble();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public int getNumHab() {
        return numHab;
    }

    public void setNumHab(int numHab) {
        this.numHab = numHab;
    }
    
    
    public ListaDoble getAcompañantes() {
        return acompañantes;
    }

    public void setAcompañantes(ListaDoble acompañantes) {
        this.acompañantes = acompañantes;
    }
    
    public void agregar_acomp(Estado estado){
        this.acompañantes.insertFinal(estado);
    }
    
    public boolean compareEstado(Estado estado) {
        return (estado.getCliente().getCelular() == null ? this.cliente.getCelular() == null : estado.getCliente().getCelular().equals(this.cliente.getCelular())) && estado.getCliente().getNombre().equalsIgnoreCase(this.cliente.getNombre());
    }

    @Override
    public String toString() {
        return "Cliente:" + cliente.getNombre() + " "+ cliente.getApellido() +", " + cliente.getCedula()+ "\nFecha de llegada: " + llegada + "\nNumero de Habitacion: " + numHab + '}';
    }
    
    public String toString2() {
        return cliente.cedulaFormat()+ "," + cliente.getNombre() + ","+ cliente.getApellido() +"," +cliente.getEmail() +","+ cliente.getGenero()+","+llegada + "," + numHab;
    }
    
    public String toString3() {
        return numHab+","+ cliente.getNombre() + ","+ cliente.getApellido() +"," +cliente.getEmail() +","+ cliente.getGenero()+","+cliente.getCelular()+","+llegada;
    }
    
    public String toString4() {
        return ","+ cliente.getNombre() + ","+ cliente.getApellido() +"," +cliente.getEmail() +","+ cliente.getGenero()+","+cliente.getCelular()+","+llegada;
    }
    
}
