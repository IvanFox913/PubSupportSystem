package model;
import controller.DataAccessObject;
import java.util.ArrayList;

public class NotaFiscal  extends DataAccessObject {
    
    private int idNotaFiscal;
    private double precoTotal;
    private String dataEmissao;
    private String finalizada;
    private TipoPagamento tipoPagamento; //FK TipoPagamento idTipoPagamento
    private Atracao atracao; //FK Atracao idAtracao
    private Usuario usuario; //FK Usuario idUsuario

    public NotaFiscal() {
        super("nota_fiscal");
    }
    
    // GETTERS

    public int getIdNotaFiscal() {
        return idNotaFiscal;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }
    
    public String getDataEmissao() {
        return dataEmissao;
    }
    
    public String getFinalizada() {
        return finalizada;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public Atracao getAtracao() {
        return atracao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    // SETTERS
    
    public void setIdNotaFiscal(int idNotaFiscal) {
        if(idNotaFiscal != this.idNotaFiscal){
            this.idNotaFiscal = idNotaFiscal;
            addChange("id_nota_fiscal", this.idNotaFiscal);
        }
    }

    public void setPrecoTotal(double precoTotal) {
        if(precoTotal != this.precoTotal){
            this.precoTotal = precoTotal;
            addChange("preco_total", this.precoTotal);
        }
    }
    
    public void setDataEmissao(String dataEmissao) {
        if( !dataEmissao.equals( this.dataEmissao ) ) {
            this.dataEmissao = dataEmissao;
            addChange("data_emissao", this.dataEmissao);
        }
    }
    
    public void setFinalizada(String finalizada) {
        if (!finalizada.equals(this.finalizada)){
            this.finalizada = finalizada;
            addChange("finalizada", this.finalizada);
        }
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) throws Exception {
        if( this.tipoPagamento  == null ) {
            
            if( tipoPagamento != null ) {
                
                this.tipoPagamento = new TipoPagamento();
                this.tipoPagamento.setIdTipoPagamento( tipoPagamento.getIdTipoPagamento() );
                this.tipoPagamento.load();
                addChange( "id_tipo_pagamento", this.tipoPagamento.getIdTipoPagamento() );
                
            }
            
        } else {
            
            if( tipoPagamento == null ) {
                
                this.tipoPagamento = null;
                addChange( "id_tipo_pagamento", null );
                
            } else {
                
                if( !this.tipoPagamento.equals( tipoPagamento ) ) {
                    
                    this.tipoPagamento.setIdTipoPagamento( tipoPagamento.getIdTipoPagamento() );
                    this.tipoPagamento.load();
                    addChange( "id_tipo_pagamento", this.tipoPagamento.getIdTipoPagamento() );
                    
                }
                
            }
        }
    }
    
    public void setAtracao(Atracao atracao) throws Exception {
        if( this.atracao  == null ) {
            
            if( atracao != null ) {
                
                this.atracao = new Atracao();
                this.atracao.setIdAtracao( atracao.getIdAtracao() );
                this.atracao.load();
                addChange( "id_atracao", this.atracao.getIdAtracao() );
                
            }
            
        } else {
            
            if( atracao == null ) {
                
                this.atracao = null;
                addChange( "id_atracao", null );
                
            } else {
                
                if( !this.atracao.equals( atracao ) ) {
                    
                    this.atracao.setIdAtracao( atracao.getIdAtracao() );
                    this.atracao.load();
                    addChange( "id_atracao", this.atracao.getIdAtracao() );
                    
                }
                
            }
        }
    }
    
    public void setUsuario(Usuario usuario) throws Exception {
        if( this.usuario  == null ) {
            
            if( usuario != null ) {
                
                this.usuario = new Usuario();
                this.usuario.setIdUsuario( usuario.getIdUsuario() );
                this.usuario.load();
                addChange( "id_usuario", this.usuario.getIdUsuario() );
                
            }
            
        } else {
            
            if( usuario == null ) {
                
                this.usuario = null;
                addChange( "id_usuario", null );
                
            } else {
                
                if( !this.usuario.equals( usuario ) ) {
                    
                    this.usuario.setIdUsuario( usuario.getIdUsuario() );
                    this.usuario.load();
                    addChange( "id_usuario", this.usuario.getIdUsuario() );
                    
                }
                
            }
        }
    }

    @Override
    protected String getWhereClauseForOneEntry() {
        return " id_nota_fiscal = " + idNotaFiscal;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        idNotaFiscal = (int) data.get(0);
        precoTotal = (double) data.get(1);
        if(data.get(2) != null){
            dataEmissao = data.get(2).toString();
        }
        finalizada = (String) data.get(3);
        
        
        if(data.get(4) != null) {
            if(tipoPagamento == null) {
                tipoPagamento = new TipoPagamento();
            }
            tipoPagamento.setIdTipoPagamento((int) data.get(4));
            tipoPagamento.load();
        }
        
        if(data.get(5) != null) {
            if(atracao == null) {
                atracao = new Atracao();
            }
            atracao.setIdAtracao((int) data.get(5));
            atracao.load();
        }
        
        if(data.get(6) != null) {
            if(usuario == null) {
                usuario = new Usuario();
            }
            usuario.setIdUsuario((int) data.get(6));
            usuario.load();
        }
    }
    
    @Override
    public boolean equals(Object obj) {        
        if( obj instanceof NotaFiscal ) {
           
           NotaFiscal aux;
           aux = (NotaFiscal) obj;
            
           if( idNotaFiscal == aux.getIdNotaFiscal() ) {
               return true;
           }             
        }        
        return false;
    }
    
}
