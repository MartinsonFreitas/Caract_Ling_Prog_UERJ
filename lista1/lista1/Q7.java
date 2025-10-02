/*
 * **Q7. Crie uma função para calcular os juros compostos de um investimento. 
 * 
 * Uma pessoa investe uma quantidade (em reais) em uma conta que rende uma taxa de juros ao ano. 
 * Admitindo que todos os juros são deixados em depósito na conta, crie uma função que calcule e 
 * imprima a quantia na conta ao final de cada ano, ao longo de n anos. 
 * 
 * Use a seguinte fórmula para determinar estas quantias: a=p(1+r)^n**  
		**Onde:**  
		*
			**p é a quantia investida originalmente (i.e., o valor principal)**  
			**r é a taxa anual de juros.**  
			**n é o número de anos**  
			**a é a quantia existente em depósito no final do n-ésimo ano**  
			
			
		**Exemplo de saída para R$1000,00 em 10 anos e 5% (0.05) de juros ao ano**  
		*
		**Ano Saldo na conta**  
			**1 1050.00**  
			**2 1102.50**  
			**3 1157.62**  
			**4 1215.51**  
			**5 1276.28**  
			**6 1340.10**  
			**7 1407.10**  
			**8 1477.46**  
			**9 1551.33**  
			**10 1628.89**
*/

import java.util.Scanner;
import java.lang.Math; // Para usar Math.pow

public class Q7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantia investida: R$ ");
        double principal = scanner.nextDouble();

        System.out.print("Digite a taxa anual de juros: ");
        double taxaJuros = scanner.nextDouble();

        System.out.print("Digite o número de anos de investimento: ");
        int numeroAnos = scanner.nextInt();

        // Validação
        if (principal <= 0 || taxaJuros < 0 || numeroAnos <= 0) {
            System.out.println("Por favor, insira valores válidos!");
            scanner.close();
            return;
        }

        System.out.println("\nCalculando...");
        System.out.println("");
        
        calcularJurosCompostos(principal, taxaJuros, numeroAnos);
        scanner.close();
    }
    
    public static void calcularJurosCompostos(double p, double r, int n) {
        System.out.println("Ano\tSaldo na conta");
        System.out.println("--------------------");        

        for (int ano = 1; ano <= n; ano++) {
            // a = p * (1 + (r/100))^n
            double montante = p * Math.pow((1 + (r/100)), ano);
            System.out.printf("%d\t%.2f\n", ano, montante);
        }
    }
}
