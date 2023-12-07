package model;
import controller.DataAccessObject;
import java.util.ArrayList;

public class ItemPedido  extends DataAccessObject {
    private Produto produto; //FK Produto idProduto;
    private NotaFiscal notaFiscal; //FK NotaFiscal idNotaFiscal;
    private int quantidade;

    public ItemPedido() {
        super("item_pedido");    
    }

    // GETTERS
    
    public Produto getProduto() {
        return produto;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // SETTERS
    
    public void setProduto(Produto produto) throws Exception {
        
        if( this.produto  == null ) {
            
            if( produto != null ) {
                
                this.produto = new Produto();
                this.produto.setIdProduto(produto.getIdProduto());
                this.produto.load();
                addChange( "id_produto", this.produto.getIdProduto() );
                
            }
            
        } else {
            
            if( produto == null ) {
                
                this.produto = null;
                addChange( "id_produto", null );
                
            } else {
                
                if( !this.produto.equals( produto ) ) {
                    
                    this.produto.setIdProduto(produto.getIdProduto() );
                    this.produto.load();
                    addChange( "id_produto", this.produto.getIdProduto() );
                    
                }
                
            }
        }
        
    }
    
    public void setNotaFiscal(NotaFiscal notaFiscal) throws Exception {
        
        if( this.notaFiscal  == null ) {
            
            if( notaFiscal != null ) {
                
                this.notaFiscal = new NotaFiscal();
                this.notaFiscal.setIdNotaFiscal(notaFiscal.getIdNotaFiscal());
                this.notaFiscal.load();
                addChange( "id_nota_fiscal", this.notaFiscal.getIdNotaFiscal() );
                
            }
            
        } else {
            
            if( notaFiscal == null ) {
                
                this.notaFiscal = null;
                addChange( "id_notaFiscal", null );
                
            } else {
                
                if( !this.notaFiscal.equals( notaFiscal ) ) {
                    
                    this.notaFiscal.setIdNotaFiscal(notaFiscal.getIdNotaFiscal() );
                    this.notaFiscal.load();
                    addChange( "id_notaFiscal", this.notaFiscal.getIdNotaFiscal() );
                    
                }
                
            }
        }
        
    }

    public void setQuantidade(int quantidade) {
        if( quantidade != this.quantidade ) {
            this.quantidade = quantidade;
            addChange("quantidade", this.quantidade);
        }
    }

    @Override
    protected String getWhereClauseForOneEntry() {
        String clause;
        
        if(produto == null){
            clause = " id_produto = NULL";
        } else {
            clause = " id_produto = '" + produto.getIdProduto();
        }
        
        if(notaFiscal == null) {
            clause += " AND id_nota_fiscal = NULL";
        } else {
            clause += " AND id_nota_fiscal = " + notaFiscal.getIdNotaFiscal();
        }
        
        return clause;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        if(data.get(0) != null) {
            if(produto == null){
                produto = new Produto();
            }
            
            produto.setIdProduto((int) data.get(0));
            produto.load();
        }
        
        if(data.get(1) != null) {
            if(notaFiscal == null){
                notaFiscal = new NotaFiscal();
            }
            
            notaFiscal.setIdNotaFiscal((int) data.get(1));
            notaFiscal.load();
        }
        
        this.quantidade = (int) data.get(3);
    }
      
}
