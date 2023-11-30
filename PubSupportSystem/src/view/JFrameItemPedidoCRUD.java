package view;

import java.awt.event.WindowEvent;
import model.ItemPedido;

public class JFrameItemPedidoCRUD extends javax.swing.JFrame {

    private ItemPedido itemPedido;
    private boolean disconnectOnClose;
    
    /**
     * Creates new form JFrameItemPedido
     */
    public JFrameItemPedidoCRUD(ItemPedido itemPedido, boolean disconnectOnClose ) {
        initComponents();
        
        if( itemPedido == null){
            this.itemPedido = new ItemPedido();
        }else{
            this.itemPedido = itemPedido;
            dataUp();
            jTextFieldPedidoID.setEnabled(false);
        }
        
        this.disconnectOnClose = disconnectOnClose;
    }

    private void checkInput() throws Exception {
        
        if( jTextFieldPedidoID.getText().isEmpty() ) {
            throw new Exception("Informe ID.");
        } else {
            if( !jTextFieldPedidoID.getText().matches("\\d+") ) {
                    throw new Exception("O campo ID deve ser um número.");
            }
        }
        
//        if( jTextFieldNotaFiscalID.getText().isEmpty() ) {
//            throw new Exception("A N.F precisa ser informada.");
//        } else {
//            if( !jTextFieldNotaFiscalID.getText().matches("d{1,9}") ) {
//                throw new Exception("O valor da NF deve estar no formato 'XXXXXXXXX'");
//            }            
//        }

        if( jTextFieldQuantidade.getText().isEmpty() ) {
            throw new Exception("A quantidade de pedidos precisa ser informada.");
        } else {
            if( !jTextFieldQuantidade.getText().matches("\\d+") ) {
                throw new Exception("Favor informar a quantidade correta.");
            }            
        }
        
    }    

    private void dataDown() {

        itemPedido.setIdProduto( Integer.parseInt( jTextFieldPedidoID.getText() ) );
        itemPedido.setIdNotaFiscal(Integer.parseInt(jTextFieldNotaFiscalID.getText()) );
        itemPedido.setQuantidade( Integer.parseInt( jTextFieldQuantidade.getText() ) );
    }    

    private void dataUp() {

        jTextFieldPedidoID.setText( String.valueOf( itemPedido.getIdProduto() ) );
        jTextFieldNotaFiscalID.setText( String.valueOf( itemPedido.getIdNotaFiscal() ) );
        jTextFieldQuantidade.setText( String.valueOf( itemPedido.getQuantidade() ) );
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelPedidoID = new javax.swing.JLabel();
        jLabelNotaFiscalID = new javax.swing.JLabel();
        jLabelQuantidade = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jTextFieldPedidoID = new javax.swing.JTextField();
        jTextFieldNotaFiscalID = new javax.swing.JTextField();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jButtonExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Item Pedido");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelPedidoID.setText("ID pedido:");

        jLabelNotaFiscalID.setText("ID Nota Fiscal:");

        jLabelQuantidade.setText("Quantidade:");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jTextFieldPedidoID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPedidoIDActionPerformed(evt);
            }
        });

        jTextFieldNotaFiscalID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNotaFiscalIDActionPerformed(evt);
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
                            .addComponent(jTextFieldQuantidade))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelNotaFiscalID)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldNotaFiscalID))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelPedidoID)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldPedidoID, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPedidoID)
                    .addComponent(jTextFieldPedidoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNotaFiscalID)
                    .addComponent(jTextFieldNotaFiscalID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQuantidade)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonExcluir))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPedidoIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPedidoIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPedidoIDActionPerformed

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

    private void jTextFieldNotaFiscalIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNotaFiscalIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNotaFiscalIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabelNotaFiscalID;
    private javax.swing.JLabel jLabelPedidoID;
    private javax.swing.JLabel jLabelQuantidade;
    private javax.swing.JTextField jTextFieldNotaFiscalID;
    private javax.swing.JTextField jTextFieldPedidoID;
    private javax.swing.JTextField jTextFieldQuantidade;
    // End of variables declaration//GEN-END:variables
}
