
public class TesteFuncionario {

	public static void main(String[] args) {
		Funcionario f1 = new Funcionario();
			f1.nome = "João";
			f1.dpto = "RH";
			f1.salario = 5000;
			f1.dataEntrada = "10/09/2020";
			f1.rg = "12345678";
			
			System.out.println(f1);
			f1.imprimir();
			
			f1.recebeAumento(800);
			f1.imprimir();
			
			System.out.println("Ganho anual: "+f1.calculaGanhoAnual());
			
			Funcionario f2 = new Funcionario("Maria");
			f2.imprimir();
	}


}


