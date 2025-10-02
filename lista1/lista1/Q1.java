/*
 * Q1. O perfil de uma pessoa pode ser determinado a partir da sua data de nascimento, 
 * conforme exemplificado a seguir. Crie um programa em Java que dada uma data de nascimento 
 * (3 inteiros positivos) e retorne o perfil correspondente.
 * 
 * 0 -> Timido
 * 1 -> Sonhador
 * 2 -> Paquerador
 * 3 -> Atraente
 * 4 -> Irresistível
 * 
 * Exemplo: 13/06/1970 ==> 1306 + 1970 = 3276 ==> 32 + 76 = 108 ==> 108 % 5 = 3 
 * 
 * Assim o perfil é = Atraente
 * 
 */
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a data de nascimento: ");

        System.out.print("Dia (##): ");
        int dia = scanner.nextInt();

        System.out.print("Mês (##): ");
        int mes = scanner.nextInt();

        System.out.print("Ano (####): ");
        int ano = scanner.nextInt();

        // Validação
        if (dia <= 0 || mes <= 0 || ano <= 0) {
            System.out.println("Por favor, insira a data de nascimento: ");
            scanner.close();
            return;
        }

        // Concatena dia e mês, depois soma com o ano.        
        int soma = (dia * 100 + mes) + ano;

     // Para mapear nos números 0 a 4 da tabela
        int perfil = soma % 5;

        
        System.out.println("\nProcessando a data de nascimento " + dia + "/" + mes + "/" + ano + "...");
        System.out.println("Cálculo inicial: (" + dia + "*" + 100 + " + " + mes + ") + " + ano + " = " + soma);
        
        System.out.println("Número do perfil (módulo 5): " + perfil);
        
        if (perfil == 0) {
        	System.out.println("Seu perfil é "+ perfil +" que corresponde a uma pessoa tímida.");
        } else if (perfil == 1) {
        	System.out.println("Seu perfil é "+ perfil +" que corresponde a uma pessoa sonhadora.");
        } else if (perfil == 2) {
        	System.out.println("Seu perfil é "+ perfil +" que corresponde a uma pessoa paqueradora.");
        } else if (perfil == 3) {
        	System.out.println("Seu perfil é "+ perfil +" que corresponde a uma pessoa atraente.");
        } else {
        	System.out.println("Seu perfil é "+ perfil +" que corresponde a uma pessoa irresistível.");
        }
        
        scanner.close();
    }    
    
}

