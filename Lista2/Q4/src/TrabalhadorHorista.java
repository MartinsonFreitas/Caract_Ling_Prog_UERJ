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

    public void calcularPagamento() {
        if (valorHora > 0 && horasTrabalhadasMes > 0) {
            this.salario = valorHora * horasTrabalhadasMes;
        } else {
            System.out.println("Aviso: Valor da hora ou horas trabalhadas não preenchidos para calcular o salário.");
            this.salario = 0;
        }
    }
}
