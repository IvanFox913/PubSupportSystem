
package view;

import controller.LogTrack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import model.Usuario;
import view.JFrameAtracaoCRUD;
import view.JFrameConsultaAtracao;
import view.JFrameConsultaItemPedido;
import view.JFrameItemPedidoCRUD;


public class JFrameSistemaPrincipal extends javax.swing.JFrame {
    
    private Usuario usuario;
    
     //* Creates new form JFrameSistema *//
    public JFrameSistemaPrincipal() throws SQLException {
        initComponents();  
        
        logout();
        
    }
    
    private void logout() {
        
        usuario = new Usuario();
        
        jLabelBemvindo.setVisible(false);
        
        jTextFieldUsuario.setText("");
        jPasswordFieldSenha.setText("");
        jPanelLogin.setEnabled(true);
        jTextFieldUsuario.setEnabled(true);//.setText("");
        jPasswordFieldSenha.setEnabled(true);
        jButtonLogin.setEnabled(true);
        jTabbedPanel.setSelectedIndex(0);
        
        jLabelDelicia.setVisible(false);
        jMenuAdministrativo.setEnabled(false);
        jMenuAtendimento.setEnabled(false);
        jMenuUsuario.setEnabled(false);
        jPanelLogin.setVisible(true);
        
    }
    
