public class Triangulo {
    private double a, b, c;

    public Triangulo(double a, double b, double c) {
        if (ehValido(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            System.out.println("Triângulo inválido. Os lados fornecidos não formam um triângulo.");
        }
    }

    public boolean ehValido(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public String tipoTriangulo() {
        if (!ehValido(a, b, c)) {
            return "Inválido";
        }
        if (a == b && b == c) {
            return "Equilátero";
        } else if (a == b || a == c || b == c) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }

    public double calculaPerimetro() {
        if (!ehValido(a, b, c)) {
            return 0;
        }
        return a + b + c;
    }

    public double calculaArea() {
        if (!ehValido(a, b, c)) {
            return 0;
        }
        double p = calculaPerimetro() / 2; // Semiperímetro
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
