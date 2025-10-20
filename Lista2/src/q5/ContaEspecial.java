package q5;

public class ContaEspecial extends Conta{
	// atributos
	private double limite;

	// Construtores
	public ContaEspecial(int numero, String titular, double limite) {
		super(numero, titular);
		this.limite = limite;
	}

	public ContaEspecial(int numero, String titular, double saldoInicial, double limite) {
		super(numero, titular, saldoInicial);
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
	public boolean saca(double quantidade) {
		if(quantidade <= this.saldo + this.limite) {
			this.saldo -= quantidade;
			return true;
		} else {
			System.out.println("Saldo insuficiente");
			return false;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + "[limite=" + limite + "]";
	}
	
	/* Depois sobrescreva o método na classe ContaEspecial. */
	@Override
	public boolean transferir(Conta destino, double valor) {
		if (this.saca(valor)) { // Tenta sacar da conta de origem usando o saca de ContaEspecial
			destino.deposita(valor);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void imprimirTipoConta() {
		System.out.println("Conta Especial");
	}
	

}