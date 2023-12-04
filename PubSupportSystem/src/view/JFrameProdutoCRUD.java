package view;

import java.awt.event.WindowEvent;
import model.TipoProduto;
import model.Produto;
import controller.LogTrack;

public class JFrameProdutoCRUD extends javax.swing.JFrame {

    private Produto produto;
    private TipoProduto tipoProduto;
    private boolean disconnectOnClose;
    
    public JFrameProdutoCRUD(Produto produto, boolean disconnectOnClose) {
        initComponents();
        
        if(produto == null){
            this.produto = new Produto();
            
        }else{
            this.produto = produto;
            if(this.produto.getTipoProduto() != null){
                this.tipoProduto = new TipoProduto();
                this.tipoProduto.setIdTipoProduto(this.produto.getTipoProduto().getIdTipoProduto());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTitulo = new javax.swing.JPanel();
        jPanelCadastroProduto = new javax.swing.JPanel();
        jLabelProdutoID = new javax.swing.JLabel();
        jLabelNomeProduto = new javax.swing.JLabel();
        jLabelPrecoProduto = new javax.swing.JLabel();
        jLabelDescontoProduto = new javax.swing.JLabel();
        jTextFieldProdutoID = new javax.swing.JTextField();
        jTextFieldNomeProduto = new javax.swing.JTextField();
        jTextFieldPrecoProduto = new javax.swing.JTextField();
        jTextFieldDescontoProduto = new javax.swing.JTextField();
        jLabelTipoProdutoID = new javax.swing.JLabel();
        jTextFieldTipoProdutoID = new javax.swing.JTextField();
        jButtonSelecionarTipoProduto = new javax.swing.JButton();
        jButtonExcluirTipoProduto = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produto");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanelTitulo.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanelCadastroProduto.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro novo produto"));

        jLabelProdutoID.setText("ID do Produto:");

        jLabelNomeProduto.setText("Nome produto:");

        jLabelPrecoProduto.setText("Preço produto:");

        jLabelDescontoProduto.setText("Desconto:");

        javax.swing.GroupLayout jPanelCadastroProdutoLayout = new javax.swing.GroupLayout(jPanelCadastroProduto);
        jPanelCadastroProduto.setLayout(jPanelCadastroProdutoLayout);
        jPanelCadastroProdutoLayout.setHorizontalGroup(
            jPanelCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroProdutoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNomeProduto)
                    .addComponent(jLabelProdutoID)
                    .addComponent(jLabelPrecoProduto)
                    .addComponent(jLabelDescontoProduto))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldProdutoID, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(jTextFieldNomeProduto)
                    .addComponent(jTextFieldPrecoProduto)
                    .addComponent(jTextFieldDescontoProduto))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanelCadastroProdutoLayout.setVerticalGroup(
            jPanelCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroProdutoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProdutoID)
                    .addComponent(jTextFieldProdutoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeProduto)
                    .addComponent(jTextFieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecoProduto)
                    .addComponent(jTextFieldPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescontoProduto)
                    .addComponent(jTextFieldDescontoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabelTipoProdutoID.setText("ID Tipo Produto:");

        jButtonSelecionarTipoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N
        jButtonSelecionarTipoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarTipoProdutoActionPerformed(evt);
            }
        });

        jButtonExcluirTipoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eraser-icon.png"))); // NOI18N
        jButtonExcluirTipoProduto.setPreferredSize(new java.awt.Dimension(22, 22));
        jButtonExcluirTipoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirTipoProdutoActionPerformed(evt);
            }
        });

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
            .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelTipoProdutoID)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldTipoProdutoID, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButtonSelecionarTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExcluirTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExcluir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipoProdutoID)
                    .addComponent(jTextFieldTipoProdutoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSelecionarTipoProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSalvar)
                            .addComponent(jButtonExcluir))
                        .addGap(2, 2, 2))
                    .addComponent(jButtonExcluirTipoProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if( this.disconnectOnClose ) {
            System.out.println("Desconectar.");
            try {
                produto.disconnectFromDatabase();
            } catch ( Exception ex ) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void checkInput() throws Exception {
        if( jTextFieldProdutoID.getText().isEmpty() ) {
            throw new Exception("Informe ID.");
        } else {
            if( !jTextFieldProdutoID.getText().matches("\\d+") ) {
                throw new Exception("O campo ID deve ser um número.");
            }
        }

        if( jTextFieldNomeProduto.getText().isEmpty() ) {
            throw new Exception("Informe Nome.");
        }

        if( jTextFieldPrecoProduto.getText().isEmpty() ) {
            throw new Exception("O valor do produto precisa ser informado.");
        } else {
            if( !jTextFieldPrecoProduto.getText().matches("\\d+\\.\\d{1,2}") ) {
                throw new Exception("O valor do produto deve estar no formato 'XXXXXXXX.X' ou 'XXXXXXXX.XX'.");
            }            
        }        
        
        if( jTextFieldDescontoProduto.getText().isEmpty() ) {
            throw new Exception("O valor do desconto do produto precisa ser informado.");
        } else {
            if( !jTextFieldDescontoProduto.getText().matches("\\d+") ) {
                throw new Exception("O valor do desconto do produto deve estar no formato 'XXXXXXXX.X' ou 'XXXXXXXX.XX'.");
            }            
        }
        
        if( tipoProduto == null ) {
            throw new Exception("Informe Tipo de produto.");
        }        
    }

    private void dataDown() {
        produto.setIdproduto(Integer.parseInt(jTextFieldProdutoID.getText()));
        produto.setNomeProduto(jTextFieldNomeProduto.getText());
        produto.setPreco(Double.parseDouble(jTextFieldPrecoProduto.getText()));
        produto.setDesconto(Double.parseDouble(jTextFieldDescontoProduto.getText()));
    
    }
    
    private void dataUp() {
        jTextFieldProdutoID.setText(String.valueOf(produto.getIdProduto()));
        jTextFieldNomeProduto.setText( produto.getNomeProduto() );
        jTextFieldPrecoProduto.setText( String.valueOf( produto.getPreco() ) );
        jTextFieldDescontoProduto.setText( String.valueOf( produto.getDesconto() ) );        
    }    
    
    
    private void jButtonSelecionarTipoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarTipoProdutoActionPerformed
        try {

            if( tipoProduto == null ) {
                tipoProduto = new TipoProduto();
            }
            
            JFrameConsultaTipoProduto jFrameConsulta;
            jFrameConsulta = new JFrameConsultaTipoProduto( true, false, tipoProduto );

            jFrameConsulta.addWindowListener( new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if( tipoProduto.getNomeTipo() != null ) {
                        jTextFieldTipoProdutoID.setText( tipoProduto.getNomeTipo() );
                    }
                }
            } );

            jFrameConsulta.setVisible(true);
        } catch( Exception ex ) {
            ex.printStackTrace();
            tipoProduto = null;
        }
    }//GEN-LAST:event_jButtonSelecionarTipoProdutoActionPerformed

    private void jButtonExcluirTipoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirTipoProdutoActionPerformed
        tipoProduto = null;
        jTextFieldTipoProdutoID.setText( null );
    }//GEN-LAST:event_jButtonExcluirTipoProdutoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        System.out.println("Salvar");

        try {
            checkInput();
            dataDown();
            produto.save();
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
            this.produto.delete();
            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonExcluirTipoProduto;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSelecionarTipoProduto;
    private javax.swing.JLabel jLabelDescontoProduto;
    private javax.swing.JLabel jLabelNomeProduto;
    private javax.swing.JLabel jLabelPrecoProduto;
    private javax.swing.JLabel jLabelProdutoID;
    private javax.swing.JLabel jLabelTipoProdutoID;
    private javax.swing.JPanel jPanelCadastroProduto;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JTextField jTextFieldDescontoProduto;
    private javax.swing.JTextField jTextFieldNomeProduto;
    private javax.swing.JTextField jTextFieldPrecoProduto;
    private javax.swing.JTextField jTextFieldProdutoID;
    private javax.swing.JTextField jTextFieldTipoProdutoID;
    // End of variables declaration//GEN-END:variables


}
