/*
* Q4. Crie um programa (usando o comando while) que imprima um triângulo usando \*. 
* Exemplo, para n=5 a saída deve ser:
* 
		*  
		**  
		***  
		****
		*****
*/

import java.util.Scanner;

public class Q4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de linhas (n) para o triângulo: ");
        int n = scanner.nextInt();

        // Validação 
        if (n <= 0) {
            System.out.println("Digite um número positivo.");
            scanner.close();
            return;
        }

        int linha = 1;

        System.out.println("\nImprimindo " + n + " linhas:");

        while (linha <= n) {
            int asteriscosNaLinha = 1; 
      
            while (asteriscosNaLinha <= linha) {
                System.out.print("*");
                asteriscosNaLinha++;
            }
            System.out.println();
            linha++;
        }

        scanner.close();
    }
}

