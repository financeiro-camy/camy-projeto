package implementacaojdbc.DataAccessObject;

    import java.time.LocalDate;

public class ContasDinheiro {
    private String nome;
    private double saldoInicial;
    private LocalDate dataSaldoInicial;

    public ContasDinheiro(String nome, double saldoInicial, LocalDate dataSaldoInicial) {
        this.nome = nome;
        this.saldoInicial = saldoInicial;
        this.dataSaldoInicial = dataSaldoInicial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public LocalDate getDataSaldoInicial() {
        return dataSaldoInicial;
    }

    public void setDataSaldoInicial(LocalDate dataSaldoInicial) {
        this.dataSaldoInicial = dataSaldoInicial;
    }

    @Override
    public String toString() {
        return "ContasDinheiro [nome=" + nome + ", saldoInicial=" + saldoInicial + ", dataSaldoInicial=" + dataSaldoInicial + "]";
    }
}
