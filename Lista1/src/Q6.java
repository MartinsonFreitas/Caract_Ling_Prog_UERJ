/*
 * *Q6. Escreva um programa que chame uma função que receba um número inteiro positivo como argumento e 
 * verifique se é um número perfeito. Um número perfeito é aquele que é igual à soma de seus divisores próprios 
 * (excluindo ele mesmo). Exemplos de números perfeitos O número 6 é um número perfeito, 
 * pois a soma de seus divisores próprios (1, 2, 3) é igual a ele mesmo: 1+2+3=6. O número 28 é um número perfeito, 
 * pois a soma de seus divisores próprios (1, 2, 4, 7, 14) é igual a ele mesmo: 1+2 +4+7+14=28
 * 
*/


import java.util.Scanner;

public class Q6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();

        // Validação
        if (numero <= 0) {
            System.out.println("Por favor, insira um número válido.");
            scanner.close();
            return;
        }

        // Chama a função
        if (isNumeroPerfeito(numero)) {
            System.out.println(numero + " É um número perfeito!");
        } else {
            System.out.println(numero + " NÃO é um número perfeito.");
        }

        scanner.close();
    }

    
     // Verifica se um número é perfeito.
    public static boolean isNumeroPerfeito(int num) {
        if (num == 1) { // 1 não é número perfeito
            return false;
        }

        int somaDivisores = 1; // Começa com 1

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                somaDivisores += i; // Adiciona 'i' à soma

                // Se 'i' não é a raiz, também é um divisor
                if (i * i != num) {
                    somaDivisores += (num / i);
                }
            }
        }
        
        return somaDivisores == num;
    }
}