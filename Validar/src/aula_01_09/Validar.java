package aula_01_09;

import java.util.Scanner;

public class Validar {

	public static void main(String[] args) {
		// Programa que solicita ao usuario digitar um número positivo
		
		try (Scanner scan = new Scanner(System.in)) {
			int idade;
			
			do {
				System.out.print("Digite sua idade: ");
				idade= scan.nextInt();
			} while(idade < 16 || idade > 65);
			
			System.out.println("Idade digitada: " + idade);
		}

	}

}
