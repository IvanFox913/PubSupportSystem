package view;

import controller.LogTrack;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import model.ItemPedido;
import model.NotaFiscal;
import model.Produto;

public class JFrameItemPedidoCRUD extends javax.swing.JFrame {

    private ItemPedido itemPedido;
    private Produto produto;
    private NotaFiscal notaFiscal;
    
    private boolean select;
    private boolean disconnectOnClose;
    
    /**
     * Creates new form JFrameItemPedido
     */
    public JFrameItemPedidoCRUD(boolean select, boolean disconnectOnClose, ItemPedido itemPedido ) throws Exception{
        initComponents();
        
        if( itemPedido == null){
            this.itemPedido = new ItemPedido();
        }else{
            
            this.itemPedido = itemPedido;
            
            if( this.itemPedido.getProduto() != null){
                
                this.produto = new Produto();
                this.produto.setIdProduto(this.itemPedido.getProduto().getIdProduto());
                this.produto.load();
            }
            
            if( this.itemPedido.getNotaFiscal() != null){
                
                this.notaFiscal = new NotaFiscal();
                this.notaFiscal.setIdNotaFiscal(this.itemPedido.getNotaFiscal().getIdNotaFiscal());
                this.notaFiscal.load();
            }
            
            dataUp();
            jTextFieldProduto.setEnabled(false);
        }
        
        this.disconnectOnClose = disconnectOnClose;
    }

    private void checkInput() throws Exception {
        
        if( jTextFieldProduto.getText().isEmpty() ) {
            throw new Exception("Informe ID.");
        } else {
            if( !jTextFieldProduto.getText().matches("\\d+") ) {
                    throw new Exception("O campo ID deve ser um número.");
            }
        }
        
        if( jTextFieldNotaFiscal.getText().isEmpty() ) {
            throw new Exception("A N.F precisa ser informada.");
        } else {
            if( !jTextFieldNotaFiscal.getText().matches("d{1,9}") ) {
                throw new Exception("O valor da NF deve estar no formato 'XXXXXXXXX'");
            }            
        }

        if( jTextFieldQuantidade.getText().isEmpty() ) {
            throw new Exception("A quantidade de pedidos precisa ser informada.");
        } else {
            if( !jTextFieldQuantidade.getText().matches("\\d+") ) {
                throw new Exception("Favor informar a quantidade correta.");
            }            
        }
        
    }    

    private void dataDown() throws Exception{

        itemPedido.setProduto(produto);
        itemPedido.setNotaFiscal(notaFiscal);
        itemPedido.setQuantidade( Integer.parseInt( jTextFieldQuantidade.getText() ) );
    }    

