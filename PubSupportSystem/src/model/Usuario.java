package model;

import controller.DataAccessObject;
import java.util.ArrayList;

public class Usuario  extends DataAccessObject  {
    private int idUsuario;
    private String firstName;
    private String lastName;
    private String cpf;
    private String telefone;    
    private String devedor; //sim/nao

    public Usuario() {
        super("usuario");
    }

    // GETTERS
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDevedor() {
        return devedor;
    }

    // SETTERS
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDevedor(String devedor) {
        this.devedor = devedor;
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
