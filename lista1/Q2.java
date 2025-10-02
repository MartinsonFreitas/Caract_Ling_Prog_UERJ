/***Q2. Crie um programa em Java que leia os 3 lados A, B e C de um triângulo, onde A é o maior lado, 
 * e imprima em qual caso este triângulo se encaixa.**

  * **Se A >= B+C então nenhum triângulo é formado**
  * **Se A² = B²+C², então temos um triângulo retângulo**
  * **Se A² > B²+C² então temos um triângulo obtusângulo**
  * **Se A² < B²+C², então temos um triângulo acutângulo**
 
*/

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os 3 lados do triângulo (A, B e C), onde A é o maior lado:");

        System.out.print("Lado A (o maior): ");
        double ladoA = scanner.nextInt();

        System.out.print("Lado B: ");
        double ladoB = scanner.nextInt();

        System.out.print("Lado C: ");
        double ladoC = scanner.nextInt();

        // Validação
        if (ladoA <= 0 || ladoB <= 0 || ladoC <= 0) {
            System.out.println("Os lados do triângulo devem ser números positivos.");
            scanner.close();
            return;
        }

        // A é realmente o maior lado?
        if (ladoA < ladoB ){
            System.out.println("Atenção: Lado A não é maior que B.");
            System.out.println("Para uma classificação correta, insira o maior lado como A.");            
        } else if (ladoA < ladoC) {
        	System.out.println("Atenção: Lado A não é maior que C.");
            System.out.println("Para uma classificação correta, insira o maior lado como A.");       
        }

        // Calculando os quadrados para as comparações
        double aQuadrado = ladoA * ladoA;
        double bQuadrado = ladoB * ladoB;
        double cQuadrado = ladoC * ladoC;

        System.out.println("\nAnalisando o triângulo com lados A=" + ladoA + ", B=" + ladoB + ", C=" + ladoC + "...");

        // resultado
        if (ladoA >= (ladoB + ladoC)) {
            System.out.println("Nenhum triângulo é formado (A >= B + C).");
        } else if (aQuadrado == (bQuadrado + cQuadrado)) {
            System.out.println("Temos um triângulo retângulo (A² = B² + C²).");
        } else if (aQuadrado > (bQuadrado + cQuadrado)) {
            System.out.println("Temos um triângulo obtusângulo (A² > B² + C²).");
        } else if (aQuadrado < (bQuadrado + cQuadrado)) {
            System.out.println("Temos um triângulo acutângulo (A² < B² + C²).");
        } else {
            System.out.println("Não foi possível classificar o triângulo!");
        }

        scanner.close();
    }
}