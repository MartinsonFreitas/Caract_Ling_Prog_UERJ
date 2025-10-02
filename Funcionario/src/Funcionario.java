
public class Funcionario {
	// atributos
	String nome;
	String dpto;
	double salario;
	String dataEntrada;
	String rg;
	static final double SALARIO_MINIMO = 1518;
	
	//construtores
	public Funcionario() {
		System.out.println("Funcionario criado...");
	}
	
	public Funcionario(String nome) {
		this.nome = nome;
		this.salario = SALARIO_MINIMO;
	}
	
	// Métodos
	void imprimir() {
		System.out.println("## Dados IMprimir ##");
		System.out.println("Nome: "+ this.nome);
		System.out.println("Departamento: " +this.dpto);
		System.out.println("Salário: "+this.salario);
		System.out.println("Data entrada: "+ this.dataEntrada);
		System.out.println("RG: "+ this.rg);		
	}
	
	@Override
	public String toString() {
		return "Funcionario [nome: " + nome + ", depto: " + dpto + " ]";
	}
	
	void recebeAumento(double valor) {
		this.salario +=valor;
	}
	
	double calculaGanhoAnual() {
		return this.salario * 12;
	}
}
