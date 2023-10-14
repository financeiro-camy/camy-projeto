package implementacaojdbc.DataAccessObject;

public class Usuario {
        private int id;
        private String nome;
        private String email;
        private String senha;
        private boolean ativo;
    
        public Usuario(int id, String nome, String email, String senha, boolean ativo) {
            this.id = id;
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            this.ativo = ativo;
        }

        public Usuario(String nome, String email, String senha, boolean ativo) {
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            this.ativo = ativo;
        }
    
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
        public String getEmail() {
            return email;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }
    
        public String getSenha() {
            return senha;
        }
    
        public void setSenha(String senha) {
            this.senha = senha;
        }
    
        public boolean isAtivo() {
            return ativo;
        }
    
        public void setAtivo(boolean ativo) {
            this.ativo = ativo;
        }

        @Override
    public String toString() {
        return "Usuário [id = " + id + ", nome = " + nome + ", email = " + email + ", senha = " + senha + ", ativo =" + ativo + "]";
    }
    }
