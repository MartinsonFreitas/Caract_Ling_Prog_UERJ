package negocio;

public class Contato {
    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String celular;
    private String tipo;

    public Contato(int id, String nome, String sobrenome, String email, String celular, String tipo) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.celular = celular;
        this.tipo = tipo;
    }

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getSobrenome() { return sobrenome; }
    public String getEmail() { return email; }
    public String getCelular() { return celular; }
    public String getTipo() { return tipo; }

    // Setters
    public void setNome(String nome) { this.nome = nome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public void setEmail(String email) { this.email = email; }
    public void setCelular(String celular) { this.celular = celular; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        return String.format("%d,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"",
                id, nome, sobrenome, email, celular, tipo);
    }
}
