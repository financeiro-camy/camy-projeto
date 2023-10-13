package implementacaojdbc.DataAccessObject;
import java.time.LocalDate;

public class Lancamento {
    private int id;
    private int idCategoria;
    private int idConta;
    private String nome;
    private String descricao;
    private double valor;
    private String tipo;
    private String periodicidade;
    private int numeroParcelas;
    private LocalDate dataVencimento;
    private boolean pago;
    private LocalDate dataPagamento;

    public Lancamento (int id, int idCategoria, int idConta, String nome, String descricao, double valor, String tipo, String periodicidade, int numeroParcelas, LocalDate dataVencimento, Boolean pago, LocalDate dataPagamento){
        this.id = id;
        this.idCategoria = idCategoria;
        this.idConta = idConta;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.periodicidade = periodicidade;
        this.numeroParcelas = numeroParcelas;
        this.dataVencimento = dataVencimento;
        this.pago = pago;
        this.dataPagamento = dataPagamento;

    }

    public Lancamento (int idCategoria, int idConta, String nome, String descricao, double valor, String tipo, String periodicidade, int numeroParcelas, LocalDate dataVencimento, Boolean pago, LocalDate dataPagamento){
        this.idCategoria = idCategoria;
        this.idConta = idConta;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.periodicidade = periodicidade;
        this.numeroParcelas = numeroParcelas;
        this.dataVencimento = dataVencimento;
        this.pago = pago;
        this.dataPagamento = dataPagamento;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}


