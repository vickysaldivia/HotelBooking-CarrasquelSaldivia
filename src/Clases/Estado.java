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

/**
 * Representa el estado de un cliente en un hotel, incluyendo su fecha de
 * llegada, número de habitación y lista de sus acompañantes.
 */

public class Estado {

    // Atributos de la clase Estado
    private Cliente cliente;
    private ListaDoble acompañantes;
    private String llegada;
    private int numHab;

    /**
     * Construye un nuevo objeto ⁠ Estado ⁠ con el cliente dado, hora de llegada
     * y número de habitación de hotel.
     *
     * @param cliente El cliente asociado a esta reserva
     * @param llegada La hora de llegada del cliente.
     * @param numHab El número de habitación de hotel asignado al cliente
     */

    public Estado(Cliente cliente, String llegada, int numHab) {
        this.cliente = cliente;
        this.llegada = llegada;
        this.numHab = numHab;
        this.acompañantes = new ListaDoble();
    }
    
    // Getters y Setters de cada uno de los atributos
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
    
    /**
     * Agrega un invitado acompañante a la lista de acompañantes.
     *
     * @param estado El estado de la reserva del acompañante
     */
    public void agregar_acomp(Estado estado){
        this.acompañantes.insertFinal(estado);
    }
    
    /**
     * Compara el estado de la instancia actual con el objeto {@code Estado}
     * dado. La comparación se basa en el nombre y número de celular del
     * cliente. Si alguno de los números de celular es {@code null}, entonces se
     * consideran iguales. La comparación de nombres no distingue entre
     * mayúsculas y minúsculas.
     *
     * @param estado el objeto {@code Estado} para comparar con la instancia
     * actual
     * @return {@code true} si los estados son iguales, {@code false} en caso
     * contrario
     */
    public boolean compareEstado(Estado estado) {
        return (estado.getCliente().getCelular() == null ? this.cliente.getCelular() == null : estado.getCliente().getCelular().equals(this.cliente.getCelular())) && estado.getCliente().getNombre().equalsIgnoreCase(this.cliente.getNombre());
    }

    // Métodos adicionales para convertir el estado en cadenas
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
