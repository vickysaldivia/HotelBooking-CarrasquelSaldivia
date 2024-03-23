/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import Clases.Cliente;
import Clases.Estado;
import Clases.Habitacion;
import Clases.Historial;
import Clases.Reservacion;
import EDD.ABB;
import EDD.HashTable;
import EDD.ListaDoble;
import EDD.NodoAB;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramón Carrasquel
 */
public class ArchivoCSV {

    helpers help = new helpers();

    public void leer_reservaciones(ABB reservaciones) {
        String line;
        String expresion_txt = "";
        String path = "test//Reservas.csv";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        expresion_txt += line + "\n";
                        
                    }
                }
                if (!"".equals(expresion_txt)) {
                    String[] expresion_split = expresion_txt.split("\n");
                    for (int i = 0; i < expresion_split.length - 1; i++) {
                        String[] info = expresion_split[i].split(",");
                        
                        
                        if (!info[0].equalsIgnoreCase("")) {
                            //if (help.ValidarCedula(info[0]) != -1 && help.validarEmail(info[3]) && help.validarTelf(info[5]) && help.validarFecha(info[7])) {
                                
                                int cedula = help.ValidarCedula(info[0]);
                                String nombre = info[1];
                                String apellido = info[2];
                                String email = info[3];
                                String genero = info[4];
                                String tipo_hab = info[5];
                                String telf = info[6];

                                Cliente cliente = new Cliente(nombre, apellido, cedula, email, genero, telf);

                                String llegada = info[7];
                                String salida = info[8];

                                Reservacion reservacion = new Reservacion(cliente, tipo_hab, llegada, salida);
                                reservaciones.insertNodo(reservaciones.getNodoRaiz(), reservacion, cedula);
//                            } else {
//                                JOptionPane.showMessageDialog(null, "Hay un error en algun dato");
//                                break;
//                            }
                        }
                    }
                }
                br.close();
            }
        } catch (HeadlessException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer la expresion");
        }
    }

    public void leer_historial(ABB historiales) {
        String line;
        String expresion_txt = "";
        String path = "test//Historico.csv";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        expresion_txt += line + "\n";
                    }
                }
                if (!"".equals(expresion_txt)) {
                    String[] expresion_split = expresion_txt.split("\n");
                    for (int i = 0; i < expresion_split.length - 1; i++) {
                        String[] info = expresion_split[i].split(",");
                        if (!info[0].equalsIgnoreCase("")) {
                            if (help.validarCedula(info[0]) && help.validarEmail(info[3]) && help.validarFecha(info[5])) {
                                int cedula = Integer.parseInt(info[0].replaceAll(".", ""));
                                String nombre = info[1];
                                String apellido = info[2];
                                String email = info[3];
                                String genero = info[4];
                                String llegada = info[5];

                                Cliente cliente = new Cliente(nombre, apellido, cedula, email, genero);

                                int num_hab = Integer.parseInt(info[0]);
                                Estado estado = new Estado(cliente, llegada, num_hab);

                                if (historiales.buscarNodo(num_hab, historiales.getNodoRaiz()) == null) {
                                    ListaDoble estados = new ListaDoble();
                                    estados.insertFinal(estado);
                                    Historial historial = new Historial(num_hab, estados);

                                    historiales.insertNodo(historiales.getNodoRaiz(), estado, num_hab);
                                } else {

                                    historiales.ModifHistorial(num_hab, historiales.getNodoRaiz(), estado);

                                }
                            }
                        }

                    }
                }
                br.close();
            }
        } catch (HeadlessException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer la expresion");
        }

    }

    public void Leer_Estado(HashTable table) {
        String line;
        String expresion_txt = "";
        String path = "test//Estado.csv";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        expresion_txt += line + "\n";
                    }
                }
                if (!"".equals(expresion_txt)) {
                    String[] expresion_split = expresion_txt.split("\n");
                    for (int i = 0; i < expresion_split.length - 1; i++) {
                        String[] info = expresion_split[i].split(",");
                        if (!info[0].equalsIgnoreCase("")) {
                            if (help.validarNumero(info[0]) && help.validarEmail(info[3]) && help.validarTelf(info[5]) ) {
                                int num_hab = Integer.parseInt(info[0]);
                                String nombre = info[1];
                                String apellido = info[2];
                                String email = info[3];
                                String sexo = info[4];
                                String telf = info[5];
                                
                                Cliente cliente = new Cliente(nombre, apellido, email, sexo, telf);

                                String fecha_llegada = info[6];
                                Estado estado = new Estado(cliente, fecha_llegada, num_hab);

                                table.insertEstado(estado);
                            } else {
                                JOptionPane.showMessageDialog(null, "Hay un error en algun dato");
                                break;
                            }
                        }
                    }
                }
               br.close();
            }
        } catch (HeadlessException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer la expresion");
        }
    }

    public void leer_habitaciones(ListaDoble habitaciones) {
        String line;
        String expresion_txt = "";
        String path = "test//Habitaciones.csv";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        expresion_txt += line + "\n";
                        System.out.println(line);
                    }
                }
                if (!"".equals(expresion_txt)) {
                    String[] expresion_split = expresion_txt.split("\n");
                    for (int i = 0; i < expresion_split.length; i++) {
                        String[] info = expresion_split[i].split(",");
                        if (!info[0].equalsIgnoreCase("")) {
                            if (help.validarNumero(info[0]) && help.validarTipoHab(info[1]) && help.validarNumero(info[2]) ) {
                                int num_hab = Integer.parseInt(info[0]);
                                String tipoHab = info[1];
                                int piso = Integer.parseInt(info[2]);
                                Habitacion habitacion = new Habitacion(num_hab, tipoHab, piso);
                                habitaciones.insertFinal(habitacion);
                            } else {
                                JOptionPane.showMessageDialog(null, "Hay un error en algun dato");
                                break;
                            }
                        }
                    }
                }
                br.close();
            }
        } catch (HeadlessException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer la expresion");
        }
    }

}
