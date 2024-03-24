/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Cliente;
import EDD.ABB;
import EDD.AVL;
import EDD.HashTable;
import EDD.ListaDoble;
import Funciones.ArchivoCSV;

/**
 *
 * @author Victoria Saldivia
 */
public class Bienvenidos extends javax.swing.JFrame {

    public static HashTable hospedados = new HashTable();
    public static ABB reservaciones =  new ABB();
    public static AVL habitaciones = new AVL();
    public static ListaDoble hab_disponibles = new ListaDoble();
    
    public Bienvenidos() {
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IngresarMenu = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 139));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("\"Administre fácilmente las reservas y estadías de los huéspedes\"");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 500, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 139));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SISTEMA DE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 500, 40));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 139));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DE RESERVAS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 500, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 38)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 139));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ADMINISTRACIÓN");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 500, 50));

        IngresarMenu.setBackground(new java.awt.Color(0, 51, 139));
        IngresarMenu.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        IngresarMenu.setForeground(new java.awt.Color(255, 255, 255));
        IngresarMenu.setText("Ingresar al Sistema");
        IngresarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarMenuActionPerformed(evt);
            }
        });
        jPanel1.add(IngresarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, 30));

        jButton1.setBackground(new java.awt.Color(0, 51, 139));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarMenuActionPerformed
        // TODO add your handling code here:
        ArchivoCSV archivo = new ArchivoCSV();
        archivo.Leer_Estado(hospedados);
        archivo.leer_reservaciones(reservaciones);
        archivo.leer_habitaciones(habitaciones);
        archivo.leer_historial(habitaciones);
        
        hospedados.Disponibles(hab_disponibles);
        
        for (int i = 0; i < hab_disponibles.getSize(); i++) {
            int num_hab = (int) hab_disponibles.getValor(i); 
            habitaciones.searchByKey(num_hab).setDispo(true);
        }
        
        //habitaciones.inOrden();
        
        
       //hab_disponibles.printList();

        //System.out.println(hospedados.getEstado()[277].getCliente().getNombre());
       //habitaciones.searchByKey(277).mostrar_hitorial();

        
        //System.out.println(reservaciones.preOrden2(reservaciones.getNodoRaiz(), cadena));
       
                
        Menu VentanaMenu = new Menu();
        
        this.setVisible(false);
        VentanaMenu.setLocationRelativeTo(null);
        VentanaMenu.setVisible(true);
        
    }//GEN-LAST:event_IngresarMenuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bienvenidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bienvenidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bienvenidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bienvenidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bienvenidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IngresarMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
