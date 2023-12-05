package model;
import controller.DataAccessObject;
import java.util.ArrayList;

public class ItemPedido  extends DataAccessObject {
    private int idProduto; //FK Produto idProduto;
    private int idNotaFiscal; //FK NotaFiscal idNotaFiscal;
    private int quantidade;

    public ItemPedido() {
        super("item_pedido");    
    }

    // GETTERS
    
    public int getIdProduto() {
        return idProduto;
    }

    public int getIdNotaFiscal() {
        return idNotaFiscal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // SETTERS
    
    public void setIdProduto(int idProduto) {
        if( this.idProduto !=  idProduto ) {
            this.idProduto = idProduto;
            // informar que um campo da tabela foi alterado
            addChange("id_produto", 
                    this.idProduto);
        }
    }

    public void setIdNotaFiscal(int idNotaFiscal) {
        if( this.idNotaFiscal !=  idNotaFiscal ) {
            this.idNotaFiscal = idNotaFiscal;
            // informar que um campo da tabela foi alterado
            addChange("id_nota_fiscal", 
                    this.idNotaFiscal);
        }
    }

    public void setQuantidade(int quantidade) {
        if( this.quantidade !=  quantidade ) {
            this.quantidade = quantidade;
            // informar que um campo da tabela foi alterado
            addChange("quantidade", 
                    this.quantidade);
        }
    }

    @Override
    protected String getWhereClauseForOneEntry() {
        return " id_produto = " + this.idProduto;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        this.idProduto = (int) data.get(0);
        this.idNotaFiscal = (int) data.get(1);
        this.quantidade = (int) data.get(2);        
    }
      
}
