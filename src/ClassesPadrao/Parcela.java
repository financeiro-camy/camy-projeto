package ClassesPadrao;
import java.util.Date;

public class Parcela {
    private int id;
    private int idLancamento; // Referência à despesa ou receita à qual a parcela pertence
    private String tipoLancamento; // Pode ser 'despesa' ou 'receita'
    private int numero;
    private double valor;
    private Date dataVencimento;
    private boolean pago;
    private Date dataPagamento;

    // Construtor
    public Parcela(int id, int idLancamento, String tipoLancamento, int numero, double valor, Date dataVencimento, boolean pago, Date dataPagamento) {
        this.id = id;
        this.idLancamento = idLancamento;
        this.tipoLancamento = tipoLancamento;
        this.numero = numero;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.pago = pago;
        this.dataPagamento = dataPagamento;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public int getIdLancamento() {
        return idLancamento;
    }

    public void setIdLancamento(int idLancamento) {
        this.idLancamento = idLancamento;
    }

    public String getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(String tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
