package contas;

public abstract class Conta {
	// Atributos
	private int numero;
	private String titular;
	protected double saldo;
	
	// Construtores
	public Conta(int numero, String titular) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = 0;
	}
	
	public Conta(int numero, String titular, double saldoInicial) {
		this.numero = numero;
		this.titular = titular;
		this.deposita(saldoInicial);
	}
	
	
	// Métodos
	public void deposita(double quantidade) {
		saldo += quantidade;
		}
	
	public void saca(double quantidade) {
		if(quantidade <= saldo)
			saldo -= quantidade;
		else
			System.out.println("Saldo insuficiente");
	}
	public void imprimirTipoConta() {
		System.out.println("Conta Corrente");
	}
	public void imprimirTipoConta(String msg) {
		System.out.println("Conta "+msg);
	}
	
	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + "]";
	}
			

}
