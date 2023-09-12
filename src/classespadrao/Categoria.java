package classespadrao;
public class Categoria {
    private int id;
    private int idUsuario;
    private String nome;
    private String tipo; // Pode ser 'despesa' ou 'receita'

    public Categoria(int id, int idUsuario, String nome, String tipo) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
