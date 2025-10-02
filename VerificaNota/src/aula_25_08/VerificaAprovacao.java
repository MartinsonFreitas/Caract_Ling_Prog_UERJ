package aula_25_08;

import java.util.Scanner;

public class VerificaAprovacao {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double NF = 0;
		
		System.out.print("Digite a nota da Prova da P1: ");
		int P1 = scanner.nextInt();
		
		System.out.print("Digite a nota da Lista de Exercícios da P1: ");
		int LEP1 = scanner.nextInt();
		
		double NFP1 = ((P1 * 0.7) + (LEP1 * 0.3));
		
		System.out.print("Digite a nota da Prova da P2: ");
		int P2 = scanner.nextInt();
		
		System.out.print("Digite a nota da Lista de Exercícios da P2: ");
		int LEP2 = scanner.nextInt();
		
		double NFP2= ((P2 * 0.7) + (LEP2 * 0.3));
		
		System.out.print("Digite a nota do Projeto Final: ");
		int T = scanner.nextInt();
		
		double MF = ((NFP1 + NFP2)/2 * 0.6) + (T * 0.4);
		System.out.println("Nota final"+ MF);
		
		if (MF < 7) {
			if (MF >= 3 && MF < 7) {
				System.out.println("Necessário Prova Final...");
				System.out.print("Digite a nota do Prova Final: ");
				int NPF = scanner.nextInt();
				NF = (MF + NPF )/2;
				
			} else {
				System.out.println("Reprovado!");
			}
		
		} else {
			System.out.println("Nota final"+ MF);
			NF = MF;
		}
		
		System.out.print("Digite a Frequencia do aluno: ");
		int Frequencia = scanner.nextInt();
		
		//Os alunos que alcançarem nota final (Nf ) igual ou superior a 5.0 e 
		//frequência mínima de 75% serão aprovados.
		
		if (NF >= 5 && Frequencia >= 75) {
			System.out.println("Aluno Aprovado!");
		} else {
			System.out.println("Aluno Reprovado!");
		}
		
		scanner.close();
	}

}
