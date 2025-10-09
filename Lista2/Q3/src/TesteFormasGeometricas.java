public class TesteFormasGeometricas {
    public static void main(String[] args) {
        Retangulo retangulo = new Retangulo(10, 5);
        Caixa caixa = new Caixa(10, 5, 3);
        Circulo circulo = new Circulo(7);
        Cilindro cilindro = new Cilindro(4, 10);

        System.out.println("--- Retângulo ---");
        System.out.println(retangulo);
        System.out.println("Área: " + retangulo.calcularArea());
        System.out.println("Perímetro: " + retangulo.calcularPerimetro());
        System.out.println("Volume: " + retangulo.calcularVolume());

        System.out.println("\n--- Caixa ---");
        System.out.println(caixa);
        System.out.println("Área: " + caixa.calcularArea());
        System.out.println("Perímetro: " + caixa.calcularPerimetro());
        System.out.println("Volume: " + caixa.calcularVolume());

        System.out.println("\n--- Círculo ---");
        System.out.println(circulo);
        System.out.println("Área: " + circulo.calcularArea());
        System.out.println("Perímetro: " + circulo.calcularPerimetro());
        System.out.println("Volume: " + circulo.calcularVolume());

        System.out.println("\n--- Cilindro ---");
        System.out.println(cilindro);
        System.out.println("Área: " + cilindro.calcularArea());
        System.out.println("Perímetro: " + cilindro.calcularPerimetro());
        System.out.println("Volume: " + cilindro.calcularVolume());
    }
}
