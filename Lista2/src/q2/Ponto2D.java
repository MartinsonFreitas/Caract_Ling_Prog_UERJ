package q2;

/*Q2. Escreva uma classe Ponto2D que represente um ponto no plano cartesiano com atributos x, y para as coordenadas do ponto. 
 * A classe deve oferecer os seguintes métodos:
 * 
		// Encontra-se no pacote "testes"
		c)​ Crie uma classe de teste para testar a sua classe com os diferentes métodos e situações:
*/

public class Ponto2D {
	/*a)​ Construtores que permitam a inicialização do ponto:
		i.​ Por default (sem parâmetros) na origem do espaço 2D;
		ii.​ Num local indicado por dois parâmetros (indicando o valor de abcissa e ordenada do ponto que está sendo criado);*/
    private double abcissa;
    private double ordenada;

    // Construtor default (i)
    public Ponto2D() {
        this(0.0, 0.0);
    }

    // Construtor com parâmetros (ii)
    public Ponto2D(double x, double y) {
        this.abcissa = x;
        this.ordenada = y;
    }

    public double getX() {
        return abcissa;
    }

    public double getY() {
        return ordenada;
    }

    /*b)​ Método que permita calcular a distância euclidiana de um ponto com outro, definido pela expressão abaixo:
		Sejam os pontos P1(x1, y1) e P2(x2,y2), a distância euclidiana está dado por:
		𝑑= sqrt((𝑥2 − 𝑥1)^2 + (𝑦2 − 𝑦1)^2)*/
    public double calcularDistancia(Ponto2D outroPonto) {
        double deltaX = this.abcissa - outroPonto.getX();
        double deltaY = this.ordenada - outroPonto.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public String toString() {
        return "(" + abcissa + ", " + ordenada + ")";
    }

}
