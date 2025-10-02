package contas;

public class ContaPoupanca extends Conta{

	//Construtores
	public ContaPoupanca(int numero, String titular) {
		super(numero, titular);
	}
	//Métodos
	public void reajustar(double percentual) {
		double reajuste = this.getSaldo()*percentual;
		this.deposita(reajuste);
	}
	
	@Override
	public void imprimirTipoConta() {
		System.out.println("Conta poupança");
	}

}
