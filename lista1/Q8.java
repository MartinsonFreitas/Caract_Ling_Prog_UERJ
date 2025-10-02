/*
 * 
 * Q8. Considerando a questão Q7 faça um simulador que receba como entrada a quantia inicial investida, taxa de juros (permitindo escolher entre anual e mensal), 
 * aporte mensal (valor de capitalização) e período (em anos e meses) e gere um relatório comparativo entre os rendimentos do investimento e a 
 * poupança (considere taxa de juros de 0.5). Dado um valor objetivo e um aporte inicial, 
 * determine o tempo necessário que a pessoa necessita para chegar lá.
 * 
 * 
 */


import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class Q8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Usado para formatar a saída de valores monetários
        //DecimalFormat df = new DecimalFormat("R$ #,##0.00");

        System.out.println("Bem-vindo ao Simulador de Investimentos!");

        // --- Entrada de Dados ---
        System.out.print("1. Quantia inicial investida (R$): ");
        double principal = scanner.nextDouble();

        System.out.print("2. Taxa de juros do investimento (ex: 0,05 para 5%): ");
        double taxaInvestimento = scanner.nextDouble();

        System.out.print("   O tipo da taxa de juros é (A)nual ou (M)ensal? (A/M): ");
        String tipoTaxa = scanner.next().toUpperCase();

        System.out.print("3. Aporte mensal (R$): ");
        double aporteMensal = scanner.nextDouble();

        System.out.print("4. Período de investimento (anos): ");
        int anos = scanner.nextInt();

        System.out.print("   Período de investimento (meses adicionais): ");
        int mesesAdicionais = scanner.nextInt();

        // --- Validação Inicial ---
        if (principal < 0 || taxaInvestimento < 0 || aporteMensal < 0 || anos < 0 || mesesAdicionais < 0) {
            System.out.println("Erro: Valores inválidos!");
            scanner.close();
            return;
        }
        if (!tipoTaxa.equals("A") && !tipoTaxa.equals("M")) {
            System.out.println("Erro: Tipo de taxa inválido!");
            scanner.close();
            return;
        }

        int totalMeses = (anos * 12) + mesesAdicionais;

        // --- Converter taxa anual para mensal se necessário ---
        double taxaMensalInvestimento = taxaInvestimento;
        if (tipoTaxa.equals("A")) {
            taxaMensalInvestimento = Math.pow((1 + taxaInvestimento), (1.0 / 12.0)) - 1;
            System.out.printf("\nTaxa anual de investimento convertida para mensal: %.4f%%\n", (taxaMensalInvestimento * 100));
        }
        
        // Taxa da poupança (fixa em 0.5% mensal = 0.005)
        double taxaPoupanca = 0.005; 
        System.out.printf("Taxa de juros da poupança (mensal): %.2f%%\n", (taxaPoupanca * 100));

        // --- Calcular Rendimentos ---
        System.out.println("\n--- Relatório de Rendimentos ao longo de " + anos + " anos e " + mesesAdicionais + " meses ---");
        
        double saldoInvestimento = calcularRendimentoComAportes(principal, taxaMensalInvestimento, aporteMensal, totalMeses);
        System.out.printf("Saldo final do seu investimento: R$  %.2f\n", saldoInvestimento);

        double saldoPoupanca = calcularRendimentoComAportes(principal, taxaPoupanca, aporteMensal, totalMeses);
        System.out.println("Saldo final na poupança (0.5% a.m.): R$  " + saldoPoupanca);

        // --- Determinar Tempo para o Objetivo ---
        System.out.print("\n5. Deseja determinar o tempo para atingir um valor objetivo? (S/N): ");
        String respostaObjetivo = scanner.next().toUpperCase();

        if (respostaObjetivo.equals("S")) {
            System.out.print("6. Digite o valor objetivo (R$): ");
            double valorObjetivo = scanner.nextDouble();

            if (valorObjetivo <= principal) {
                System.out.println("O valor objetivo deve ser maior que o valor inicial investido.");
            } else {
                determinarTempoParaObjetivo(principal, taxaMensalInvestimento, aporteMensal, valorObjetivo);
            }
        }

        scanner.close();
    }

    
     // Calcula o rendimento final com aportes mensais.    
    public static double calcularRendimentoComAportes(double principal, double taxaMensal, double aporteMensal, int numMeses) {
        double saldoAtual = principal;
        for (int i = 0; i < numMeses; i++) {
            saldoAtual = (saldoAtual + aporteMensal) * (1 + taxaMensal);
        }
        return saldoAtual;
    }

    // Determina o tempo para atingir objetivo.     
    public static void determinarTempoParaObjetivo(double principal, double taxaMensal, double aporteMensal, double valorObjetivo) {
        double saldoAtual = principal;
        int mesesNecessarios = 0;
        
        // Evita loop infinito se a taxa for 0 e o aporte não for suficiente ou se o objetivo nunca for atingido
        if (taxaMensal == 0 && aporteMensal == 0 && principal < valorObjetivo) {
            System.out.println("Com taxa de juros zero e sem aportes, o objetivo nunca será alcançado.");
            return;
        }
        if (taxaMensal == 0 && (principal + aporteMensal * (valorObjetivo - principal) / aporteMensal) < valorObjetivo) { // Se aporte mensal for 0, mas objetivo ainda não é atingido
             if (aporteMensal == 0 && principal < valorObjetivo) {
                 System.out.println("Com taxa de juros zero e sem aportes, o objetivo nunca será alcançado.");
                 return;
             }
        }

        System.out.println("\n--- Tempo estimado para atingir o objetivo R$ " + valorObjetivo + " ---");

        if (principal >= valorObjetivo) {
            System.out.println("O valor inicial (R$ " + principal + ") já é maior ou igual ao valor objetivo.");
            return;
        }

        // Loop para simular mês a mês até atingir o objetivo
        while (saldoAtual < valorObjetivo) {
            mesesNecessarios++;
            // Calcula o saldo para o próximo mês
            saldoAtual = (saldoAtual + aporteMensal) * (1 + taxaMensal);

            // Adiciona uma trava para evitar loops infinitos em cenários onde o objetivo é inatingível
            if (mesesNecessarios > 1200) { // Limite de 100 anos
                System.out.println("Parece que levará muito tempo para atingir o objetivo, ou ele pode ser inatingível com os parâmetros dados.");
                System.out.println("Saldo após 100 anos: R$ " + saldoAtual);
                return;
            }
        }

        int anosNecessarios = mesesNecessarios / 12;
        int mesesRestantes = mesesNecessarios % 12;

        System.out.println("Tempo necessário para atingir R$ " + valorObjetivo + ":");
        System.out.println(mesesNecessarios + " meses (aproximadamente " + anosNecessarios + " anos e " + mesesRestantes + " meses).");
        System.out.println("Saldo final atingido: R$ " + saldoAtual);
    }
}
