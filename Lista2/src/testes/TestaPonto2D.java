package testes;

import q2.*;

public class TestaPonto2D {

	public static void main(String[] args) {
		
        // Teste 1: Construtor default
        Ponto2D p1 = new Ponto2D();
        System.out.println("\n--- Teste 1 (Ponto default) ---");
        System.out.println("Ponto 1: " + p1);

        // Teste 2: Construtor com parâmetros
        Ponto2D p2 = new Ponto2D(3.0, 4.0);
        System.out.println("\n--- Teste 2 (Ponto com parâmetros) ---");
        System.out.println("Ponto 2: " + p2);

        // Teste 3: Calcular distância entre p1 e p2
        System.out.println("\n--- Teste 3 (Distância entre P1 e P2) ---");
        System.out.println("Distância entre P1 e P2: " + p1.calcularDistancia(p2));

        // Teste 4: Calcular distância entre dois pontos arbitrários
        Ponto2D p3 = new Ponto2D(1.0, 1.0);
        Ponto2D p4 = new Ponto2D(4.0, 5.0);
        System.out.println("\n--- Teste 4 (Distância entre P3 e P4) ---");
        System.out.println("Ponto 3: " + p3);
        System.out.println("Ponto 4: " + p4);
        System.out.println("Distância entre P3 e P4: " + p3.calcularDistancia(p4));

        // Teste 5: Distância de um ponto para ele mesmo (deve ser 0)
        System.out.println("\n--- Teste 5 (Distância de P2 para P2) ---");
        System.out.println("Distância de P2 para P2: " + p2.calcularDistancia(p2));
    }

}
