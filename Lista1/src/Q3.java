/*
 * Q3. Uma empresa de fornecimento de água resolveu incentivar a economia de água mudando a tabela de cobrança, 
 * de forma que proporcionalmente, os clientes que consumirem menos água paguem menos pelo metro cúbico. 
 * Todo cliente paga mensalmente uma assinatura de R$ 7,00, que inclui uma franquia de 10 m³ de água. 
 * Isso significa que para qualquer consumo entre 0 e 10 m³, o consumidor paga a mesma quantia de R$ 7,00 
 * (note que o valor da assinatura deve ser pago mesmo que o consumidor não tenha consumido água). 
 * Acima de 10 m³. cada metro cúbico subsequente tem um valor diferente, dependendo da faixa de consumo. 
 * A tabela a seguir especifica o preço por metro cúbico para cada faixa de consumo:

					| Faixa de consumo (m³) | Preço (por m³)       |
					| :-------------------- | :------------------- |
					| até 10                | incluído na franquia |
					| 11 a 30               | R$1,00               |
					| 31 a 100              | R$2,00               |
					| 101 em diante         | R$5,00               |

			** Assim, por exemplo, se o consumo foi de 120 m³, o valor da conta é:**  
			** R$ 7,00 da assinatura básica;**  
			** R$ 20,00 pelo consumo no intervalo de 11 a 30 m³;**  
			** R$ 140,00 pelo consumo no intervalo de 31 a 100 m³;**  
			** R$ 100,00 pelo consumo no intervalo de 101 a 120 m³.**  
			** Logo, o valor total da conta de água é R$ 267,00.**

**Escreva um programa em Java que receba como entrada o consumo de água de uma residência em m³. 
*calcule e imprima o valor da conta de água daquela residência.
*
		**Exemplo de entrada/saída: 250/R$917,00
		**Exemplo de entrada/saída: 99/R$165,00

*/ 

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o consumo de água em m³: ");
        int consumo = scanner.nextInt();

        // Validação
        if (consumo < 0) {
            System.out.println("O consumo de água não pode ser negativo.");
            scanner.close();
            return;
        }

        // Assinatura básica
        double valorTotal = 7.00; 

        System.out.println("\nCalculando a conta para consumo de " + consumo + " m³:");
        System.out.printf("Assinatura básica (franquia até 10m³): R$%.2f\n", 7.00);

        if (consumo > 10) {
            int consumoRestante = consumo - 10; // Consumo após a franquia

            // Faixa de 11 a 30 m³ (20 m³ nesta faixa)
            if (consumoRestante > 0) {
                int consumoNestaFaixa = Math.min(consumoRestante, 20); // Mínimo entre o restante e o limite da faixa
                double valorFaixa = consumoNestaFaixa * 1.00;
                valorTotal += valorFaixa;
                System.out.printf("Consumo de 11 a 30 m³ (%d m³ @ R$1,00/m³): R$%.2f\n", consumoNestaFaixa, valorFaixa);
                consumoRestante -= consumoNestaFaixa;
            }

            // Faixa de 31 a 100 m³ (70 m³ nesta faixa)
            if (consumoRestante > 0) {
                int consumoNestaFaixa = Math.min(consumoRestante, 70); // Mínimo entre o restante e o limite da faixa
                double valorFaixa = consumoNestaFaixa * 2.00;
                valorTotal += valorFaixa;
                System.out.printf("Consumo de 31 a 100 m³ (%d m³ @ R$2,00/m³): R$%.2f\n", consumoNestaFaixa, valorFaixa);
                consumoRestante -= consumoNestaFaixa;
            }

            // Faixa de 101 m³ em diante
            if (consumoRestante > 0) {
                double valorFaixa = consumoRestante * 5.00;
                valorTotal += valorFaixa;
                System.out.printf("Consumo de 101 m³ em diante (%d m³ @ R$5,00/m³): R$%.2f\n", consumoRestante, valorFaixa);
            }
        } else {
            System.out.println("Consumo dentro da franquia (0 a 10 m³).");
        }

        System.out.printf("\nO valor total da conta de água é: R$%.2f\n", valorTotal);

        scanner.close();
    }
}