public class Ponto2D {
    private double x;
    private double y;

    // Construtor default (i)
    public Ponto2D() {
        this(0.0, 0.0);
    }

    // Construtor com parâmetros (ii)
    public Ponto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Método para calcular a distância euclidiana
    public double calcularDistancia(Ponto2D outroPonto) {
        double deltaX = this.x - outroPonto.getX();
        double deltaY = this.y - outroPonto.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
