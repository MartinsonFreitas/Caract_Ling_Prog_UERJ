package aula_01_09;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// Programa que solicita ao usuario digitar um número positivo
		
		try (Scanner scan = new Scanner(System.in)) {
			int n;
			
			System.out.print("Digite um nùmero positivo: ");
			n = scan.nextInt();
			
			for (int i = 1; i <=n; i=i+1) {
				System.out.println(i);
				
			}
		}
	}

}
