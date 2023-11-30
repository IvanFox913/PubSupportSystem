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
        this.idTipoProduto = idTipoProduto;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
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
