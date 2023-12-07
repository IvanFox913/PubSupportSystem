package view;

import controller.LogTrack;
import controller.ResultSetTableModel;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Atracao;
import model.NotaFiscal;
import model.TipoPagamento;
import model.Usuario;

public class JFrameNotaFiscalCRUD extends javax.swing.JFrame {

    private NotaFiscal notaFiscal;
    private Usuario usuario;
    private Atracao atracao;
    private TipoPagamento tipoPagamento;
    
    private ResultSetTableModel itemPedido, resultValorConsumo;
    
    private boolean disconnectOnClose;
    
    public JFrameNotaFiscalCRUD(NotaFiscal notaFiscal, boolean disconnectOnClose) throws Exception {
        initComponents();
        
        if(notaFiscal == null) {
            this.notaFiscal = new NotaFiscal();
        } else {
            
            this.notaFiscal = notaFiscal;
            
            if(this.notaFiscal.getTipoPagamento() != null) {
                
                this.tipoPagamento = new TipoPagamento();
                this.tipoPagamento.setIdTipoPagamento(this.notaFiscal.getTipoPagamento().getIdTipoPagamento());
                this.tipoPagamento.load();
            }
            
            if(this.notaFiscal.getAtracao() != null) {
                
                this.atracao = new Atracao();
                this.atracao.setIdAtracao(this.notaFiscal.getAtracao().getIdAtracao());
                this.atracao.load();
            }
            
            if(this.notaFiscal.getUsuario() != null) {
                
                this.usuario = new Usuario();
                this.usuario.setIdUsuario(this.notaFiscal.getUsuario().getIdUsuario());
                this.usuario.load();
            }
            
            dataUp();
            jTextFieldId.setEnabled(false);
            //jTextFieldAtracao.setEnabled(false);
            //jTextFieldUsuario.setEnabled(false);
            //jTextFieldDataEmissao.setEnabled(false);
        }
        
        this.disconnectOnClose = disconnectOnClose;
    }
    
    private void setUpAlteracao() {
        jTextFieldDataEmissao.setEnabled(false);
        jCheckBoxFinalizada.setEnabled(true);
        unlockItemPedido();
    }
    
    private void dataUp() throws SQLException {
        
        jTextFieldId.setText(String.valueOf(notaFiscal.getIdNotaFiscal()));
        jTextFieldTipoPagamento.setText(notaFiscal.getTipoPagamento().getNomeTipoPagamento());
        jTextFieldAtracao.setText(notaFiscal.getAtracao().getDescricao());
        jTextFieldUsuario.setText(notaFiscal.getUsuario().getNome());
        
        jTextFieldDataEmissao.setText(notaFiscal.getDataEmissao());
        jTextFieldValorConsumo.setText(somaValorConsumo());
        jTextFieldValorAtracao.setText(String.valueOf(notaFiscal.getAtracao().getPreco()));
        jTextFieldValorTotal.setText(String.valueOf(Double.valueOf(somaValorConsumo()) + Double.valueOf(notaFiscal.getAtracao().getPreco())));
        
        if(notaFiscal.getFinalizada().equals("S")){
            jCheckBoxFinalizada.setSelected(true);
        } else {
            jCheckBoxFinalizada.setSelected(false);
        }
        
        buscarItemPedido();
        
    }
    
    private void dataDown() throws Exception {
        
        notaFiscal.setIdNotaFiscal(Integer.parseInt(jTextFieldId.getText()));
        notaFiscal.setDataEmissao(jTextFieldDataEmissao.getText());
        notaFiscal.setAtracao(atracao);
        notaFiscal.setTipoPagamento(tipoPagamento);
        notaFiscal.setUsuario(usuario);
        
        if ( jCheckBoxFinalizada.isSelected()){
            notaFiscal.setFinalizada("S");
        } else {
            notaFiscal.setFinalizada("N");
        }
    }
    
