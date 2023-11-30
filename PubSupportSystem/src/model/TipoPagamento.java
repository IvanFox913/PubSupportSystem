package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class TipoPagamento  extends DataAccessObject  {
    private int idTipoPagamento;
    private String nomeTipoPagamento; 

    public TipoPagamento() {
        super("tipo_pagamento");
    }

    // GETTERS
    
    public int getIdTipoPagamento() {
        return idTipoPagamento;
    }

    public String getNomeTipoPagamento() {
        return nomeTipoPagamento;
    }
    
    // SETTERS

    public void setIdTipoPagamento(int idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }

    public void setNomeTipoPagamento(String nomeTipoPagamento) {
        this.nomeTipoPagamento = nomeTipoPagamento;
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
