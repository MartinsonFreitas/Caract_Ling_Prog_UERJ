/* 
 * Q5. Escreva um programa (usando o comando for) que exiba o seguinte padrão quadriculado**  

			* * * * *  
			 * * * * *  
			* * * * *  
			 * * * * *  
			* * * * *

*/

import java.util.Scanner;

public class Q5 {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de linhas (n) para o triângulo: ");
        int tamanhoLado = scanner.nextInt();

        //int tamanhoLado = 5; 

        System.out.println("Imprimindo quadriculado " + tamanhoLado + "x" + tamanhoLado + ":");
        System.out.println(""); 

        for (int i = 0; i < tamanhoLado; i++) {       	
           
            for (int j = 0; j < tamanhoLado; j++) {
            	
            	if (i%2==0) {
            	
            		System.out.print("* "); 
            	} else {
            		System.out.print(" *"); 
            	}
                
            }
            
            System.out.println(); 

        }
    }
}