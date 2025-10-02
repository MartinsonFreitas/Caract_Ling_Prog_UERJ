package teste;
import java.util.Scanner;

import contas.*;

public class TestaConta {
	
	public static void menu()	{
		System.out.println("Que tipo de Conta deseja criar?");
		System.out.println("1 - Conta Corrente");
		System.out.println("2 - Conta Especial");
		System.out.println("3 - Conta Poupança");
	}
	
	public static void main(String[] args) {
		Conta c = null;
		Scanner scan = new Scanner(System.in);
		menu();
		int opcao = scan.nextInt();
		switch (opcao) {
		case 1:
			c = new Conta(1, "João");
			break;
		case 2:
			c = new ContaEspecial(1, "João",200);
			break;
		case 3:
			c = new ContaPoupanca(1, "João");
			break;
	}
		
	c.imprimirTipoConta();
	c.imprimirTipoConta("Seja bem-vindo ao nosso Banco");
	c.imprimirTipoConta("Seu dinheiro está seguro conosco!!!");
	
	// usando instanceof
	/*if (c instanceof Conta) {
		System.out.println("Criei um conta corrente");
	} else if(c instanceof ContaEspecial){
		System.out.println("Criei uma Conta Especial");
	} else if(c instanceof ContaPoupanca) {
		System.out.println("Criei uma Conta Poupança");
	} else {
		System.out.println("Conta não aberta!");
	}*/

	System.out.println(c);
	
	/*
	Conta c1 = new Conta(1, "João");
	c1.deposita(100);
	System.out.println(c1);
	
	ContaEspecial c2 = new ContaEspecial(2, "Maria", 200);
	c2.saca(50);
	System.out.println(c2);
	
	ContaPoupanca c3 = new ContaPoupanca(3, "Carlos");
	c3.deposita(500);
	c3.reajustar(0.1);
	System.out.println(c3);*/
	
	scan.close();

	}
}
