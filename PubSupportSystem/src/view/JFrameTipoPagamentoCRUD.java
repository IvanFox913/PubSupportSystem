package view;

import java.awt.event.WindowEvent;
import model.TipoPagamento;

public class JFrameTipoPagamentoCRUD extends javax.swing.JFrame {

    private TipoPagamento tipoPagamento;
    private boolean disconnectOnClose;
    
    public JFrameTipoPagamentoCRUD(TipoPagamento tipoPagamento, boolean disconnectOnClose) {
        initComponents();
        
        if( tipoPagamento == null ) {
            this.tipoPagamento  = new TipoPagamento();
        } else {
            this.tipoPagamento = tipoPagamento;
            dataUp();
            jTextFieldId.setEnabled(false);
        }

        this.disconnectOnClose = disconnectOnClose;
    }
    
    private void checkInput(){

        if( jTextFieldId.getText().isEmpty() ) {
            new Exception("Informe ID.");
        } else {
            if( !jTextFieldId.getText().matches("\\d+") ) {
                new Exception("O campo ID deve ser um número.");
            }
        }
    }
    
    private void dataDown(){
        
        tipoPagamento.setIdTipoPagamento(Integer.parseInt(jTextFieldId.getText()));
        tipoPagamento.setNomeTipoPagamento(jTextFieldNome.getText());
    }
    
    private void dataUp(){

        jTextFieldId.setText(Integer.toString(tipoPagamento.getIdTipoPagamento()));
        jTextFieldNome.setText(tipoPagamento.getNomeTipoPagamento());
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Tipo de Pagamento");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabelNome.setText("Nome:");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNome)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonExcluir))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        System.out.println("Salvar");

        try {
            checkInput();
            dataDown();
            tipoPagamento.save();
            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        System.out.println("Excluir");
        
        try {
            checkInput();
            dataDown();
            tipoPagamento.delete();
            this.dispatchEvent( 
                    new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            if( disconnectOnClose ) {
                System.out.println("Desconectar.");
                tipoPagamento.disconnectFromDatabase();
            }
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(JFrameTipoPagamentoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameTipoPagamentoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameTipoPagamentoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameTipoPagamentoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFrameTipoPagamentoCRUD( null, true ).setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}