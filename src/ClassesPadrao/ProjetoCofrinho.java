package ClassesPadrao;
import java.util.Date;

public class ProjetoCofrinho {
    private int id;
    private String nome;
    private String descricao;
    private Date dataCriacao;
    private Date prazo;
    private double metaQuantia;
    private int idUsuario;
    private boolean ativo;

    // Construtor
    public ProjetoCofrinho(int id, String nome, String descricao, Date dataCriacao, Date prazo, double metaQuantia, int idUsuario, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.prazo = prazo;
        this.metaQuantia = metaQuantia;
        this.idUsuario = idUsuario;
        this.ativo = ativo;
    }

    // Getters e Setters
    public int getId() {
        return id;
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

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public double getMetaQuantia() {
        return metaQuantia;
    }

    public void setMetaQuantia(double metaQuantia) {
        this.metaQuantia = metaQuantia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
