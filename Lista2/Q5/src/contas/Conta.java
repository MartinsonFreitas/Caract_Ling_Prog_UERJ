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
	
	// Getters e Setters
	public int getNumero() {
		return numero;
		}
	
	public String getTitular() {
		return titular;
	}
	public double getSaldo() {
		return saldo;
	}
		
	// Métodos
	public void deposita(double quantidade) {
		saldo += quantidade;
		}
	
	public boolean saca(double quantidade) {
		if(quantidade <= saldo) {
			saldo -= quantidade;
			return true;
		} else {
			System.out.println("Saldo insuficiente");
			return false;
		}
	}
	public void imprimirTipoConta() {
		System.out.println("Conta Corrente");
	}
	public void imprimirTipoConta(String msg) {
		System.out.println("Conta "+msg);
	}

	public boolean transferir(Conta destino, double valor) {
		if (this.saca(valor)) { // Tenta sacar da conta de origem
			destino.deposita(valor);
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + "]";
	}
			

}
