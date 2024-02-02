/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tutor.up.gui;

import it.tutor.up.PostalOffice;
import it.tutor.up.ServiziType;
import it.tutor.up.logic.Settings;

/**
 *
 * @author mario
 */
public class SimulationGui extends javax.swing.JFrame {

    /**
     * Creates new form SimulationGui
     */
    public SimulationGui() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("SimulationGui "+ Settings.VERSION);
        jPanelSportello1.setNumber("1");
        jPanelSportello2.setNumber("2");
        jPanelSportello3.setNumber("3");
        jPanelSportello4.setNumber("4");
        
        jPanelSportello1.setService("<html>" + String.valueOf(ServiziType.PAGAMENTI) + "<br>" + ServiziType.SPEDIZIONI);
        jPanelSportello2.setService("<html>" + String.valueOf(ServiziType.PAGAMENTI) + "<br>" + ServiziType.SPEDIZIONI);
        jPanelSportello3.setService("<html>" + String.valueOf(ServiziType.PAGAMENTI) + "<br>" + ServiziType.SPEDIZIONI);
        jPanelSportello4.setService("<html>" + String.valueOf(ServiziType.PAGAMENTI) + "<br>" + ServiziType.SPEDIZIONI + "<br>" + ServiziType.FINANZIARI);
        
        
            
            jPanelSportello1.setName("Nessuno");
            jPanelSportello2.setName("Nessuno");
            jPanelSportello3.setName("Nessuno");
            jPanelSportello4.setName("Nessuno");
        
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
        jPanelSportello1 = new it.tutor.up.gui.SportelloPanel();
        jPanelSportello2 = new it.tutor.up.gui.SportelloPanel();
        jPanelSportello3 = new it.tutor.up.gui.SportelloPanel();
        jPanelSportello4 = new it.tutor.up.gui.SportelloPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanelSportello1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSportello2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSportello3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSportello4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSportello4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelSportello3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelSportello2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelSportello1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SimulationGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimulationGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimulationGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimulationGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimulationGui().setVisible(true);
                
            }
        });
    }
    
    public void clear() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("SimulationGui "+ Settings.VERSION);
        jPanelSportello1.setNumber("1");
        jPanelSportello2.setNumber("2");
        jPanelSportello3.setNumber("3");
        jPanelSportello4.setNumber("4");
        
        jPanelSportello1.setService("<html>" + String.valueOf(ServiziType.PAGAMENTI) + "<br>" + ServiziType.SPEDIZIONI);
        jPanelSportello2.setService("<html>" + String.valueOf(ServiziType.PAGAMENTI) + "<br>" + ServiziType.SPEDIZIONI);
        jPanelSportello3.setService("<html>" + String.valueOf(ServiziType.PAGAMENTI) + "<br>" + ServiziType.SPEDIZIONI);
        jPanelSportello4.setService("<html>" + String.valueOf(ServiziType.PAGAMENTI) + "<br>" + ServiziType.SPEDIZIONI + "<br>" + ServiziType.FINANZIARI);
        
        
            
            jPanelSportello1.setName("Nessuno");
            jPanelSportello2.setName("Nessuno");
            jPanelSportello3.setName("Nessuno");
            jPanelSportello4.setName("Nessuno");
           
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private it.tutor.up.gui.SportelloPanel jPanelSportello1;
    private it.tutor.up.gui.SportelloPanel jPanelSportello2;
    private it.tutor.up.gui.SportelloPanel jPanelSportello3;
    private it.tutor.up.gui.SportelloPanel jPanelSportello4;
    // End of variables declaration//GEN-END:variables
}
