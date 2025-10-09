public class TrabalhadorAssalariado extends Funcionario {

    public TrabalhadorAssalariado(String nome, String cpf) {
        super(nome, cpf);
    }

    public void definirSalario(double salario) {
        this.salario = salario;
    }
}
