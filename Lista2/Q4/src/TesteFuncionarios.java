public class TesteFuncionarios {
    public static void main(String[] args) {
        // Testando TrabalhadorAssalariado
        TrabalhadorAssalariado assalariado = new TrabalhadorAssalariado("João Silva", "111.222.333-44");
        assalariado.definirSalario(3500.00);
        System.out.println("--- Trabalhador Assalariado ---");
        System.out.println("Nome: " + assalariado.getNome());
        System.out.println("CPF: " + assalariado.getCpf());
        System.out.println("Salário: " + assalariado.getSalario());

        System.out.println();

        // Testando TrabalhadorHorista
        TrabalhadorHorista horista = new TrabalhadorHorista("Maria Souza", "555.666.777-88");
        horista.setValorHora(50.0);
        horista.setHorasTrabalhadasMes(160);
        horista.calcularPagamento();
        System.out.println("--- Trabalhador Horista ---");
        System.out.println("Nome: " + horista.getNome());
        System.out.println("CPF: " + horista.getCpf());
        System.out.println("Valor da Hora: " + horista.getValorHora());
        System.out.println("Horas Trabalhadas no Mês: " + horista.getHorasTrabalhadasMes());
        System.out.println("Salário: " + horista.getSalario());

        System.out.println();

        // Testando TrabalhadorHorista com dados incompletos
        TrabalhadorHorista horistaIncompleto = new TrabalhadorHorista("Carlos Lima", "999.888.777-66");
        horistaIncompleto.setValorHora(0);
        horistaIncompleto.setHorasTrabalhadasMes(100);
        horistaIncompleto.calcularPagamento();
        System.out.println("--- Trabalhador Horista (Dados Incompletos) ---");
        System.out.println("Nome: " + horistaIncompleto.getNome());
        System.out.println("CPF: " + horistaIncompleto.getCpf());
        System.out.println("Salário: " + horistaIncompleto.getSalario());
    }
}
