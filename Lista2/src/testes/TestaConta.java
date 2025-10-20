package testes;

import q5.*;

/*)​ Modifique a classe Teste de modo a provar todas as funcionalidades implementadas */

public class TestaConta {

    public static void main(String[] args) {
        // Testando Conta Corrente
    	
        System.out.println("--- Testando Conta Corrente ---");
        Conta cc = new Conta(101, "Alice", 1000.0);
        System.out.println(cc);
        System.out.println("Saldo inicial CC: " + cc.getSaldo());
        cc.deposita(200.0);
        System.out.println("Saldo após depósito CC: " + cc.getSaldo());
        cc.saca(300.0);
        System.out.println("Saldo após saque CC: " + cc.getSaldo());
        cc.saca(1500.0); // Saque insuficiente
        System.out.println("Saldo após saque insuficiente CC: " + cc.getSaldo());
        System.out.println(cc);

        // Testando Conta Poupança
        System.out.println("\n--- Testando Conta Poupança ---");
        ContaPoupanca cp = new ContaPoupanca(102, "Bob", 500.0);
        System.out.println(cp);
        System.out.println("Saldo inicial CP: " + cp.getSaldo());
        cp.deposita(100.0);
        System.out.println("Saldo após depósito CP: " + cp.getSaldo());
        cp.reajustar();
        System.out.println("Saldo após reajuste CP: " + cp.getSaldo());
        System.out.println(cp);

        // Testando Conta Especial
        System.out.println("\n--- Testando Conta Especial ---");
        ContaEspecial ce = new ContaEspecial(103, "Charlie", 2000.0, 500.0);
        System.out.println(ce);
        System.out.println("Saldo inicial CE: " + ce.getSaldo());
        System.out.println("Limite CE: " + ce.getLimite());
        ce.saca(2200.0); // Saque dentro do limite
        System.out.println("Saldo após saque CE (dentro limite): " + ce.getSaldo());
        ce.saca(500.0); // Saque que excede o limite
        System.out.println("Saldo após saque CE (excede limite): " + ce.getSaldo());
        System.out.println(ce);

        // Testando Transferência
        System.out.println("\n--- Testando Transferências ---");
        System.out.println("Saldo CC antes da transferência: " + cc.getSaldo());
        System.out.println("Saldo CP antes da transferência: " + cp.getSaldo());
        cc.transferir(cp, 100.0);
        System.out.println("Saldo CC após transferência para CP: " + cc.getSaldo());
        System.out.println("Saldo CP após transferência da CC: " + cp.getSaldo());

        System.out.println("Saldo CE antes da transferência: " + ce.getSaldo());
        System.out.println("Saldo CC antes da transferência: " + cc.getSaldo());
        ce.transferir(cc, 300.0); // Transferência de conta especial
        System.out.println("Saldo CE após transferência para CC: " + ce.getSaldo());
        System.out.println("Saldo CC após transferência da CE: " + cc.getSaldo());

        // Testando Banco
        System.out.println("\n--- Testando Banco ---");
        Banco banco = new Banco();
        banco.adicionarConta(cc);
        banco.adicionarConta(cp);
        banco.adicionarConta(ce);
        System.out.println("Quantidade de contas no banco: " + banco.getQuantidadeContas());
        banco.imprimirTodasContas();

        Conta contaEncontrada = banco.getContaPorNumero(102);
        if (contaEncontrada != null) {
            System.out.println("Conta encontrada pelo número 102: " + contaEncontrada);
        } else {
            System.out.println("Conta com número 102 não encontrada.");
        }

        contaEncontrada = banco.getContaPorNumero(999);
        if (contaEncontrada != null) {
            System.out.println("Conta encontrada pelo número 999: " + contaEncontrada);
        } else {
            System.out.println("Conta com número 999 não encontrada.");
        }
    }
}