public class Meta {
    private int id;
    private int idCategoria;
    private double valor;
    private int mes;
    private int ano;
    private boolean ativo;

    // Construtor
    public Meta(int id, int idCategoria, double valor, int mes, int ano, boolean ativo) {
        this.id = id;
        this.idCategoria = idCategoria;
        this.valor = valor;
        this.mes = mes;
        this.ano = ano;
        this.ativo = ativo;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
