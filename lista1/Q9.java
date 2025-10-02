/*
 * Q9. Escreva uma função em Java que recebe um array de inteiros e um valor inteiro x como parâmetros. 
 * A função deve encontrar o primeiro par de elementos consecutivos no array cuja soma seja igual a x. 
 * 
 * A função deve imprimir os índices dos elementos encontrados ou indicar se nenhum par foi encontrado.

			**Exemplo 1: Array:, x: 12**  
			**Saída esperada: "Par encontrado: 7 (índice 2) + 5 (índice 3)"**
			
			**Exemplo 2: Array:, x: 10**  
			**Saída esperada: "Nenhum par consecutivo encontrado."**

*/

import java.util.Scanner;

public class Q9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite os elementos do array separados por espaço: ");
        String linhaArray = scanner.nextLine();
        String[] elementosStr = linhaArray.trim().split("\\s+"); 

        int[] arrayDeInteiros;
        try {
            arrayDeInteiros = new int[elementosStr.length];
            for (int i = 0; i < elementosStr.length; i++) {
                arrayDeInteiros[i] = Integer.parseInt(elementosStr[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Entrada inválida!");
            scanner.close();
            return;
        }

        System.out.print("Digite o valor de X que você deseja encontrar a soma: ");
        int x = scanner.nextInt();

        // Chama a função para encontrar o par
        encontrarParConsecutivo(arrayDeInteiros, x);

        scanner.close();
    }

     // Encontra e imprime o primeiro par 
    public static void encontrarParConsecutivo(int[] arr, int x) {
        
        for (int i = 0; i < arr.length - 1; i++) {
            
            if (arr[i] + arr[i+1] == x) {
                System.out.println("Par encontrado: " + arr[i] + " (índice " + i + ") + " + arr[i+1] + " (índice " + (i+1) + ")");
                return; 
            }
        }

        System.out.println("Nenhum par consecutivo encontrado.");
    }
}
