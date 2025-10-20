package q3;

public interface FormaGeometrica {
    double calcularArea();
    double calcularPerimetro(); // Para 2D, para 3D pode retornar 0 ou lançar exceção
    double calcularVolume(); // Para 3D, para 2D pode retornar 0 ou lançar exceção
}
