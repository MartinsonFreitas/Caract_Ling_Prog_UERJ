package aula_25_08;

import java.util.Scanner;

public class VerificacaoVoto {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digite a usa idade: ");
		int idade = scanner.nextInt();
		
		if (idade>= 16) {
			if (idade >= 18 && idade <= 70) {
				System.out.println("Voto obrigatório");
			} else {
				System.out.println("Voto Facultativo");
			}
		
		} else {
			System.out.println("Não tem idade para votar!");
		}
		
		scanner.close();
	}

}