    private void dataUp() {

        if( itemPedido.getProduto().getNomeProduto() != null ) {
            jTextFieldProduto.setText( itemPedido.getProduto().getNomeProduto() );
        }
        
        if( itemPedido.getNotaFiscal() != null ) {
            jTextFieldNotaFiscal.setText( String.valueOf(itemPedido.getNotaFiscal().getIdNotaFiscal()));
        }
        
        jTextFieldQuantidade.setText( String.valueOf( itemPedido.getQuantidade() ) );
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelPedidoID = new javax.swing.JLabel();
        jLabelNotaFiscalID = new javax.swing.JLabel();
        jLabelQuantidade = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jTextFieldProduto = new javax.swing.JTextField();
        jTextFieldNotaFiscal = new javax.swing.JTextField();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jButtonExcluir = new javax.swing.JButton();
        jButtonApagarProduto = new javax.swing.JButton();
        jButtonSelecionarProduto = new javax.swing.JButton();
        jButtonApagarNotaFiscal = new javax.swing.JButton();
        jButtonSelecionarNotaFiscal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Item Pedido");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelPedidoID.setText("Produto:");

        jLabelNotaFiscalID.setText("Nota Fiscal:");

        jLabelQuantidade.setText("Quantidade:");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jTextFieldProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProdutoActionPerformed(evt);
            }
        });

        jTextFieldNotaFiscal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNotaFiscalActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonApagarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eraser-icon.png"))); // NOI18N
        jButtonApagarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarProdutoActionPerformed(evt);
            }
        });

        jButtonSelecionarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N
        jButtonSelecionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarProdutoActionPerformed(evt);
            }
        });

        jButtonApagarNotaFiscal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eraser-icon.png"))); // NOI18N
        jButtonApagarNotaFiscal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarNotaFiscalActionPerformed(evt);
            }
        });

        jButtonSelecionarNotaFiscal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N
        jButtonSelecionarNotaFiscal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarNotaFiscalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSalvar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelQuantidade)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelNotaFiscalID)
                                .addComponent(jLabelPedidoID))
                            .addGap(22, 22, 22)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldNotaFiscal)
                                .addComponent(jTextFieldProduto)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSelecionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonApagarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSelecionarNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonApagarNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelPedidoID)
                        .addComponent(jTextFieldProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonSelecionarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonApagarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNotaFiscalID)
                        .addComponent(jTextFieldNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonSelecionarNotaFiscal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonApagarNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQuantidade)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonExcluir))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProdutoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if( this.disconnectOnClose ) {
            System.out.println("Desconectar.");
            try {
                itemPedido.disconnectFromDatabase();
            } catch ( Exception ex ) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        System.out.println("Salvar");
                
        try {
            checkInput();
            dataDown();
            itemPedido.save();
            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        System.out.println("Excluir");
          
        try {
            
            checkInput();
            dataDown();
            this.itemPedido.delete();
            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTextFieldNotaFiscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNotaFiscalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNotaFiscalActionPerformed

    private void jButtonApagarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarProdutoActionPerformed
        produto = null;
        jTextFieldProduto.setText(null);
    }//GEN-LAST:event_jButtonApagarProdutoActionPerformed

    private void jButtonSelecionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarProdutoActionPerformed
        // TODO add your handling code here:

        try {

            if( produto == null ) {
                produto = new Produto();
            }

            JFrameConsultaProduto jFrameConsulta;
            jFrameConsulta = new JFrameConsultaProduto( true, false, produto, null );

            jFrameConsulta.addWindowListener( new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if( produto != null ) {
                        jTextFieldProduto.setText(String.valueOf(produto.getIdProduto()));//( produto.getIdProduto() ); (String.valueOf(notaFiscal.getIdNotaFiscal()));
                    }
                }
            } );

            jFrameConsulta.setVisible(true);
        } catch( Exception ex ) {
            LogTrack.getInstance().addException(ex, true, this);
            produto = null;
        }
    }//GEN-LAST:event_jButtonSelecionarProdutoActionPerformed

    private void jButtonApagarNotaFiscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarNotaFiscalActionPerformed
        notaFiscal = null;
        jTextFieldNotaFiscal.setText(null);
    }//GEN-LAST:event_jButtonApagarNotaFiscalActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameItemPedidoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameItemPedidoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameItemPedidoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameItemPedidoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
                
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFrameItemPedidoCRUD( false, true, null ).setVisible(true);
                } catch ( Exception ex ) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    private void jButtonSelecionarNotaFiscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarNotaFiscalActionPerformed
        try {

            if( notaFiscal == null ) {
                notaFiscal = new NotaFiscal();
            }

            JFrameConsultaNotaFiscal jFrameConsulta;
            jFrameConsulta = new JFrameConsultaNotaFiscal( true, false, notaFiscal );

            jFrameConsulta.addWindowListener( new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if( notaFiscal != null ) {
                        jTextFieldNotaFiscal.setText(String.valueOf(notaFiscal.getIdNotaFiscal()));
                    }
                }
            } );

            jFrameConsulta.setVisible(true);
        } catch( Exception ex ) {
            LogTrack.getInstance().addException(ex, true, this);
            notaFiscal = null;
        }
    }//GEN-LAST:event_jButtonSelecionarNotaFiscalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApagarNotaFiscal;
    private javax.swing.JButton jButtonApagarProduto;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSelecionarNotaFiscal;
    private javax.swing.JButton jButtonSelecionarProduto;
    private javax.swing.JLabel jLabelNotaFiscalID;
    private javax.swing.JLabel jLabelPedidoID;
    private javax.swing.JLabel jLabelQuantidade;
    private javax.swing.JTextField jTextFieldNotaFiscal;
    private javax.swing.JTextField jTextFieldProduto;
    private javax.swing.JTextField jTextFieldQuantidade;
    // End of variables declaration//GEN-END:variables
}
