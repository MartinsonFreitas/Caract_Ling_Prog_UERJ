package q1;
/* Q1.Crie uma classe chamada Triangulo contendo os três lados como atributos (a, b e c) e os seguintes métodos:
			
	f)​ Crie uma classe de teste para testar a sua classe com os diferentes métodos e situações:
	// Está no Pacote de testes */

public class Triangulo {
		
    private double a, b, c;

    /*	a)​ Método construtor para inicializar o triângulo, desde que seja válido. Obs. Use o método do item b.	 */
    public Triangulo(double a, double b, double c) {
        if (ehValido(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            System.out.println("Triângulo inválido. Os lados fornecidos não formam um triângulo.");
        }
    }

    /* b)​ Método ehValido que retorna verdadeiro se o triângulo é válido (o lado maior deve ser menor que a 
	soma dos outros lados), senão retorna falso. */
    public boolean ehValido(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public String tipoTriangulo() {
        if (!ehValido(a, b, c)) {
            return "Inválido";
        }
        /*c)​ Método tipoTriangulo que retorna o tipo do triângulo. Se possuir os 3 lados iguais, é equilátero.
         * Se possuir apenas 2 lados iguais, é isósceles e se possuir os 3 lados com valores diferentes é escaleno.*/
        if (a == b && b == c) {
            return "Equilátero";
        } else if (a == b || a == c || b == c) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }

    /*d)​ Método calculaPerimetro que retorna o perímetro do triângulo.*/
    public double calculaPerimetro() {
        if (!ehValido(a, b, c)) {
            return 0;
        }
        return a + b + c;
    }

    /*e)​ Método calculaArea que retorna a área do triângulo. A área do triângulo pode ser aproximada pela fórmula de Heron, 
		conforme a Equação abaixo, onde a, b e c são os lados do triângulo e p é o seu semiperímetro (perímetro/2).		
				𝐴𝑟𝑒𝑎 = 𝑝×(𝑝 − 𝑎)×(𝑝 − 𝑏)×(𝑝 − 𝑐)*/
    public double calculaArea() {
        if (!ehValido(a, b, c)) {
            return 0;
        }
        double p = calculaPerimetro() / 2; // Semiperímetro
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
