package aula_04_09;

public class ExemplosString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nome = "Martinson";
		String sobrenome = "Lima de Freitas";
		String nomeCompleto = "     "+nome + " " +sobrenome+"      ";
		String maiuscula = nomeCompleto.toUpperCase();
		String minuscula = nomeCompleto.toLowerCase();
		
		String frase = "Aqui temos, uma frase";
		String[] palavras = frase.split(",");
		
		int tamanho = nome.length() + sobrenome.length();
		char caractere = nome.charAt(3);
		String parte1 = nome.substring(2);
		String parte2= nome.substring(2,4);
		
		System.out.println("Nome: "+ nome);
		System.out.println("Sobrenome: "+ sobrenome);
		System.out.println("Nome completo: "+ nome + " " + sobrenome);
		System.out.println("Igual: "+nome.equals(sobrenome));
		System.out.println("Parte 1: "+ parte1);
		System.out.println("Tamanho: "+ tamanho);
		System.out.println("Caractere: "+ caractere);
		System.out.println("Parte 1: "+ parte1);
		System.out.println("Parte 2: "+ parte2);
		System.out.println("Minuscula: "+ minuscula);
		System.out.println("Maiscula: "+maiuscula);
		System.out.println("Nome completo: "+ nomeCompleto.trim());
		System.out.println("Replace: "+nomeCompleto.trim().replace("i", "a"));
		System.out.println("Irmãos: "+nomeCompleto.trim().replace("Martinson", "Marcio"));
		System.out.println("Irmãos: "+nomeCompleto.trim().replace("Martinson", "Marcus Vinicius"));
		System.out.println("Palavra1: "+ palavras[0]);
		System.out.println("Palvra2: "+ palavras[1]);
		
		for (String p : palavras) {
			System.out.println(p);
		}
		
		String linhaCsv = "João,Doe,30,Nova York";
		String[] dados = linhaCsv.split(",");
		
		System.out.println("Nome: "+ dados[0] +" "+ dados[1]);
		System.out.println("Idade: "+ dados[2]);
		System.out.println("Cidade: "+ dados[3]);
		
		System.out.println("Pesquisa: "+nome.indexOf("u"));// retorna -1 se não encontra o caracter
		
		String x = "abc";
		String y = "abd";
		int comparacao = x.compareTo(y);
		System.out.println("Comparação: "+ comparacao);
		System.out.println("Comparação: "+ nome.compareTo(nome));// retorna 0 pq são iguais
		System.out.println("Comparação: "+ sobrenome.compareTo(nome));// retorna -1 pq sobrenome > nome
		System.out.println("Comparação: "+ nome.compareTo(sobrenome));// retorna 1 pq nome < sobrenome
	}

}
