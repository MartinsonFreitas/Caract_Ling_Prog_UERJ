import java.time.LocalDate;

public class Funcionario {
	// Atributos
	private String nome;
	private String dpto;
	private double salario;
	private String dataEntrada;
	private String rg;
	private static final double SALARIO_MINIMO = 1518; // constante
	
	// construtores
	public Funcionario(String nome, String rg) {
		//super();
		this.nome = nome;
		this.rg = rg;
		this.salario = SALARIO_MINIMO;
		this.dataEntrada = LocalDate.now().toString();
	}

	public Funcionario(String nome, String dpto, double salario, String dataEntrada, String rg) {
		super();
		this.nome = nome;
		this.dpto = dpto;
		this.salario = salario;
		this.dataEntrada = dataEntrada;
		this.rg = rg;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", dpto=" + dpto + ", salario=" + salario + ", dataEntrada=" + dataEntrada
				+ ", rg=" + rg + "]";
	}

	
	// getter e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDpto() {
		return dpto;
	}

	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}
	
	
	
	

}
