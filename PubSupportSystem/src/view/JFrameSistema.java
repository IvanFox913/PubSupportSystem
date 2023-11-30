
package view;

import controller.LogTrack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;
import model.Usuario;

public class JFrameSistema extends javax.swing.JFrame {

    /**
     * Creates new form JFrameSistema
     */
    public JFrameSistema() {
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

        jLabelDelicia = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBarActions = new javax.swing.JMenuBar();
        jMenuAdministrativo = new javax.swing.JMenu();
        jMenuItemCadastroItemPedido = new javax.swing.JMenuItem();
        jMenuItemConsultaItemPedido = new javax.swing.JMenuItem();
        jMenuItemCadastroAtracao = new javax.swing.JMenuItem();
        jMenuItemConsultaAtracao = new javax.swing.JMenuItem();
        jMenuAtendimento = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema - La Delicia");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDelicia.setFont(new java.awt.Font("Zilla Slab", 3, 48)); // NOI18N
        jLabelDelicia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/titulo.png"))); // NOI18N
        jLabelDelicia.setText("La Delicia");
        jLabelDelicia.setFocusable(false);
        jLabelDelicia.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabelDelicia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 500, 90));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jButton1.setText("Pratos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 680));

        jMenuAdministrativo.setText("Administrativo");

        jMenuItemCadastroItemPedido.setText("Cadastro Item Pedido");
        jMenuItemCadastroItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroItemPedidoActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemCadastroItemPedido);

        jMenuItemConsultaItemPedido.setText("Consulta Item Pedido");
        jMenuItemConsultaItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaItemPedidoActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemConsultaItemPedido);

        jMenuItemCadastroAtracao.setText("Cadastro Atração");
        jMenuItemCadastroAtracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroAtracaoActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemCadastroAtracao);

        jMenuItemConsultaAtracao.setText("Consulta Atração");
        jMenuItemConsultaAtracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaAtracaoActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemConsultaAtracao);

        jMenuBarActions.add(jMenuAdministrativo);

        jMenuAtendimento.setText("Atendimento");
        jMenuBarActions.add(jMenuAtendimento);

        setJMenuBar(jMenuBarActions);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItemCadastroItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroItemPedidoActionPerformed
        try {
            JFrameItemPedidoCRUD jFrameCRUD;
            jFrameCRUD = new JFrameItemPedidoCRUD( null, true );
            jFrameCRUD.setVisible(true);
        } catch( Exception ex ){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItemCadastroItemPedidoActionPerformed

    private void jMenuItemConsultaItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaItemPedidoActionPerformed
        try {
            JFrameConsultaItemPedido jFrameConsulta;
            jFrameConsulta = new JFrameConsultaItemPedido( false, true, null );
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItemConsultaItemPedidoActionPerformed

    private void jMenuItemCadastroAtracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroAtracaoActionPerformed
        try {
            JFrameAtracaoCRUD jFrameCRUD;
            jFrameCRUD = new JFrameAtracaoCRUD( null, true );
            jFrameCRUD.setVisible(true);
        } catch( Exception ex ){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItemCadastroAtracaoActionPerformed

    private void jMenuItemConsultaAtracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaAtracaoActionPerformed
        try {
            JFrameConsultaAtracao jFrameConsulta;
            jFrameConsulta = new JFrameConsultaAtracao( false, true, null );
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItemConsultaAtracaoActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JFrameSistema().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabelDelicia;
    private javax.swing.JMenu jMenuAdministrativo;
    private javax.swing.JMenu jMenuAtendimento;
    private javax.swing.JMenuBar jMenuBarActions;
    private javax.swing.JMenuItem jMenuItemCadastroAtracao;
    private javax.swing.JMenuItem jMenuItemCadastroItemPedido;
    private javax.swing.JMenuItem jMenuItemConsultaAtracao;
    private javax.swing.JMenuItem jMenuItemConsultaItemPedido;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
