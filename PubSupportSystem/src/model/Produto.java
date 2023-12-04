package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class Produto  extends DataAccessObject  {

    private int idProduto;
    private String nomeProduto;
    private double preco;
    private double desconto;
    private TipoProduto tipoProduto; //FK TipoProduto idTipoProduto

    public Produto() {
        super("produto");
    }
    
    // GETTERS
    
    public int getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

    public double getDesconto() {
        return desconto;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }
    
    
    // SETTERS

    public void setIdproduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) throws Exception{
            if(this.tipoProduto  == null ){
                
                if( tipoProduto != null ){
                    this.tipoProduto = new TipoProduto();
                    this.tipoProduto.setIdTipoProduto(tipoProduto.getIdTipoProduto());
                    this.tipoProduto.load();
                    addChange("id_tipo_produto", this.tipoProduto.getIdTipoProduto());   
                }    
            }else{
                if(tipoProduto == null){
                    this.tipoProduto = null;
                    addChange( "id_tipo_produto", null );
                }else{
                    
                    if(!this.tipoProduto.equals( tipoProduto)){
                        this.tipoProduto.setIdTipoProduto( tipoProduto.getIdTipoProduto() );
                        this.tipoProduto.load();
                        addChange( "id_tipo_produto", this.tipoProduto.getIdTipoProduto() );
                    }  
                }
            } 
    }

    @Override
    protected String getWhereClauseForOneEntry() {
        return " id_produto = " + idProduto;        
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
       
        idProduto = (int) data.get(0);
        nomeProduto = (String) data.get(1);
        preco = (Double) data.get(2);
        desconto = (Double) data.get(3);
        
        if(data.get(4) != null){
            if(tipoProduto == null){
                tipoProduto = new TipoProduto();
            }
            
            tipoProduto.setIdTipoProduto((int) data.get(4));
            tipoProduto.load();
        }
    }

}
