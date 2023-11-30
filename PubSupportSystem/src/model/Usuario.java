package model;

import controller.DataAccessObject;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

public class Usuario extends DataAccessObject{
    private int idUsuario;
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String cpf;
    private String senha;
    private String telefone;    
    private String devedor; // /sim /nao
    // teste
    private TipoUsuario tipoUsuario;

    public Usuario() {
        super("usuario");
    }

    // GETTERS
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDevedor() {
        return devedor;
    }
    
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    // SETTERS
    
    public void setIdUsuario(int idUsuario) {
        if( idUsuario != this.idUsuario ) {
            this.idUsuario = idUsuario;
            addChange("id_usuario", this.idUsuario);
        }
    }

    public void setNome(String nome) {
        if( !nome.equals( this.nome ) ) {
            this.nome = nome;
            addChange("nome", this.nome);
        }
    }

    public void setSobrenome(String sobrenome) {
        if( !sobrenome.equals( this.sobrenome ) ) {
            this.sobrenome = sobrenome;
            addChange("sobrenome", this.sobrenome);
        }
    }
    
    public void setDataNascimento(String dataNascimento) {
        if( !dataNascimento.equals( this.dataNascimento ) ) {
            this.dataNascimento = dataNascimento;
            addChange("data_nascimento", this.dataNascimento);
        }
    }

    public void setCpf(String cpf) {
        if( !cpf.equals( this.cpf ) ) {
            this.cpf = cpf;
            addChange("cpf", this.cpf);
        }
    }
    
    public void setSenha(String senha) {
        if( !senha.equals( this.senha ) ) {
            this.senha = getSenhaHash( senha );
            addChange("senha", this.senha);
        }
    }
    
    private String getSenhaHash(String senha) {
        String senhaHash = "";
        try {            
            MessageDigest md = MessageDigest.getInstance( "SHA-256" );            
            senha += String.valueOf( getIdUsuario() ); // Técnica de Proteção de Morris-Thompson (Sal n-bits)            
            senhaHash = new BigInteger( 1, md.digest( senha.getBytes("UTF-8") ) ).toString(16);       
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }               
        return senhaHash;
    }

    public void setTelefone(String telefone) {
        if( !telefone.equals(this.telefone) ) {
            this.telefone = telefone;
            addChange("telefone", this.telefone);
        }
    }

    public void setDevedor(String devedor) {
        if( !devedor.equals(this.devedor) ) {
            this.devedor = devedor;
            addChange("devedor", this.devedor);
        }
    }
    
    public void setTipoUsuario(TipoUsuario tipoUsuario) throws Exception {
        
        if(this.tipoUsuario  == null ){
            
            if( tipoUsuario != null ){
                this.tipoUsuario = new TipoUsuario();
                this.tipoUsuario.setIdTipoUsuario(tipoUsuario.getIdTipoUsuario());
                this.tipoUsuario.load();
                addChange("id_tipo_usuario", this.tipoUsuario.getIdTipoUsuario());   
            }    
        }else{
            if(tipoUsuario == null){
                this.tipoUsuario = null;
                addChange( "id_tipo_usuario", null );
            }else{
                
                if(!this.tipoUsuario.equals( tipoUsuario)){
                    this.tipoUsuario.setIdTipoUsuario( tipoUsuario.getIdTipoUsuario() );
                    this.tipoUsuario.load();
                    addChange( "id_tipo_usuario", this.tipoUsuario.getIdTipoUsuario() );
                }  
            }
        } 
    }
    
    @Override
    protected String getWhereClauseForOneEntry() {
        return " id_usuario = " + idUsuario;
    }
    
    @Override
    protected void fill(ArrayList<Object> data) throws Exception{
        
        idUsuario = (int) data.get(0);
        nome = (String) data.get(1);
        sobrenome = (String) data.get(2);
        
        if(data.get(3) != null){
            dataNascimento = data.get(3).toString();
        }
        
        cpf = (String) data.get(4);
        senha = (String) data.get(5);
        telefone = (String) data.get(6);
        
        if(data.get(7) != null){
            if(tipoUsuario == null){
                tipoUsuario = new TipoUsuario();
            }
            
            tipoUsuario.setIdTipoUsuario((int) data.get(17));
            tipoUsuario.load();
        }
        
    }
    
}
