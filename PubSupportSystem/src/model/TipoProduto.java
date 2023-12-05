package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class TipoProduto  extends DataAccessObject  {
    private int idTipoProduto;
    private String nomeTipo;

    public TipoProduto() {
        super("tipo_produto");
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
        if( idTipoProduto !=  this.idTipoProduto ) {
            this.idTipoProduto = idTipoProduto;
            // informar que um campo da tabela foi alterado
            addChange("id_tipo_produto", this.idTipoProduto);
        }
    }

    public void setNomeTipo(String nomeTipo) {
        if( !nomeTipo.equals( this.nomeTipo ) ) {
            this.nomeTipo = nomeTipo;
             addChange("nome_tipo", 
                    this.nomeTipo);
        }
    }

    @Override
    protected String getWhereClauseForOneEntry() {
        return " id_tipo_produto = " + idTipoProduto;     
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        this.idTipoProduto = (int) data.get(0);
        nomeTipo = (String) data.get(1);
    }
    
    
}
