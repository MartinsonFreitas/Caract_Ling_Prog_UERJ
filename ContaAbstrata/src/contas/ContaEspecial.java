package contas;

public class ContaEspecial extends Conta{
	// atributos
	private double limite;

	// Construtores
	public ContaEspecial(int numero, String titular, double limite) {
		super(numero, titular);
		this.limite = limite;
	}

	// Getters e Setters
	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	// Métodos
	@Override
	public void saca(double quantidade) {
		if(quantidade <= this.saldo + this.limite)
			this.saldo -= quantidade;
		else
			System.out.println("Saldo insuficiente");
	}
	
	@Override
	public String toString() {
		return super.toString() + "[limite=" + limite + "]";
	}
	
	@Override
	public void imprimirTipoConta() {
		System.out.println("Conta Especial");
	}
	

}
