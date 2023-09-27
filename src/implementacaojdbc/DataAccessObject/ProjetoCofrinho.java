package implementacaojdbc.DataAccessObject;

import java.sql.Date;

public class ProjetoCofrinho {
            private int id;
        private int id_usuario;
        private String nome;
        private String descricao;
        private Date prazo;
        private Date data_criacao;
        private double meta_quantia;
        private boolean ativo;
    
    public ProjetoCofrinho(int id, int id_usuario, String nome, String descricao, Date prazo, Date data_criacao, double meta_quantia, boolean ativo){
        this.id = id;
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.descricao = descricao;
        this.prazo =  prazo;
        this.data_criacao = data_criacao;
        this.meta_quantia = meta_quantia;
        this.ativo = ativo;
    }
    
    public ProjetoCofrinho(int id_usuario, String nome, String descricao, Date prazo, Date data_criacao, double meta_quantia, boolean ativo){
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.descricao = descricao;
        this.prazo =  prazo;   
        this.data_criacao = data_criacao;
        this.meta_quantia = meta_quantia;
        this.ativo = ativo;
    }
    
     public int getId() {
            return id;
        }
    
        public int getIdUsuario() {
            return id_usuario;
        }
    
        public String getNome() {
            return nome;
        }
    
        public Date getPrazo() {
            return prazo;
        }
    
        public Date getDataCriacao() {
            return data_criacao;
        }
    
        public double getMetaQuantia() {
            return meta_quantia;
        }
    
        public String getDescricao() {
            return descricao;
        }
    
        public boolean isAtivo() {
            return ativo;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public void setIdUsuario(int id_usuario) {
            this.id_usuario = id_usuario;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
        public void setPrazo(Date prazo) {
            this.prazo = prazo;
        }
    
        public void setDataCriacao(Date data_criacao) {
            this.data_criacao = data_criacao;
        }
    
        public void setMetaQuantia(double meta_quantia) {
            this.meta_quantia = meta_quantia;
        }
    
        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
    
        public void setAtivo(boolean ativo) {
            this.ativo = ativo;
        }

        public int getId_usuario() {
            return 0;
        }

        public boolean getAtivo() {
            return false;
        }    
    }