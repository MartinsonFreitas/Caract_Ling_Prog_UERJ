package aula_08_09;

public class Funcoes {
	
	public static void saudacao() {
		System.out.println("Bem-Vindo!");

	}

	public static void mensagem(String texto) {
		System.out.println(texto);
	}
	
	public static int soma(int a, int b) {
		return a + b;		
	}
	public static int divide(int a, int b) {
		int resultado = a/b;
		return resultado;		
	}
	public static long fatorial(int n) {
		int resultado = 1;
		for (int i = 2; i<= n; i++) {
			resultado *=i;			
		}
		return resultado;
	}
	
	// Funçoes Recursivas
	public static int fatorial_rec(int n) {
		if (n == 0) { // caso base
			return 1;
		} else {
			return n*fatorial_rec(n -1);
			}		
		}
	public static int somaDigitos(int n) {
		if(n<10) // caso base
			return n;
		else
			return n%10 + somaDigitos(n/10);
	}
	public static void imprime_rec(int i, int n) {
		if(i<=n) {
			System.out.println(i);
			imprime_rec(i+1, n);
		}		
	}
	public static void imprime(int n) {
		imprime_rec(1, n);
	}
	
	public static void main(String[] args) {
		saudacao();
		mensagem("Olá, tudo bem?");
		int resultado = soma(2,3);
		int n = 5;
		System.out.println("Soma:"+ resultado);
		System.out.println("Divisão:"+ divide(8,3));
		System.out.println("Fatorial de "+n+ " é " + fatorial(n));
		System.out.println("Fatorial recursivo de "+n+" é: " +fatorial_rec(n));
		System.out.println("Soma digitos de 245 é: "+ somaDigitos(245));
		
		imprime(10);
	}

}
