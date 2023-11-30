package model;

public class TipoProduto {
    private int idTipoProduto;
    private String nomeTipo;

    public TipoProduto() {
        //super("tipo_produto");
    }

    // GETTERS
    
    public int getIdTipoProduto() {
        return idTipoProduto;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    // SETTERS
    
    public void setIdTipoProduto(int idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }
    
    
}
