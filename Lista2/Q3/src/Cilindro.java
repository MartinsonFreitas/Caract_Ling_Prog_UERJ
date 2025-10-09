public class Cilindro implements FormaGeometrica {
    private double raio;
    private double altura;
    private static final double PI = 3.14;

    public Cilindro(double raio, double altura) {
        this.raio = raio;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return 2 * PI * raio * raio + 2 * PI * raio * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 0; // Cilindro é 3D, não tem perímetro 2D
    }

    @Override
    public double calcularVolume() {
        return PI * raio * raio * altura;
    }

    @Override
    public String toString() {
        return "Cilindro [raio=" + raio + ", altura=" + altura + "]";
    }
}
