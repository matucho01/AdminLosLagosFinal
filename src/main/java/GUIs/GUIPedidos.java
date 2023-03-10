/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import ec.edu.epn.adminloslagos.Inventario;
import ec.edu.epn.adminloslagos.LectorDatos;
import ec.edu.epn.adminloslagos.Registro;
import ec.edu.epn.adminloslagos.Turno;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.plaf.FileChooserUI;

/**
 *
 * @author teote
 */
public class GUIPedidos extends javax.swing.JFrame {

    /**
     * Creates new form GUIPedidos
     */
    
    LectorDatos lectorDatos = new LectorDatos();
        
    // Inventario
    Inventario inventario = new Inventario();
    String filePath = "";
        
        
    // Turnos
   
    public GUIPedidos() {
        initComponents();
        inventario.setGalonesSuper(400.23f);
        inventario.setGalonesExtra(1200.23f);
        inventario.setGalonesDiesel(704.35f);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGenerarPedido = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResult = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txtFPath = new javax.swing.JTextField();
        btnPahtTurnos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGenerarPedido.setText("Generar Pedido");
        btnGenerarPedido.setEnabled(false);
        btnGenerarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPedidoActionPerformed(evt);
            }
        });

        txtResult.setColumns(20);
        txtResult.setRows(5);
        jScrollPane1.setViewportView(txtResult);

        jLabel1.setText("Lecturas de turnos");

        txtFPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFPathActionPerformed(evt);
            }
        });

        btnPahtTurnos.setText("...");
        btnPahtTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPahtTurnosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(btnGenerarPedido))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtFPath, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPahtTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPahtTurnos))
                .addGap(10, 10, 10)
                .addComponent(btnGenerarPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPedidoActionPerformed
        Registro registro = new Registro();
        ArrayList<Turno> turnos = lectorDatos.obtenerLecturasPorTurno(filePath);
        ArrayList<Float> totalGalonesPedido = registro.proyectarVentas("24-10-22", 
                turnos,inventario.getGalonesSuper(), inventario.getGalonesExtra(), 
                inventario.getGalonesDiesel());
        txtResult.setText("Galones de Super: "+totalGalonesPedido.get(0)*1000+
                "\nGalones de Extra: "+totalGalonesPedido.get(1)*1000+
                "\nGalones de Diesel: "+totalGalonesPedido.get(2)*1000);
    }//GEN-LAST:event_btnGenerarPedidoActionPerformed

    private void txtFPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFPathActionPerformed

    private void btnPahtTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPahtTurnosActionPerformed
        JFileChooser fileChooser = new JFileChooser("src/main/java/documents/");
        int seleccion = fileChooser.showOpenDialog(this);
        if(seleccion == JFileChooser.APPROVE_OPTION){
            txtFPath.setText(fileChooser.getSelectedFile().getPath());
            filePath = fileChooser.getSelectedFile().getPath();
            btnGenerarPedido.setEnabled(true);
        }
        
    }//GEN-LAST:event_btnPahtTurnosActionPerformed

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
            java.util.logging.Logger.getLogger(GUIPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarPedido;
    private javax.swing.JButton btnPahtTurnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtFPath;
    private javax.swing.JTextArea txtResult;
    // End of variables declaration//GEN-END:variables
}
