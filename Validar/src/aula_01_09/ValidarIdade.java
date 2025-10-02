package aula_01_09;

import java.util.Scanner;

public class ValidarIdade {

	public static void main(String[] args) {
		// Programa que solicita ao usuario digitar um número positivo
		
		try (Scanner scan = new Scanner(System.in)) {
			int numero= -1;
			
			while(numero < 0) {
				System.out.println("Digite um número: ");
				numero = scan.nextInt();
			}
			
			System.out.println("Número digitado: " + numero);
		}

	}

}
