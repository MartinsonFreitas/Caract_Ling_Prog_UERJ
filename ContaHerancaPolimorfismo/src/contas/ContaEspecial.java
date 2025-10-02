package contas;

public class ContaEspecial extends Conta {
	//Atributos
	private double limite;

	//Contrutores
	public ContaEspecial(int numero, String titular, double limite) {
		super(numero, titular);
		this.limite = limite;
	}

	// getter e setters
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	//métodos
	@Override
	public void saca(double quantidade) {
        if(quantidade <= this.saldo + this.limite)
            this.saldo -= quantidade;
        else
            System.out.println("Saldo insuficiente");
	}
	@Override
	public void imprimirTipoConta() {
		System.out.println("Conta especial");
	}
	@Override
	public String toString() {
		return super.toString() + "[limite=" + limite + "]";
	}

}
