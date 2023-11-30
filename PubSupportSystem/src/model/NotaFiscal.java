package model;

public class NotaFiscal {
    
    private int idNotaFiscal;
    private double precoTotal;
    private String data;
    private int idTipoPagamento; //FK TipoPagamento idTipoPagamento
    private int idAtracao; //FK Atracao idAtracao
    private int idUsuario; //FK Usuario idUsuario

    public NotaFiscal() {
        //super("nota_fiscal");
    }
    
    // GETTERS

    public int getIdNotaFiscal() {
        return idNotaFiscal;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }
    
    public String getData() {
        return data;
    }

    public int getIdTipoPagamento() {
        return idTipoPagamento;
    }

    public int getIdAtracao() {
        return idAtracao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    // SETTERS
    
    public void setIdNotaFiscal(int idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
    
    public void setData(String data) {
        this.data = data;
    }

    public void setIdTipoPagamento(int idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }

    public void setIdAtracao(int idAtracao) {
        this.idAtracao = idAtracao;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
