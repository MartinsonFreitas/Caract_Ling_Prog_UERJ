package aula_01_09;

import java.util.Scanner;

public class ExemploFor {

	public static void main(String[] args) {
		// Programa que solicita ao usuario digitar um número positivo
		
		try (Scanner scan = new Scanner(System.in)) {
			int opcao;
			
			do {
				System.out.println("#### MENU ####");
				System.out.println("1 - Abrir Arquivo");
				System.out.println("2 - Salvar Arquivo");
				System.out.println("3 - Sair");
				System.out.println("Escolha uma opção: ");
				opcao = scan.nextInt();
			} while(opcao < 1 || opcao > 3);
				
			switch(opcao) {
			
			case 1 :
				System.out.println("Abrindo arquivo...");
				break;
			case 2 :
				System.out.println("Salvando Arquivo...");
				break;
			case 3:
				System.out.println("Encerrando Programa...");
				break;
							
			}
		}
		

	}

}
