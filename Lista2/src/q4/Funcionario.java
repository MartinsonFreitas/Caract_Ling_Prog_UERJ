package q4;

/* Q4. Crie uma classe Funcionario com os atributos privados nome, cpf e salario; e um
construtor que deve receber como parâmetro nome e cpf. Todos os atributos devem ter propriedades
(getters) definidos.

// No pacote "testes"
e)​ Crie uma classe de teste e no método main crie instâncias de cada uma das classes e invoque
os métodos implementados. * 
 */

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