package model;

public class Produto {

    private int idProduto;
    private String nomeProduto;
    private double preco;
    private double desconto;
    private int idTipoProduto; //FK TipoProduto idTipoProduto

    public Produto() {
        //super("produto");
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

    public int getIdtipoProduto() {
        return idTipoProduto;
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

    public void setIdTipoProduto(int idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

}
