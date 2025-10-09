public class TesteTriangulo {
    public static void main(String[] args) {
        // Teste 1: Triângulo Equilátero válido
        Triangulo t1 = new Triangulo(5, 5, 5);
        System.out.println("\n--- Teste 1 (Equilátero) ---");
        System.out.println("É válido? " + t1.ehValido(5, 5, 5));
        System.out.println("Tipo: " + t1.tipoTriangulo());
        System.out.println("Perímetro: " + t1.calculaPerimetro());
        System.out.println("Área: " + t1.calculaArea());

        // Teste 2: Triângulo Isósceles válido
        Triangulo t2 = new Triangulo(5, 5, 8);
        System.out.println("\n--- Teste 2 (Isósceles) ---");
        System.out.println("É válido? " + t2.ehValido(5, 5, 8));
        System.out.println("Tipo: " + t2.tipoTriangulo());
        System.out.println("Perímetro: " + t2.calculaPerimetro());
        System.out.println("Área: " + t2.calculaArea());

        // Teste 3: Triângulo Escaleno válido
        Triangulo t3 = new Triangulo(3, 4, 5);
        System.out.println("\n--- Teste 3 (Escaleno) ---");
        System.out.println("É válido? " + t3.ehValido(3, 4, 5));
        System.out.println("Tipo: " + t3.tipoTriangulo());
        System.out.println("Perímetro: " + t3.calculaPerimetro());
        System.out.println("Área: " + t3.calculaArea());

        // Teste 4: Triângulo inválido (soma de dois lados menor que o terceiro)
        Triangulo t4 = new Triangulo(1, 2, 5);
        System.out.println("\n--- Teste 4 (Inválido) ---");
        System.out.println("É válido? " + t4.ehValido(1, 2, 5));
        System.out.println("Tipo: " + t4.tipoTriangulo());
        System.out.println("Perímetro: " + t4.calculaPerimetro());
        System.out.println("Área: " + t4.calculaArea());

        // Teste 5: Triângulo inválido (lados negativos/zero)
        Triangulo t5 = new Triangulo(-1, 2, 2);
        System.out.println("\n--- Teste 5 (Inválido com lados negativos) ---");
        System.out.println("É válido? " + t5.ehValido(-1, 2, 2));
        System.out.println("Tipo: " + t5.tipoTriangulo());
        System.out.println("Perímetro: " + t5.calculaPerimetro());
        System.out.println("Área: " + t5.calculaArea());
    }
}
