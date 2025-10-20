package q3;

/*Caixa:
•​ Volume = base1*base2*altura,
•​ Área = 2*(base1*base2 + base1*altura + base2*altura)*/

public class Caixa implements FormaGeometrica {
    private double base1;
    private double base2;
    private double altura;

    public Caixa(double base1, double base2, double altura) {
        this.base1 = base1;
        this.base2 = base2;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return 2 * (base1 * base2 + base1 * altura + base2 * altura);
    }

    @Override
    public double calcularPerimetro() {
        return 0; // Caixa é 3D, não tem perímetro 2D
    }

    @Override
    public double calcularVolume() {
        return base1 * base2 * altura;
    }

    @Override
    public String toString() {
        return "Caixa [base1=" + base1 + ", base2=" + base2 + ", altura=" + altura + "]";
    }
}