    private void login() {
        
        jPanelLogin.setEnabled(false);
        jTextFieldUsuario.setEnabled(false);//.setText("");
        jPasswordFieldSenha.setEnabled(false);
        jButtonLogin.setEnabled(false);
        jTabbedPanel.setSelectedIndex(1);
        
        //jLabelBemvindo.setEnabled(true);
        jLabelBemvindo.setVisible(true);
        jLabelBemvindo.setText("Bem-vindo/a, " + usuario.getNome() + "!");
        jLabelDelicia.setVisible(true);
                
        
        if( usuario.getTipoUsuario().getModuloAdministrativo().equals("S") ) {
            jMenuAdministrativo.setEnabled(true);
        }
        
        if( usuario.getTipoUsuario().getModuloFuncionario().equals("S") ) {
            jMenuAtendimento.setEnabled(true);
        }
        
        jMenuUsuario.setEnabled(true);
        
               
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
        jPanelMenu = new javax.swing.JPanel();
        jLabelBemvindo = new javax.swing.JLabel();
        jTabbedPanel = new javax.swing.JTabbedPane();
        jPanelLogin = new javax.swing.JPanel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jLabelIniciarSessao = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jPanelAreaUsuario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBarActions = new javax.swing.JMenuBar();
        jMenuAdministrativo = new javax.swing.JMenu();
        jMenuItemCadastroUsuario = new javax.swing.JMenuItem();
        jMenuItemCadastroTipoUsuario = new javax.swing.JMenuItem();
        jMenuItemCadastroItemPedido = new javax.swing.JMenuItem();
        jMenuItemCadastroAtracao = new javax.swing.JMenuItem();
        jMenuItemCadastroTipoProduto = new javax.swing.JMenuItem();
        jMenuItemCadastroProduto = new javax.swing.JMenuItem();
        jMenuItemCadastroNF = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemConsultaNF = new javax.swing.JMenuItem();
        jMenuItemConsultaUsuario = new javax.swing.JMenuItem();
        jMenuItemConsultaTipoUsuario = new javax.swing.JMenuItem();
        jMenuItemConsultaItemPedido = new javax.swing.JMenuItem();
        jMenuItemConsultaAtracao = new javax.swing.JMenuItem();
        jMenuItemConsultaTipoProduto = new javax.swing.JMenuItem();
        jMenuItemConsultaProdutos = new javax.swing.JMenuItem();
        jMenuAtendimento = new javax.swing.JMenu();
        jMenuItemConsultaCliente = new javax.swing.JMenuItem();
        jMenuItemAtendenteConsultaNFCliente = new javax.swing.JMenuItem();
        jMenuItemConsultaItemPedidoCliente = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemNovoCliente = new javax.swing.JMenuItem();
        jMenuItemCrearNF = new javax.swing.JMenuItem();
        jMenuItemCrearItemPedido = new javax.swing.JMenuItem();
        jMenuUsuario = new javax.swing.JMenu();
        jMenuItemConsultaNFCliente = new javax.swing.JMenuItem();
        jMenuItemUsuarioSair = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemConsultaMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema - La Delicia");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDelicia.setFont(new java.awt.Font("Zilla Slab", 3, 48)); // NOI18N
        jLabelDelicia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/titulo.png"))); // NOI18N
        jLabelDelicia.setText("La Delicia");
        jLabelDelicia.setFocusable(false);
        jLabelDelicia.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabelDelicia, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 370, 90));

        jPanelMenu.setBackground(new java.awt.Color(102, 102, 102));

        jLabelBemvindo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelBemvindo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBemvindo.setText("Bem-vindo!");

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelBemvindo)
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelBemvindo)
                .addContainerGap(586, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 620));

        jPanelLogin.setBackground(new java.awt.Color(153, 153, 153));
        jPanelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelUsuario.setText("Usuário:");
        jPanelLogin.add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        jLabelSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSenha.setText("Senha:");
        jPanelLogin.add(jLabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

        jTextFieldUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldUsuario.setBorder(null);
        jTextFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioActionPerformed(evt);
            }
        });
        jPanelLogin.add(jTextFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 250, 35));

        jPasswordFieldSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordFieldSenha.setBorder(null);
        jPanelLogin.add(jPasswordFieldSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 250, 35));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabelIniciarSessao.setFont(new java.awt.Font("Tw Cen MT", 3, 36)); // NOI18N
        jLabelIniciarSessao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIniciarSessao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIniciarSessao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iniciar.png"))); // NOI18N
        jLabelIniciarSessao.setText("Iniciar Sessão");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabelIniciarSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 210, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelIniciarSessao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        jPanelLogin.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 110));

        jButtonLogin.setBackground(new java.awt.Color(0, 0, 0));
        jButtonLogin.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setText("Login");
        jButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        jPanelLogin.add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 250, 35));

        jButtonSair.setBackground(new java.awt.Color(204, 0, 0));
        jButtonSair.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButtonSair.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        jPanelLogin.add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 250, 35));

        jTabbedPanel.addTab("Login", jPanelLogin);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanelAreaUsuarioLayout = new javax.swing.GroupLayout(jPanelAreaUsuario);
        jPanelAreaUsuario.setLayout(jPanelAreaUsuarioLayout);
        jPanelAreaUsuarioLayout.setHorizontalGroup(
            jPanelAreaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaUsuarioLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanelAreaUsuarioLayout.setVerticalGroup(
            jPanelAreaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAreaUsuarioLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jTabbedPanel.addTab("Area do Usuario", jPanelAreaUsuario);

        getContentPane().add(jTabbedPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 550, 500));

        jMenuAdministrativo.setText("Administrativo");

        jMenuItemCadastroUsuario.setText("Cadastro Usuario");
        jMenuItemCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroUsuarioActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemCadastroUsuario);

        jMenuItemCadastroTipoUsuario.setText("Cadastro Tipo Usuario");
        jMenuItemCadastroTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroTipoUsuarioActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemCadastroTipoUsuario);

        jMenuItemCadastroItemPedido.setText("Cadastro Item Pedido");
        jMenuItemCadastroItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroItemPedidoActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemCadastroItemPedido);

        jMenuItemCadastroAtracao.setText("Cadastro Atração");
        jMenuItemCadastroAtracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroAtracaoActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemCadastroAtracao);

        jMenuItemCadastroTipoProduto.setText("Cadastro Tipo Produto");
        jMenuItemCadastroTipoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroTipoProdutoActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemCadastroTipoProduto);

        jMenuItemCadastroProduto.setText("Cadastro Produto");
        jMenuItemCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroProdutoActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemCadastroProduto);

        jMenuItemCadastroNF.setText("Cadastro Nota Fiscal");
        jMenuItemCadastroNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroNFActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemCadastroNF);
        jMenuAdministrativo.add(jSeparator1);

        jMenuItemConsultaNF.setText("Consulta Nota Fiscal");
        jMenuItemConsultaNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaNFActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemConsultaNF);

        jMenuItemConsultaUsuario.setText("Consulta Usuario");
        jMenuItemConsultaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaUsuarioActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemConsultaUsuario);

        jMenuItemConsultaTipoUsuario.setText("Consulta Tipo Usuario");
        jMenuItemConsultaTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaTipoUsuarioActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemConsultaTipoUsuario);

        jMenuItemConsultaItemPedido.setText("Consulta Item Pedido");
        jMenuItemConsultaItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaItemPedidoActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemConsultaItemPedido);

        jMenuItemConsultaAtracao.setText("Consulta Atração");
        jMenuItemConsultaAtracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaAtracaoActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemConsultaAtracao);

        jMenuItemConsultaTipoProduto.setText("Consulta Tipo Produto");
        jMenuItemConsultaTipoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaTipoProdutoActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemConsultaTipoProduto);

        jMenuItemConsultaProdutos.setText("Consulta Produto");
        jMenuItemConsultaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaProdutosActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemConsultaProdutos);

        jMenuBarActions.add(jMenuAdministrativo);

        jMenuAtendimento.setText("Pedidos");

        jMenuItemConsultaCliente.setText("Consulta Cliente");
        jMenuItemConsultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaClienteActionPerformed(evt);
            }
        });
        jMenuAtendimento.add(jMenuItemConsultaCliente);

        jMenuItemAtendenteConsultaNFCliente.setText("Consulta Nota Fiscal");
        jMenuItemAtendenteConsultaNFCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAtendenteConsultaNFClienteActionPerformed(evt);
            }
        });
        jMenuAtendimento.add(jMenuItemAtendenteConsultaNFCliente);

        jMenuItemConsultaItemPedidoCliente.setText("Consulta Item Pedido");
        jMenuItemConsultaItemPedidoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaItemPedidoClienteActionPerformed(evt);
            }
        });
        jMenuAtendimento.add(jMenuItemConsultaItemPedidoCliente);
        jMenuAtendimento.add(jSeparator2);

        jMenuItemNovoCliente.setText("Novo Cliente");
        jMenuItemNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNovoClienteActionPerformed(evt);
            }
        });
        jMenuAtendimento.add(jMenuItemNovoCliente);

        jMenuItemCrearNF.setText("Crear/Alterar Nota Fiscal");
        jMenuItemCrearNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCrearNFActionPerformed(evt);
            }
        });
        jMenuAtendimento.add(jMenuItemCrearNF);

        jMenuItemCrearItemPedido.setText("Crear/Alterar Item Pedido");
        jMenuItemCrearItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCrearItemPedidoActionPerformed(evt);
            }
        });
        jMenuAtendimento.add(jMenuItemCrearItemPedido);

        jMenuBarActions.add(jMenuAtendimento);

        jMenuUsuario.setText("Cliente");

        jMenuItemConsultaNFCliente.setText("Ver Nota Fiscal");
        jMenuItemConsultaNFCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaNFClienteActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuItemConsultaNFCliente);

        jMenuItemUsuarioSair.setText("Sair");
        jMenuItemUsuarioSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuarioSairActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuItemUsuarioSair);

        jMenuBarActions.add(jMenuUsuario);

        jMenu1.setText("Menu");

        jMenuItemConsultaMenu.setText("Consulta Produto");
        jMenuItemConsultaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaMenuActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemConsultaMenu);

        jMenuBarActions.add(jMenu1);

        setJMenuBar(jMenuBarActions);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadastroItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroItemPedidoActionPerformed
        try {
            JFrameItemPedidoCRUD jFrameCRUD;
            jFrameCRUD = new JFrameItemPedidoCRUD( false, true, null );
            jFrameCRUD.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemCadastroItemPedidoActionPerformed

    private void jMenuItemConsultaItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaItemPedidoActionPerformed
        try {
            JFrameConsultaItemPedido jFrameConsulta;
            jFrameConsulta = new JFrameConsultaItemPedido( false, true, null );
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemConsultaItemPedidoActionPerformed

    private void jMenuItemCadastroAtracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroAtracaoActionPerformed
        try {
            JFrameAtracaoCRUD jFrameCRUD;
            jFrameCRUD = new JFrameAtracaoCRUD( null, true );
            jFrameCRUD.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemCadastroAtracaoActionPerformed

    private void jMenuItemConsultaAtracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaAtracaoActionPerformed
        try {
            JFrameConsultaAtracao jFrameConsulta;
            jFrameConsulta = new JFrameConsultaAtracao( false, true, null );
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemConsultaAtracaoActionPerformed

    private void jMenuItemCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroUsuarioActionPerformed
        try {
            JFrameUsuarioCRUD jFrameCRUD;
            jFrameCRUD = new JFrameUsuarioCRUD( null, true );
            jFrameCRUD.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemCadastroUsuarioActionPerformed

    private void jMenuItemCadastroTipoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroTipoProdutoActionPerformed
        try {
            JFrameTipoProdutoCRUD jFrameCRUD;
            jFrameCRUD = new JFrameTipoProdutoCRUD( null, true );
            jFrameCRUD.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemCadastroTipoProdutoActionPerformed

    private void jMenuItemConsultaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaUsuarioActionPerformed
        try {
            JFrameConsultaUsuario jFrameConsulta;
            jFrameConsulta = new JFrameConsultaUsuario( false, true, null );
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemConsultaUsuarioActionPerformed

    private void jMenuItemCadastroTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroTipoUsuarioActionPerformed
        try {
            JFrameTipoUsuarioCRUD jFrameCRUD;
            jFrameCRUD = new JFrameTipoUsuarioCRUD( null, true );
            jFrameCRUD.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemCadastroTipoUsuarioActionPerformed

    private void jMenuItemConsultaTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaTipoUsuarioActionPerformed
        try {
            JFrameConsultaTipoUsuario jFrameConsulta;
            jFrameConsulta = new JFrameConsultaTipoUsuario( false, true, null );
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemConsultaTipoUsuarioActionPerformed

    private void jMenuItemUsuarioSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuarioSairActionPerformed
        logout();
    }//GEN-LAST:event_jMenuItemUsuarioSairActionPerformed

    private void jMenuItemConsultaTipoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaTipoProdutoActionPerformed
        try {
            JFrameConsultaTipoProduto jFrameConsulta;
            jFrameConsulta = new JFrameConsultaTipoProduto( false, true, null );
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemConsultaTipoProdutoActionPerformed

    private void jMenuItemCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroProdutoActionPerformed
        try {
            JFrameProdutoCRUD jFrameCRUD;
            jFrameCRUD = new JFrameProdutoCRUD( null, true );
            jFrameCRUD.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemCadastroProdutoActionPerformed

    private void jMenuItemConsultaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaProdutosActionPerformed
        try {
            JFrameConsultaProduto jFrameConsulta;
            jFrameConsulta = new JFrameConsultaProduto( false, true, null, null );
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemConsultaProdutosActionPerformed

    private void jTextFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioActionPerformed

    }//GEN-LAST:event_jTextFieldUsuarioActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed

        //login();
        
        try {
            
            usuario.setIdUsuario( Integer.parseInt( jTextFieldUsuario.getText() ) );
            usuario.load();
            
            Usuario usLogin = new Usuario();
            
            usLogin.setIdUsuario( Integer.parseInt( jTextFieldUsuario.getText() ) );
            usLogin.setSenha( jPasswordFieldSenha.getText() );
            
            if( usuario.getSenha().equals( usLogin.getSenha() ) ) {
                login();
                usuario.disconnectFromDatabase();
            } else { 
                logout();
                throw new Exception("Senha Inválida!"); 
            }
            
        
        } catch(Exception ex) {
            LogTrack.getInstance().addException( ex, true, this );
        }
         
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jMenuItemConsultaNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaNFActionPerformed
        try {
            JFrameConsultaNotaFiscal jFrameConsulta;
            jFrameConsulta = new JFrameConsultaNotaFiscal( false, true, null );
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemConsultaNFActionPerformed

    private void jMenuItemCadastroNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroNFActionPerformed
        try {
            JFrameNotaFiscalCRUD jFrameCRUD;
            jFrameCRUD = new JFrameNotaFiscalCRUD( null, true );
            jFrameCRUD.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemCadastroNFActionPerformed

    private void jMenuItemConsultaItemPedidoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaItemPedidoClienteActionPerformed
        try {
            JFrameConsultaItemPedido jFrameConsulta;
            jFrameConsulta = new JFrameConsultaItemPedido( false, true, null );
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemConsultaItemPedidoClienteActionPerformed

    private void jMenuItemNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNovoClienteActionPerformed
        try {
            JFrameUsuarioCRUD jFrameCRUD;
            jFrameCRUD = new JFrameUsuarioCRUD( null, true );
            jFrameCRUD.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemNovoClienteActionPerformed

    private void jMenuItemConsultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaClienteActionPerformed
        try {
            JFrameConsultaUsuario jFrameConsulta;
            jFrameConsulta = new JFrameConsultaUsuario( false, true, null );
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemConsultaClienteActionPerformed

    private void jMenuItemConsultaNFClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaNFClienteActionPerformed
        try {
            JFrameConsultaNotaFiscal jFrameConsulta;
            jFrameConsulta = new JFrameConsultaNotaFiscal( false, true, null );
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemConsultaNFClienteActionPerformed

    private void jMenuItemCrearNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearNFActionPerformed
        try {
            JFrameNotaFiscalCRUD jFrameCRUD;
            jFrameCRUD = new JFrameNotaFiscalCRUD( null, true );
            jFrameCRUD.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemCrearNFActionPerformed

    private void jMenuItemCrearItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearItemPedidoActionPerformed
        try {
            JFrameConsultaItemPedido jFrameConsulta;
            jFrameConsulta = new JFrameConsultaItemPedido( false, true, null );
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemCrearItemPedidoActionPerformed

    private void jMenuItemConsultaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaMenuActionPerformed
        try {
            JFrameConsultaProduto jFrameConsulta;
            jFrameConsulta = new JFrameConsultaProduto( false, true, null, null );
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemConsultaMenuActionPerformed

    private void jMenuItemAtendenteConsultaNFClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAtendenteConsultaNFClienteActionPerformed
        try {
            JFrameConsultaNotaFiscal jFrameConsulta;
            jFrameConsulta = new JFrameConsultaNotaFiscal( false, true, null );
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemAtendenteConsultaNFClienteActionPerformed


    
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
            java.util.logging.Logger.getLogger(JFrameSistemaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameSistemaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameSistemaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameSistemaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFrameSistemaPrincipal().setVisible(true);
                } catch (SQLException ex) {
                    //Logger.getLogger(JFrameSistemaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JFrameSistema().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelBemvindo;
    private javax.swing.JLabel jLabelDelicia;
    private javax.swing.JLabel jLabelIniciarSessao;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenuAdministrativo;
    private javax.swing.JMenu jMenuAtendimento;
    private javax.swing.JMenuBar jMenuBarActions;
    private javax.swing.JMenuItem jMenuItemAtendenteConsultaNFCliente;
    private javax.swing.JMenuItem jMenuItemCadastroAtracao;
    private javax.swing.JMenuItem jMenuItemCadastroItemPedido;
    private javax.swing.JMenuItem jMenuItemCadastroNF;
    private javax.swing.JMenuItem jMenuItemCadastroProduto;
    private javax.swing.JMenuItem jMenuItemCadastroTipoProduto;
    private javax.swing.JMenuItem jMenuItemCadastroTipoUsuario;
    private javax.swing.JMenuItem jMenuItemCadastroUsuario;
    private javax.swing.JMenuItem jMenuItemConsultaAtracao;
    private javax.swing.JMenuItem jMenuItemConsultaCliente;
    private javax.swing.JMenuItem jMenuItemConsultaItemPedido;
    private javax.swing.JMenuItem jMenuItemConsultaItemPedidoCliente;
    private javax.swing.JMenuItem jMenuItemConsultaMenu;
    private javax.swing.JMenuItem jMenuItemConsultaNF;
    private javax.swing.JMenuItem jMenuItemConsultaNFCliente;
    private javax.swing.JMenuItem jMenuItemConsultaProdutos;
    private javax.swing.JMenuItem jMenuItemConsultaTipoProduto;
    private javax.swing.JMenuItem jMenuItemConsultaTipoUsuario;
    private javax.swing.JMenuItem jMenuItemConsultaUsuario;
    private javax.swing.JMenuItem jMenuItemCrearItemPedido;
    private javax.swing.JMenuItem jMenuItemCrearNF;
    private javax.swing.JMenuItem jMenuItemNovoCliente;
    private javax.swing.JMenuItem jMenuItemUsuarioSair;
    private javax.swing.JMenu jMenuUsuario;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelAreaUsuario;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPanel;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
