package contas;

public class ContaPoupanca extends Conta {
    private static final double INDICE_REAJUSTE_MENSAL = 0.005; // 0.5%

    public ContaPoupanca(int numero, String titular) {
        super(numero, titular);
    }

    public ContaPoupanca(int numero, String titular, double saldoInicial) {
        super(numero, titular, saldoInicial);
    }

    public void reajustar() {
        this.saldo += this.saldo * INDICE_REAJUSTE_MENSAL;
        System.out.println("Saldo da Conta Poupança reajustado. Novo saldo: " + this.saldo);
    }

    @Override
    public void imprimirTipoConta() {
        System.out.println("Conta Poupança");
    }
}
