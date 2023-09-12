package classespadrao;

public class Configuracao {
    private int id;
    private int idUsuario;
    private String moeda;

    public Configuracao(int id, int idUsuario, String moeda) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.moeda = moeda;
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

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }
}
