package q4;

/* c)​ A classe TrabalhadorHorista possui os atributos privados valorHora e horasTrabalhadasMes,
com seus respectivos métodos de acesso (getters e setters). */

public class TrabalhadorHorista extends Funcionario {
    private double valorHora;
    private double horasTrabalhadasMes;

    public TrabalhadorHorista(String nome, String cpf) {
        super(nome, cpf);
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getHorasTrabalhadasMes() {
        return horasTrabalhadasMes;
    }

    public void setHorasTrabalhadasMes(double horasTrabalhadasMes) {
        this.horasTrabalhadasMes = horasTrabalhadasMes;
    }
    
    /*d)​ A classe TrabalhadorHorista também possui o método calcularPagamento(), que ao ser
	invocado deve calcular o valor do salário e preencher este atributo. O salário é obtido
	multiplicando-se as horas trabalhadas no mês pelo valor da hora. Crie validações que verifiquem
	se os atributos necessários para o cálculo do salário estão preenchidos. Se não estiverem, emita
	um aviso.*/

    public void calcularPagamento() {
        if (valorHora > 0 && horasTrabalhadasMes > 0) {
            this.salario = valorHora * horasTrabalhadasMes;
        } else {
            System.out.println("Aviso: Valor da hora ou horas trabalhadas não preenchidos para calcular o salário.");
            this.salario = 0;
        }
    }
}