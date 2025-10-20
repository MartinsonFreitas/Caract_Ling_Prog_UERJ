package q3;

/*Retângulo:
•​ Área = base*altura,
•​ Perímetro = 2*base + 2*altura*/

public class Retangulo implements FormaGeometrica {
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * base + 2 * altura;
    }

    @Override
    public double calcularVolume() {
        return 0; // Retângulo é 2D, não tem volume
    }

    @Override
    public String toString() {
        return "Retângulo [base=" + base + ", altura=" + altura + "]";
    }
}