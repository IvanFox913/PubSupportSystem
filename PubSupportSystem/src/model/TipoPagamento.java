package model;

public class TipoPagamento {
    private int idTipoPagamento;
    private String nomeTipoPagamento; 

    public TipoPagamento() {
        //super("tipo_pagamento");
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
    
    
}
