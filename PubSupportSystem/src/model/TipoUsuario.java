package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class TipoUsuario extends DataAccessObject {
    
    private int idTipoUsuario;
    private String nome;
    private String moduloAdministrativo;
    private String moduloFuncionario;
    
    public TipoUsuario(){
        super("tipo_usuario");
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getModuloAdministrativo() {
        return moduloAdministrativo;
    }

    public String getModuloFuncionario() {
        return moduloFuncionario;
    }
    
    public void setIdTipoUsuario(int idTipoUsuario){
        if(idTipoUsuario != this.idTipoUsuario){
            this.idTipoUsuario = idTipoUsuario;
            addChange("id_tipo_usuario", this.idTipoUsuario);
        }
    }
    
    public void setNome(String nome) {
        if( !nome.equals( this.nome ) ) {
            this.nome = nome;
            addChange("nome", this.nome);
        }
    }
    
    public void setModuloAdministrativo(String moduloAdministrativo) {
        if( !moduloAdministrativo.equals( this.moduloAdministrativo ) ) {
            this.moduloAdministrativo = moduloAdministrativo;
            addChange("modulo_administrativo", this.moduloAdministrativo);
        }
    }
    
    public void setModuloFuncionario(String moduloFuncionario) {
        if( !moduloFuncionario.equals( this.moduloFuncionario ) ) {
            this.moduloFuncionario = moduloFuncionario;
            addChange("modulo_funcionario", this.moduloFuncionario);
        }
    }
    
    @Override
    protected String getWhereClauseForOneEntry() {
        return " id_tipo_usuario = " + idTipoUsuario;
    }

    @Override
    protected void fill(ArrayList<Object> data) {
        idTipoUsuario = (int) data.get(0);
        nome = (String) data.get(1);
        moduloAdministrativo = (String) data.get(2);
        moduloFuncionario = (String) data.get(3);
    }

    @Override
    public boolean equals(Object obj) {        
        if( obj instanceof TipoUsuario ) {
           
           TipoUsuario aux;
           aux = (TipoUsuario) obj;
            
           if( idTipoUsuario == aux.getIdTipoUsuario() ) {
               return true;
           }             
        }        
        return false;
    }
}
