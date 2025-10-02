package aula_08_09;

import java.util.Scanner;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Digite o tamanho do array: ");
		int n = scan.nextInt();
		int[] numeros = new int[n];
		
		System.out.println("Digite os "+n+ " elementos do array");
		// entrada de dados
		for (int i = 0; i < numeros.length; i++) {
			System.out.print("Digite um valor: ");
			numeros[i] = scan.nextInt();			
		}
		
		// exibe o array
		System.out.println("Elementos do Array: ");
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i]+ " ");
		}
		scan.close();
	}

}
