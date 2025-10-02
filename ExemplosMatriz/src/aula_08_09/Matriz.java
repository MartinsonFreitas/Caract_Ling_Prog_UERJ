package aula_08_09;

public class Matriz {
	public static void main(String[] args) {
		int [][] dados = {
							{1,2,3,4},
							{5,6,7,8},
							{9,10,11,12}
						};
		// imprimir
		System.out.println("Linhas: "+ dados.length);
		System.out.println("Colunas: "+ dados[0].length);
		
		for (int i = 0; i < dados.length; i++) {
			for (int j = 0; j < dados[0].length; j++) {
				System.out.print(dados[i][j]+" ");
			}
			
			System.out.println();
		}
	}

}
