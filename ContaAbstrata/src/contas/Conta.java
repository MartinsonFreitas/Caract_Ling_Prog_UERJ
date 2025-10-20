package contas;

public class Conta {
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
	
	
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
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
