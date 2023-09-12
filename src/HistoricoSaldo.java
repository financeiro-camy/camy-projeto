import java.util.Date;

public class HistoricoSaldo {
    private int id;
    private int idConta;
    private Date data;
    private double saldo;

    public HistoricoSaldo(int id, int idConta, Date data, double saldo) {
        this.id = id;
        this.idConta = idConta;
        this.data = data;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}

