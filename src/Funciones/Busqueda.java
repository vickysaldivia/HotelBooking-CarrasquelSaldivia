/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import Clases.Cliente;
import Clases.Reservacion;
import EDD.ABB;
import EDD.HashTable;
import EDD.NodoAB;

/**
 *
 * @author Victoria Saldivia
 */
public class Busqueda {
    
    /**
     * Busca una reservación y devuelve una cadena con la información relevante
     * de la misma.
     *
     * @param nodo el nodo que contiene la reservación a buscar
     * @return una cadena que representa la información de la reservación
     * encontrada
     */
    public String buscarReservacion(NodoAB nodo){
        Reservacion reserva = (Reservacion) nodo.getDato();
        String res = "";
        res += "CLIENTE: " + reserva.getCliente().getNombre() + " " + reserva.getCliente().getApellido() + "\nGÉNERO: " + reserva.getCliente().getGenero()+ "\n\nC.I.: " + String.valueOf(reserva.getCliente().getCedula()) + "\nTELÉFONO: " + reserva.getCliente().getCelular();
        res += "RESERVA" +  "ESTADÍA: " + "\nLlegada: " + reserva.getLlegada() + "\nSalida: " + reserva.getSalida();
        res += "\n\n" + "TIPO DE HABITACIÓN: " + reserva.getTipoHab();
        return res;
    }
    
    /**
     * Busca un cliente hospedado y devuelve una cadena con la información
     * relevante.
     *
     * @param cliente el cliente hospedado que se desea buscar
     * @param hospedados la tabla hash que contiene la información de los
     * clientes hospedados
     * @param i el índice en la tabla hash donde se encuentra la información del
     * cliente
     * @return una cadena que representa la información del cliente hospedado
     * encontrado
     */
    public String buscarHospedado(Cliente cliente, HashTable hospedados, int i){
        String cadena = "";
        
        cadena += "CLIENTE: " + cliente.getNombre() + " " + cliente.getApellido() + "\nTELÉFONO: " + hospedados.getEstado()[i].getCliente().getCelular() + "\n\n" + "LLEGADA: " + String.valueOf(hospedados.getEstado()[i].getLlegada());
        cadena += "\n\n" + "HABITACIÓN: " + hospedados.isInHashIndexN(cliente);
        
        return cadena;
    }
    
}
