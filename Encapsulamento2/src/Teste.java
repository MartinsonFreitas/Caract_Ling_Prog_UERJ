
public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Funcionario f1 = new Funcionario("Martinson Lima", "086108933");
		System.out.println(f1);
		f1.setDpto("RH");
		f1.setSalario(5000);
		System.out.println(f1);
		System.out.println("Salario: "+f1.getSalario());

	}

}
