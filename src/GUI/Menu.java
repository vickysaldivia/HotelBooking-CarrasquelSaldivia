/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Funciones.ArchivoCSV;
import static GUI.Bienvenidos.habitaciones;
import static GUI.Bienvenidos.hospedados;
import static GUI.Bienvenidos.reservaciones;
import javax.swing.JOptionPane;

/**
 *
 * @author Victoria Saldivia
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
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
        jPanel2 = new javax.swing.JPanel();
        CerrarSesion = new javax.swing.JButton();
        HistorialHab = new javax.swing.JButton();
        BuscarReservacion = new javax.swing.JButton();
        BuscarHospedados = new javax.swing.JButton();
        CheckOut = new javax.swing.JButton();
        CheckIn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 139));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CerrarSesion.setBackground(new java.awt.Color(255, 255, 255));
        CerrarSesion.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        CerrarSesion.setForeground(new java.awt.Color(0, 51, 139));
        CerrarSesion.setText("Cerrar Sesión");
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });
        jPanel2.add(CerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 17, 200, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 390, 60));

        HistorialHab.setBackground(new java.awt.Color(0, 51, 139));
        HistorialHab.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        HistorialHab.setForeground(new java.awt.Color(255, 255, 255));
        HistorialHab.setText("Historial de Habitaciones");
        HistorialHab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistorialHabActionPerformed(evt);
            }
        });
        jPanel1.add(HistorialHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 300, -1));

        BuscarReservacion.setBackground(new java.awt.Color(0, 51, 139));
        BuscarReservacion.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        BuscarReservacion.setForeground(new java.awt.Color(255, 255, 255));
        BuscarReservacion.setText("Reservaciones Actuales");
        BuscarReservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarReservacionActionPerformed(evt);
            }
        });
        jPanel1.add(BuscarReservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 300, 30));

        BuscarHospedados.setBackground(new java.awt.Color(0, 51, 139));
        BuscarHospedados.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        BuscarHospedados.setForeground(new java.awt.Color(255, 255, 255));
        BuscarHospedados.setText("Clientes Hospedados");
        BuscarHospedados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarHospedadosActionPerformed(evt);
            }
        });
        jPanel1.add(BuscarHospedados, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 300, -1));

        CheckOut.setBackground(new java.awt.Color(0, 51, 139));
        CheckOut.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        CheckOut.setForeground(new java.awt.Color(255, 255, 255));
        CheckOut.setText("Check-Out");
        CheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckOutActionPerformed(evt);
            }
        });
        jPanel1.add(CheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 130, 30));

        CheckIn.setBackground(new java.awt.Color(0, 51, 139));
        CheckIn.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        CheckIn.setForeground(new java.awt.Color(255, 255, 255));
        CheckIn.setText("Check-In");
        CheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInActionPerformed(evt);
            }
        });
        jPanel1.add(CheckIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 130, 30));

        jLabel2.setBackground(new java.awt.Color(0, 51, 139));
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 139));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Detalles del Hotel");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 390, -1));

        jLabel3.setBackground(new java.awt.Color(0, 51, 139));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 139));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Estadía del Cliente");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 390, -1));

        jPanel3.setBackground(new java.awt.Color(0, 51, 139));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MENÚ PRINCIPAL");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 390, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 60));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 350, 120));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 350, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckInActionPerformed
        // TODO add your handling code here:
        CheckIn in = new CheckIn();
        this.setVisible(false);
        in.setLocationRelativeTo(null);
        in.setVisible(true);
    }//GEN-LAST:event_CheckInActionPerformed

    private void CheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckOutActionPerformed
        // TODO add your handling code here:
        CheckOut out = new CheckOut();
        this.setVisible(false);
        out.setLocationRelativeTo(null);
        out.setVisible(true);
    }//GEN-LAST:event_CheckOutActionPerformed

    private void BuscarHospedadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarHospedadosActionPerformed
        // TODO add your handling code here:
        BuscarHosp hosp = new BuscarHosp();
        this.setVisible(false);
        hosp.setLocationRelativeTo(null);
        hosp.setVisible(true);
    }//GEN-LAST:event_BuscarHospedadosActionPerformed

    private void BuscarReservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarReservacionActionPerformed
        // TODO add your handling code here:
        BuscarReserva res = new BuscarReserva();
        this.setVisible(false);
        res.setLocationRelativeTo(null);
        res.setVisible(true);
    }//GEN-LAST:event_BuscarReservacionActionPerformed

    private void HistorialHabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistorialHabActionPerformed
        // TODO add your handling code here:
        HistorialHab hab = new HistorialHab();
        this.setVisible(false);
        hab.setLocationRelativeTo(null);
        hab.setVisible(true);
    }//GEN-LAST:event_HistorialHabActionPerformed

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed
        // TODO add your handling code here:
        ArchivoCSV archivo = new ArchivoCSV();
       archivo.write_estado(hospedados);
       archivo.write_habitaciones(habitaciones);
       archivo.write_historial(habitaciones);
       archivo.write_reservas(reservaciones);
        JOptionPane.showMessageDialog(null,"Entendido, cerrando sesión...\nHasta pronto.");
        Bienvenidos ventana = new Bienvenidos();
        this.setVisible(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }//GEN-LAST:event_CerrarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarHospedados;
    private javax.swing.JButton BuscarReservacion;
    private javax.swing.JButton CerrarSesion;
    private javax.swing.JButton CheckIn;
    private javax.swing.JButton CheckOut;
    private javax.swing.JButton HistorialHab;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}