    private void checkInput() throws Exception{
        
        if( jTextFieldId.getText().isEmpty() ) {
            throw new Exception("Informe ID.");
        } else {
            if( !jTextFieldId.getText().matches("\\d+") ) {
                throw new Exception("O campo ID deve ser um número.");
            }
        }
        
        if( jTextFieldDataEmissao.getText().isEmpty() ) {
            throw new Exception("Informe Data.");
        } else {
            if( !jTextFieldDataEmissao.getText().matches("\\d{4}-\\d{2}-\\d{2}") ) {
                 throw new Exception("A Data deve estar no formato AAAA-MM-DD.");
            }
        }
        
        if(usuario == null){
            throw new Exception("Informe Usuario.");
        }
        
        if(tipoPagamento == null){
            throw new Exception("Informe Tipo Pagando.");
        }
        
        if(atracao == null){
            throw new Exception("Informe Atracao.");
        }
        
    }
    
    private void unlockItemPedido(){
        jTableItemPedido.setEnabled(true);
        jButtonExcluirItemPedido.setEnabled(true);
        jButtonAdicionarItemPedido.setEnabled(true);
    }
    
    private String somaValorConsumo() throws SQLException {
        String query = "SELECT sum((preco - ( preco * (desconto / 100) ) ) * quantidade) FROM nota_fiscal nf LEFT JOIN item_pedido ip ON ip.id_nota_fiscal = nf.id_nota_fiscal LELT JOIN produto p ON p.id_produto = ip.id_produto WHERE nf.id_nota_fiscal = " + this.notaFiscal.getIdNotaFiscal() + ";";
        
        if(resultValorConsumo == null) {
            resultValorConsumo = new ResultSetTableModel(query);
            String resultado = resultValorConsumo.getValueAt(0, 0).toString();
            return resultado;
        } else {
            return "0.0";
        }
    }
    
