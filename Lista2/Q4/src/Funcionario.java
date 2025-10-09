public class Funcionario {
    private String nome;
    private String cpf;
    protected double salario; // Usar protected para acesso pelas subclasses

    public Funcionario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }
}
