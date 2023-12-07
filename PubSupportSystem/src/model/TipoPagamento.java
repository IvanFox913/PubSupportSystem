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
        // verificar se o estado do objeto precisar alterar/modificar
        if( this.idTipoPagamento !=  idTipoPagamento ) {
            this.idTipoPagamento = idTipoPagamento;
            // informar que um campo da tabela foi alterado
            addChange("id_tipo_pagamento", this.idTipoPagamento);
        }
    }

    public void setNomeTipoPagamento(String nomeTipoPagamento) {
        if( !nomeTipoPagamento.equals( this.nomeTipoPagamento ) ) {
            this.nomeTipoPagamento = nomeTipoPagamento;
            addChange("nome_tipo_pagamento", this.nomeTipoPagamento);
        }
    }

    @Override
    protected String getWhereClauseForOneEntry() {
        return " id_tipo_pagamento = " + this.idTipoPagamento;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        this.idTipoPagamento = (int) data.get(0);
        this.nomeTipoPagamento = (String) data.get(1);
    }
    
    
}
