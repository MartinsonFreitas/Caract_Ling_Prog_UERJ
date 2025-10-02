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

	//getter e setters
	public int getNumero() {
		return this.numero;
	}

	public String getTitular() {
		return this.titular;
	}

	public double getSaldo() {
		return this.saldo;
	}
	
	//métodos
	public void deposita(double quantidade) {
		this.saldo +=quantidade;
	}

    public void saca(double quantidade) {
        if(quantidade <= saldo)
            saldo -= quantidade;
        else
            System.out.println("Saldo insuficiente");
    }
    public void imprimirTipoConta() {
    	System.out.println("Conta comum");
    }

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + "]";
	}
    
	    

}
