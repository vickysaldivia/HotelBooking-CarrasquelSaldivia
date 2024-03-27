/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import Clases.Cliente;
import Clases.Estado;
import Clases.Habitacion;
import Clases.Reservacion;
import EDD.ABB;
import EDD.AVL;
import EDD.HashTable;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
                            //if (help.ValidarCedula(info[0]) != -1 && help.validarEmail(info[3]) && help.validarTelf(info[5]) && help.validarFecha(info[7]) && help.validarFecha(info[7])) {
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

    public void leer_historial(AVL habitaciones) {
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
//                            if (help.validarCedula(info[0]) && help.validarEmail(info[3]) && help.validarFecha(info[55])) {
                            int cedula = Integer.parseInt(info[0].replaceAll("\\.", ""));
                            String nombre = info[1];
                            String apellido = info[2];
                            String email = info[3];
                            String genero = info[4];
                            String llegada = info[5];

                            Cliente cliente = new Cliente(nombre, apellido, cedula, email, genero);

                            int num_hab = Integer.parseInt(info[6]);
                            Estado estado = new Estado(cliente, llegada, num_hab);

                            habitaciones.searchByKey(num_hab).getHistorial().insertFinal(estado);

                            //}
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
                    int ultima_hab = 0;
                    for (int i = 0; i < expresion_split.length - 1; i++) {
                        String[] info = expresion_split[i].split(",");
                        if (!info[0].equalsIgnoreCase("")) {
                            if (help.validarNumero(info[0]) && help.validarEmail(info[3]) && help.validarTelf(info[5])) {
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

                                ultima_hab = num_hab;
                            } else {
                                JOptionPane.showMessageDialog(null, "Hay un error en algun dato");
                                break;
                            }
                        } else {
                            if (i != 0) {
                                if (help.validarEmail(info[3]) && help.validarTelf(info[5])) {

                                    String nombre = info[1];
                                    String apellido = info[2];
                                    String email = info[3];
                                    String sexo = info[4];
                                    String telf = info[5];

                                    Cliente cliente = new Cliente(nombre, apellido, email, sexo, telf);

                                    String fecha_llegada = info[6];
                                    Estado estado = new Estado(cliente, fecha_llegada, ultima_hab);

                                    table.insertAcomp(estado, ultima_hab);

                                } else {
                                    JOptionPane.showMessageDialog(null, "Hay un error en algun dato");
                                    break;
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

    public void leer_habitaciones(AVL habitaciones) {
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

                    }
                }
                if (!"".equals(expresion_txt)) {
                    String[] expresion_split = expresion_txt.split("\n");
                    for (int i = 0; i < expresion_split.length; i++) {
                        String[] info = expresion_split[i].split(",");
                        if (!info[0].equalsIgnoreCase("")) {
                            //if (help.validarNumero(info[0]) && help.validarTipoHab(info[1]) && help.validarNumero(info[2]) ) {
                            int num_hab = Integer.parseInt(info[0]);
                            String tipoHab = info[1];
                            int piso = Integer.parseInt(info[2]);
                            Habitacion habitacion = new Habitacion(num_hab, tipoHab, piso);
                            habitaciones.insertar(num_hab, habitacion);
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

    public void write_estado(HashTable table) {
        String path = "test//estado.csv";
        if (table.getSize() > 0) {
            String info = table.transformar().substring(0,table.transformar().length()-2);
            try {
                FileWriter writer = new FileWriter(path);
                writer.write(info);
                writer.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al escribir en el archivo");
            }
        }
    }

    public void write_reservas(ABB reservas) {
        String path = "test//reservas.csv";
        String cadena = "";
        String info = reservas.preOrden2(reservas.getNodoRaiz(), cadena).substring(0, reservas.preOrden2(reservas.getNodoRaiz(), cadena).length()-2);
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(info);
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo");
        }

    }

    public void write_habitaciones(AVL habitaciones) {
        String path = "test//Habitaciones.csv";

        String info = habitaciones.inOrden().substring(0, habitaciones.inOrden().length()-2);
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(info);
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo");
        }

    }

    public void write_historial(AVL habitaciones) {
        String path = "test//Historico.csv";

        String info = habitaciones.inOrdenHistorico().substring(0, habitaciones.inOrdenHistorico().length()-2);
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(info);
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo");
        }

    }
}
