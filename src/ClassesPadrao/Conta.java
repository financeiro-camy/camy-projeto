package ClassesPadrao;

public class Conta {
    private int id;
    private int idUsuario;
    private String nome;

    // Construtor
    public Conta(int id, int idUsuario, String nome) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nome = nome;
    }

    // Getters e Setters
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
}

