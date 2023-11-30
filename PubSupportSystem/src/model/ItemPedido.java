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
        this.idProduto = idProduto;
    }

    public void setIdNotaFiscal(int idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    protected String getWhereClauseForOneEntry() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      
}
