package view;

import controller.ResultSetTableModel;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.TipoUsuario;

public class JFrameConsultaTipoUsuario extends javax.swing.JFrame {

    private TipoUsuario tipoUsuario;
    private boolean select;
    private boolean disconnectOnClose;
    
    private String query = "SELECT id_tipo_usuario AS ID, nome AS Nome FROM tipo_usuario ORDER BY Nome";
    
    private ResultSetTableModel result;
    private final TableRowSorter<TableModel> filter;
    
    public JFrameConsultaTipoUsuario(boolean select, boolean disconnectOnClose, TipoUsuario tipoUsuario) throws SQLException{
        initComponents();
        
        this.tipoUsuario = tipoUsuario;
        this.select = select;
        jButtonSelecionar.setEnabled( this.select );
        
        this.disconnectOnClose = disconnectOnClose;
        
        result = new ResultSetTableModel( query );
        jTableConsulta.setModel( result );
        
        filter = new TableRowSorter< TableModel >( result );
        jTableConsulta.setRowSorter( filter );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jLabelFiltro = new javax.swing.JLabel();
        jTextFieldFiltro = new javax.swing.JTextField();
        jButtonFiltrar = new javax.swing.JButton();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonSelecionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Tipo de Usuário");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableConsulta);

        jLabelFiltro.setText("Filtro:");

        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonSelecionar.setText("Selecionar");
        jButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabelFiltro)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSelecionar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(25, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelFiltro)
                        .addComponent(jTextFieldFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonFiltrar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAdicionar)
                        .addComponent(jButtonAlterar)
                        .addComponent(jButtonSelecionar)))
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        System.out.println("Filtrar");
        
        String filtro = jTextFieldFiltro.getText();
        if ( filtro.isEmpty() ) {
            filter.setRowFilter( null );
        } else {
            filter.setRowFilter( RowFilter.regexFilter( filtro ) );
        }
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        System.out.println("Adicionar");
        
        JFrameTipoUsuarioCRUD jFrameCRUD;
        jFrameCRUD = new JFrameTipoUsuarioCRUD( null, false );
        
        jFrameCRUD.addWindowListener( new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                     System.out.println("Atualizar");
                     try {
                         result.setQuery( query );
                     } catch ( Exception ex ) {
                         ex.printStackTrace();
                     }
                }
            } );
        
        jFrameCRUD.setVisible( true );
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        int row = jTableConsulta.getSelectedRow();
        if( row != -1 ) {
            
            System.out.println("Alterar");
            
            int codigo = (int) result.getValueAt( row, 0 );
            
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setIdTipoUsuario(codigo);
            
            try {
                
                tipoUsuario.load();
                
                JFrameTipoUsuarioCRUD jFrameCRUD;
                jFrameCRUD = new JFrameTipoUsuarioCRUD( tipoUsuario, false );

                jFrameCRUD.addWindowListener( new java.awt.event.WindowAdapter(){
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent evt) {
                        System.out.println("Atualizar");
                        try {
                            result.setQuery( query );
                        } catch ( Exception ex ) {
                            ex.printStackTrace();
                        }
                    }
                });
                jFrameCRUD.setVisible( true );    
            } catch( Exception ex ) {
                ex.printStackTrace();
            }            
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if( this.disconnectOnClose ) {
            System.out.println("Desconectar.");
            result.disconnectFromDatabase();
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarActionPerformed
        int row = jTableConsulta.getSelectedRow();
        if( row != -1 ) {
            
            System.out.println("Selecionar");
            
            int codigo = (int) result.getValueAt( row, 0 );
            
            this.tipoUsuario.setIdTipoUsuario(codigo);
            
            try {
                this.tipoUsuario.load();
                this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
            } catch( Exception ex ) {
                ex.printStackTrace();
            }
            
        }
    }//GEN-LAST:event_jButtonSelecionarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameConsultaTipoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameConsultaTipoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameConsultaTipoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameConsultaTipoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFrameConsultaTipoUsuario( false, true, null ).setVisible(true);
                } catch ( Exception ex ) {
                    ex.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonSelecionar;
    private javax.swing.JLabel jLabelFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTextField jTextFieldFiltro;
    // End of variables declaration//GEN-END:variables
}