    private void buscarItemPedido() throws SQLException {
        
        String query = "SELECT i.id_produto AS 'ID produto', p.nome_produto AS Nome, i.quantidade AS 'Qtd.', preco AS 'Preco un.' FROM item_pedido i INNER JOIN produto p ON (i.id_produto = p.id_produto) WHERE i.id_nota_fiscal = " + this.notaFiscal.getIdNotaFiscal() + ";";
        
        if (itemPedido == null) {
            itemPedido = new ResultSetTableModel(query);
            jTableItemPedido.setModel(itemPedido);
        } else {
            itemPedido.setQuery(query);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelId = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabelAtracao = new javax.swing.JLabel();
        jTextFieldAtracao = new javax.swing.JTextField();
        jLabelTipoPagamento = new javax.swing.JLabel();
        jTextFieldTipoPagamento = new javax.swing.JTextField();
        jButtonSelecionarAtracao = new javax.swing.JButton();
        jButtonExcluirAtracao = new javax.swing.JButton();
        jButtonSelecionarUsuario = new javax.swing.JButton();
        jButtonExcluirUsuario = new javax.swing.JButton();
        jButtonSelecionarTipoPagamento = new javax.swing.JButton();
        jButtonExcluirTipoPagamento = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelDataEmissao = new javax.swing.JLabel();
        jTextFieldDataEmissao = new javax.swing.JTextField();
        jLabelValorAtracao = new javax.swing.JLabel();
        jTextFieldValorAtracao = new javax.swing.JTextField();
        jButtonExcluir = new javax.swing.JButton();
        jLabelValorTotal = new javax.swing.JLabel();
        jTextFieldValorTotal = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jCheckBoxFinalizada = new javax.swing.JCheckBox();
        jLabelValorConsumo = new javax.swing.JLabel();
        jTextFieldValorConsumo = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableItemPedido = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelItemPedido = new javax.swing.JLabel();
        jButtonExcluirItemPedido = new javax.swing.JButton();
        jButtonAdicionarItemPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Nota Fiscal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelId.setText("ID:");

        jLabelUsuario.setText("Usuário:");

        jTextFieldUsuario.setEditable(false);

        jLabelAtracao.setText("Atração:");

        jTextFieldAtracao.setEditable(false);

        jLabelTipoPagamento.setText("Método de Pagamento:");

        jTextFieldTipoPagamento.setEditable(false);

        jButtonSelecionarAtracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N
        jButtonSelecionarAtracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarAtracaoActionPerformed(evt);
            }
        });

        jButtonExcluirAtracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eraser-icon.png"))); // NOI18N
        jButtonExcluirAtracao.setPreferredSize(new java.awt.Dimension(22, 22));

        jButtonSelecionarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N
        jButtonSelecionarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarUsuarioActionPerformed(evt);
            }
        });

        jButtonExcluirUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eraser-icon.png"))); // NOI18N
        jButtonExcluirUsuario.setPreferredSize(new java.awt.Dimension(22, 22));

        jButtonSelecionarTipoPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N
        jButtonSelecionarTipoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarTipoPagamentoActionPerformed(evt);
            }
        });

        jButtonExcluirTipoPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eraser-icon.png"))); // NOI18N
        jButtonExcluirTipoPagamento.setPreferredSize(new java.awt.Dimension(22, 22));

        jLabelDataEmissao.setText("Data Emissão:");

        jLabelValorAtracao.setText("Valor atracao:");

        jTextFieldValorAtracao.setEditable(false);

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jLabelValorTotal.setText("Valor total:");

        jTextFieldValorTotal.setEditable(false);

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jCheckBoxFinalizada.setText("Finalizada");
        jCheckBoxFinalizada.setEnabled(false);

        jLabelValorConsumo.setText("Valor Consumo:");

        jTextFieldValorConsumo.setEditable(false);
        jTextFieldValorConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorConsumoActionPerformed(evt);
            }
        });

        jTableItemPedido.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableItemPedido);

        jLabelItemPedido.setText("Itens consumidos:");

        jButtonExcluirItemPedido.setText("-");
        jButtonExcluirItemPedido.setEnabled(false);

        jButtonAdicionarItemPedido.setText("+");
        jButtonAdicionarItemPedido.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonExcluirItemPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdicionarItemPedido))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelItemPedido)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelUsuario)
                                    .addComponent(jLabelId))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonExcluirAtracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonSelecionarAtracao))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonExcluirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonSelecionarUsuario))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelAtracao)
                                .addGap(17, 17, 17)
                                .addComponent(jTextFieldAtracao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(jLabelTipoPagamento)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonExcluirTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSelecionarTipoPagamento)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabelDataEmissao)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBoxFinalizada)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonSalvar)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonExcluir)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelValorTotal)
                                    .addComponent(jLabelValorAtracao)
                                    .addComponent(jLabelValorConsumo))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldValorAtracao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldValorConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator3)))
                .addContainerGap())
            .addComponent(jSeparator2)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelId)
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelUsuario)
                                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButtonExcluirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonSelecionarUsuario))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldAtracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelAtracao)
                                .addComponent(jLabelTipoPagamento)
                                .addComponent(jTextFieldTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonExcluirAtracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonExcluirTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSelecionarTipoPagamento)))
                    .addComponent(jButtonSelecionarAtracao))
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataEmissao)
                    .addComponent(jTextFieldDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelValorConsumo)
                    .addComponent(jTextFieldValorConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValorAtracao)
                    .addComponent(jTextFieldValorAtracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValorTotal)
                    .addComponent(jTextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelItemPedido)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionarItemPedido)
                    .addComponent(jButtonExcluirItemPedido))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxFinalizada)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonExcluir))
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldValorConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorConsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorConsumoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        System.out.println("Salvar");
        
        try {
            checkInput();
            dataDown();
            notaFiscal.save();
            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
        } catch(Exception ex) {            
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        System.out.println("Excluir");

        try {
            checkInput();
            dataDown();
            notaFiscal.delete();
            this.dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
        } catch(Exception ex) {
             LogTrack.getInstance().addException( ex, true, this );
        }    
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonSelecionarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarUsuarioActionPerformed
        try {
            
            if( usuario == null ) {
                usuario = new Usuario();
            }
            
            JFrameConsultaUsuario jFrameConsulta;
            jFrameConsulta = new JFrameConsultaUsuario( true, false, usuario );
            
            jFrameConsulta.addWindowListener( new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if( usuario.getNome() != null ) {
                        jTextFieldUsuario.setText( usuario.getNome());
                    }
                }
            } );
            
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ) {
            LogTrack.getInstance().addException(ex, true, this);
            usuario = null;
        }
    }//GEN-LAST:event_jButtonSelecionarUsuarioActionPerformed

    private void jButtonSelecionarAtracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarAtracaoActionPerformed
        try {
            
            if( atracao == null ) {
                atracao = new Atracao();
            }
            
            JFrameConsultaAtracao jFrameConsulta;
            jFrameConsulta = new JFrameConsultaAtracao( true, false, atracao );
            
            jFrameConsulta.addWindowListener( new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if( atracao.getDescricao()!= null ) {
                        jTextFieldAtracao.setText( atracao.getDescricao());
                    }
                }
            } );
            
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ) {
            LogTrack.getInstance().addException(ex, true, this);
            atracao = null;
        }
    }//GEN-LAST:event_jButtonSelecionarAtracaoActionPerformed

    private void jButtonSelecionarTipoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarTipoPagamentoActionPerformed
        try {
            
            if( tipoPagamento == null ) {
                tipoPagamento = new TipoPagamento();
            }
            
            JFrameConsultaTipoPagamento jFrameConsulta;
            jFrameConsulta = new JFrameConsultaTipoPagamento( true, false, tipoPagamento );
            
            jFrameConsulta.addWindowListener( new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if( tipoPagamento.getNomeTipoPagamento() != null ) {
                        jTextFieldTipoPagamento.setText( tipoPagamento.getNomeTipoPagamento());
                    }
                }
            } );
            
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ) {
            LogTrack.getInstance().addException(ex, true, this);
            atracao = null;
        }
    }//GEN-LAST:event_jButtonSelecionarTipoPagamentoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if( this.disconnectOnClose ) {
            System.out.println("Desconectar.");
            try {
                notaFiscal.disconnectFromDatabase();
            } catch ( Exception ex ) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(JFrameNotaFiscalCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameNotaFiscalCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameNotaFiscalCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameNotaFiscalCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFrameNotaFiscalCRUD( null, true ).setVisible(true);
                } catch (Exception ex) {
                    LogTrack.getInstance().addException( ex, true, null );
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarItemPedido;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonExcluirAtracao;
    private javax.swing.JButton jButtonExcluirItemPedido;
    private javax.swing.JButton jButtonExcluirTipoPagamento;
    private javax.swing.JButton jButtonExcluirUsuario;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSelecionarAtracao;
    private javax.swing.JButton jButtonSelecionarTipoPagamento;
    private javax.swing.JButton jButtonSelecionarUsuario;
    private javax.swing.JCheckBox jCheckBoxFinalizada;
    private javax.swing.JLabel jLabelAtracao;
    private javax.swing.JLabel jLabelDataEmissao;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelItemPedido;
    private javax.swing.JLabel jLabelTipoPagamento;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelValorAtracao;
    private javax.swing.JLabel jLabelValorConsumo;
    private javax.swing.JLabel jLabelValorTotal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTableItemPedido;
    private javax.swing.JTextField jTextFieldAtracao;
    private javax.swing.JTextField jTextFieldDataEmissao;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldTipoPagamento;
    private javax.swing.JTextField jTextFieldUsuario;
    private javax.swing.JTextField jTextFieldValorAtracao;
    private javax.swing.JTextField jTextFieldValorConsumo;
    private javax.swing.JTextField jTextFieldValorTotal;
    // End of variables declaration//GEN-END:variables
}
