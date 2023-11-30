package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class Atracao extends DataAccessObject {

    private int idAtracao;
    private String descricao;
    private double preco;

    public Atracao() {
        super("atracao");    
    }

    // GETTERS
    
    public int getIdAtracao() {
        return idAtracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    // SETTERS
    
    public void setIdAtracao(int idAtracao) {
        // verificar se o estado do objeto precisar alterar/modificar
        if( this.idAtracao !=  idAtracao ) {
            this.idAtracao = idAtracao;
            // informar que um campo da tabela foi alterado
            addChange("id_atracao", 
                    this.idAtracao);
        }
    }

    public void setDescricao(String descricao) {
        if( !descricao.equals( this.descricao ) ) {
            this.descricao = descricao;
             addChange("descricao", 
                    this.descricao);
        }
    }

    public void setPreco(double preco) {
        if( preco != this.preco ) {
            this.preco = preco;
            addChange("preco", this.preco);
        }
    }

    @Override
    protected String getWhereClauseForOneEntry() {
        // utilizar somene chaves primárias
        return " id_atracao = " + this.idAtracao;
    }

    @Override
    protected void fill(ArrayList<Object> data) throws Exception {
        // ordem do preenchimento segue a ordem definida na criação da tabela
        this.idAtracao = (int) data.get(0);
        this.descricao = (String) data.get(1);
        this.preco = (double) data.get(2);
    }
    
}
