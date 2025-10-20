package testes;

import java.text.DecimalFormat;

import q3.*;

/*Q3. Considere os seguintes objetos geométricos: retângulo, caixa, círculo e cilindro. Cada
objeto geométrico deve possuir métodos para obter seu perímetro (figuras 2D), sua área (externa, no
caso das 3D) e volume (figuras 3D). 

Crie um diagrama de classes que modele objetos geométricos de forma a aproveitar ao máximo suas características comuns. 
Depois implemente em Java o modelo criado. 

As classes devem possuir construtores parametrizados, os quais devem ser utilizados para
inicialização dos atributos dos objetos. 

 inalmente crie uma classe de teste que instancie objetos das classes e invoque as funcionalidades implementadas.
*/
public class TesteFormasGeometricas {
    public static void main(String[] args) {
    	
    	// Formatando o resultado para duas casas decimais
    	DecimalFormat df = new DecimalFormat("#.##");
    	//String numeroFormatado = df.format(numero);
    	
        Retangulo retangulo = new Retangulo(10, 5);
        Caixa caixa = new Caixa(10, 5, 3);
        Circulo circulo = new Circulo(7);
        Cilindro cilindro = new Cilindro(4, 10);

        System.out.println("--- Retângulo ---");
        System.out.println(retangulo);
        System.out.println("Área: " + retangulo.calcularArea());
        System.out.println("Perímetro: " + retangulo.calcularPerimetro());
        System.out.println("Volume: " + df.format(retangulo.calcularVolume()));

        System.out.println("\n--- Caixa ---");
        System.out.println(caixa);
        System.out.println("Área: " + caixa.calcularArea());
        System.out.println("Perímetro: " + caixa.calcularPerimetro());
        System.out.println("Volume: " + df.format(caixa.calcularVolume()));

        System.out.println("\n--- Círculo ---");
        System.out.println(circulo);
        System.out.println("Área: " + circulo.calcularArea());
        System.out.println("Perímetro: " + circulo.calcularPerimetro());
        System.out.println("Volume: " + df.format(circulo.calcularVolume()));

        System.out.println("\n--- Cilindro ---");
        System.out.println(cilindro);
        System.out.println("Área: " + cilindro.calcularArea());
        System.out.println("Perímetro: " + cilindro.calcularPerimetro());
        System.out.println("Volume: " + df.format(cilindro.calcularVolume()));
    }
}