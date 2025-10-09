public class Circulo implements FormaGeometrica {
    private double raio;
    private static final double PI = 3.14;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return PI * raio * raio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * PI * raio;
    }

    @Override
    public double calcularVolume() {
        return 0; // Círculo é 2D, não tem volume
    }

    @Override
    public String toString() {
        return "Círculo [raio=" + raio + "]";
    }
}
