package q4;

/*a)​ Crie uma classe TrabalhadorAssalariado e outra TrabalhadorHorista, ambas herdando de
Funcionario
*/
public class TrabalhadorAssalariado extends Funcionario {

    public TrabalhadorAssalariado(String nome, String cpf) {
        super(nome, cpf);
    }
    
/*b)​ A classe TrabalhadorAssalariado possui o método definirSalario(salario) que recebe um valor
como parâmetro e o atribui ao atributo salario.*/
    public void definirSalario(double salario) {
        this.salario = salario;
    }
}