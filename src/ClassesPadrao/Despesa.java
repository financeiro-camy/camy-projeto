package ClassesPadrao;

import java.util.Date;
import java.util.List;

public class Despesa {
    private int id;
    private int idCategoria;
    private int idConta;
    private String nome;
    private String descricao;
    private double valor;
    private String classificacao;
    private Date dataVencimento;
    private boolean pago;
    private Date dataPagamento;

    public Despesa(int id, int idCategoria, int idConta, String nome, String descricao, double valor, String classificacao, Date dataVencimento, boolean pago, Date dataPagamento) {
        this.id = id;
        this.idCategoria = idCategoria;
        this.idConta = idConta;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.classificacao = classificacao;
        this.dataVencimento = dataVencimento;
        this.pago = pago;
        this.dataPagamento = dataPagamento;
    }
    
    private List<Parcela> parcelas;

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }
}